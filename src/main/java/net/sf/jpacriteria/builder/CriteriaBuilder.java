package net.sf.jpacriteria.builder;

import net.sf.jpacriteria.BasicCriteria;
import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.argument.Argument;
import net.sf.jpacriteria.argument.ArgumentImpl;
import net.sf.jpacriteria.configuration.Configuration;
import net.sf.jpacriteria.configuration.Configurations;
import net.sf.jpacriteria.join.EarlierJoin;
import net.sf.jpacriteria.join.Join;
import net.sf.jpacriteria.join.LateJoin;
import net.sf.jpacriteria.order.AliasedSimpleOrder;
import net.sf.jpacriteria.order.Order;
import net.sf.jpacriteria.order.SimpleOrder;
import net.sf.jpacriteria.select.Selection;
import net.sf.jpacriteria.select.Selections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Maxim Butov
 * @version $Id: CriteriaBuilder.java,v 1.22 2007/09/24 09:40:23 maxim_butov Exp $
 */
public class CriteriaBuilder {

    private Configuration configuration = Configurations.getConfiguration();
    private Criteria criteria;
    private Argument argument = new ArgumentImpl();

    public CriteriaBuilder(Criteria criteria) {
        this.criteria = criteria;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public Argument getArgument() {
        return argument;
    }

    public CriteriaBuffer newBuffer() {
        return newBuffer(criteria.getAlias());
    }

    public CriteriaBuffer newBuffer(String alias) {
        return new CriteriaBuffer(this, alias);
    }

    private CriteriaBuffer buildJoinSelect(Join<?> join) {
        CriteriaBuffer buffer = newBuffer(join.getAlias());

        if (join.getSelection() != null) {
            join.getSelection().build(buffer);
        }

        for (Join j : join.getJoins()) {
            CriteriaBuffer joinBuffer = buildJoinSelect(j);
            if (!joinBuffer.isEmpty()) {
                if (!buffer.isEmpty()) {
                    buffer.appendComma();
                }
                buffer.append(joinBuffer);
            }
        }

        if (join.getAggregation() != null) {
            join.getAggregation().build(buffer);
        }

        return buffer;
    }

    private CriteriaBuffer buildSelect() {
        List<CriteriaBuffer> joinBuffers = new ArrayList<CriteriaBuffer>();

        for (Join join : criteria.getJoins()) {
            CriteriaBuffer jb = buildJoinSelect(join);
            if (!jb.isEmpty()) {
                joinBuffers.add(jb);
            }
        }

        CriteriaBuffer buffer = newBuffer();
        Selection selection = criteria.getSelection();

        if (joinBuffers.isEmpty()) {
            if (selection == null) {
                selection = Selections.object();
            }
        }

        if (selection != null) {
            buffer.append(selection);
        }

        for (CriteriaBuffer jb : joinBuffers) {
            if (!buffer.isEmpty()) {
                buffer.appendComma();
            }
            buffer.append(jb);
        }

        if (criteria.getAggregation() != null) {
            criteria.getAggregation().build(buffer);
        }

        return newBuffer().append(ReservedIdentifier.SELECT).append(buffer);
    }

    private static Integer joinIndex(Join join) {
        if (join instanceof EarlierJoin) {
            return 0;
        } else if (join instanceof LateJoin) {
            LateJoin lateJoin = (LateJoin) join;
            switch (lateJoin.getType()) {
                case INNER:
                    return 1;
                case OUTER:
                    return 2;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static final Comparator<Join> JOIN_COMPARATOR = new Comparator<Join>() {
        public int compare(Join j1, Join j2) {
            return joinIndex(j1).compareTo(joinIndex(j2));
        }
    };

    private CriteriaBuffer buildJoinFrom(String alias, Join<?> join) {
        CriteriaBuffer buffer = newBuffer(join.getAlias());
        if (join instanceof EarlierJoin) {
            buffer
                    .appendAliased(alias, join.getFrom())
                    .enclose(ReservedIdentifier.IN);
            if (configuration.useAsInEarlierJoin()) {
                buffer.append(ReservedIdentifier.AS);
            }
            buffer.append(join.getAlias());
            buffer.insert(',');
        } else if (join instanceof LateJoin) {
            buffer.appendAliased(alias, join.getFrom());
            LateJoin lateJoin = (LateJoin) join;
            CriteriaBuffer b = newBuffer();
            switch (lateJoin.getType()) {
                case INNER:
                    if (configuration.useInnerWithJoin()) {
                        b.append(ReservedIdentifier.INNER);
                    }
                    break;
                case OUTER:
                    b.append(ReservedIdentifier.LEFT);
                    if (configuration.useOuterWithLeftJoin()) {
                        b.append(ReservedIdentifier.OUTER);
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            b.append(ReservedIdentifier.JOIN);
            if (lateJoin.isFetch()) {
                b.append(ReservedIdentifier.FETCH);
            }
            buffer.insert(b);
            if (configuration.useAsInLateJoin()) {
                buffer.append(ReservedIdentifier.AS);
            }
            buffer.append(join.getAlias());
        } else {
            throw new IllegalArgumentException();
        }
        List<Join> joins = new ArrayList<Join>(join.getJoins());
        Collections.sort(joins, JOIN_COMPARATOR);
        for (Join j : joins) {
            buffer.append(buildJoinFrom(join.getAlias(), j));
        }
        return buffer;
    }

    private CriteriaBuffer buildFrom() {
        CriteriaBuffer buffer = newBuffer();
        buffer.append(criteria.getFrom());
        if (configuration.useAsInFrom()) {
            buffer.append(ReservedIdentifier.AS);
        }
        buffer.append(criteria.getAlias());
        for (Join join : criteria.getJoins()) {
            buffer.append(buildJoinFrom(criteria.getAlias(), join));
        }
        return newBuffer().append(ReservedIdentifier.FROM).append(buffer);
    }

    private CriteriaBuffer buildWhere(BasicCriteria<?> c) {
        CriteriaBuffer buffer = newBuffer(c.getAlias());
        if (c.getWhere() != null) {
            c.getWhere().build(buffer);
        }
        for (Join j : c.getJoins()) {
            CriteriaBuffer jw = buildWhere(j);
            if (!jw.isEmpty()) {
                if (!buffer.isEmpty()) {
                    buffer.enclose().append(ReservedIdentifier.AND);
                    jw.enclose();
                }
                buffer.append(jw);
            }
        }
        return buffer;
    }

    private CriteriaBuffer buildWhere() {
        CriteriaBuffer buffer = buildWhere(criteria);
        if (!buffer.isEmpty()) {
            buffer = newBuffer().append(ReservedIdentifier.WHERE).append(buffer);
        }
        return buffer;
    }

    private CriteriaBuffer buildJoinGroupBy(Join<?> join) {
        CriteriaBuffer buffer = newBuffer(join.getAlias());

        if (join.getGroups() != null) {
            join.getGroups().build(buffer);
        }

        for (Join j : join.getJoins()) {
            CriteriaBuffer joinBuffer = buildJoinGroupBy(j);
            if (!joinBuffer.isEmpty()) {
                buffer.appendComma().append(joinBuffer);
            }
        }

        return buffer;
    }

    private CriteriaBuffer buildGroupBy() {
        CriteriaBuffer buffer = newBuffer();

        if (criteria.getGroups() != null) {
            buffer.append(criteria.getGroups());
        }

        List<CriteriaBuffer> joinBuffers = new ArrayList<CriteriaBuffer>();

        for (Join join : criteria.getJoins()) {
            CriteriaBuffer jb = buildJoinGroupBy(join);
            if (!jb.isEmpty()) {
                joinBuffers.add(jb);
            }
        }

        for (CriteriaBuffer jb : joinBuffers) {
            buffer.appendComma().append(jb);
        }

        if (!buffer.isEmpty()) {
            buffer = newBuffer().append(ReservedIdentifier.GROUP_BY).append(buffer);
        }

        return buffer;
    }

    private CriteriaBuffer buildHaving(BasicCriteria<?> c) {
        CriteriaBuffer buffer = newBuffer(c.getAlias());
        if (c.getHaving() != null) {
            c.getHaving().build(buffer);
        }
        for (Join j : c.getJoins()) {
            CriteriaBuffer jw = buildHaving(j);
            if (!jw.isEmpty()) {
                if (!buffer.isEmpty()) {
                    buffer.enclose().append(ReservedIdentifier.AND);
                    jw.enclose();
                }
                buffer.append(jw);
            }
        }
        return buffer;
    }

    private CriteriaBuffer buildHaving() {
        CriteriaBuffer buffer = buildHaving(criteria);
        if (!buffer.isEmpty()) {
            buffer = newBuffer().append(ReservedIdentifier.HAVING).append(buffer);
        }
        return buffer;
    }

    private void addOrders(Map<Integer, List<AliasedSimpleOrder>> orders, BasicCriteria<?> criteria) {
        Order<?> order = criteria.getOrder();
        if (order != null) {
            for (SimpleOrder so : order.orders()) {
                int priority = so.getPriority();
                List<AliasedSimpleOrder> list = orders.get(priority);
                if (list == null) {
                    list = new ArrayList<AliasedSimpleOrder>();
                    orders.put(priority, list);
                }
                AliasedSimpleOrder aso = so instanceof AliasedSimpleOrder ? (AliasedSimpleOrder) so :
                        new AliasedSimpleOrder(criteria.getAlias(), so);
                list.add(aso);
            }
        }
        for (Join join : criteria.getJoins()) {
            addOrders(orders, join);
        }
    }

    private CriteriaBuffer buildOrderBy() {
        SortedMap<Integer, List<AliasedSimpleOrder>> orders = new TreeMap<Integer, List<AliasedSimpleOrder>>();
        addOrders(orders, criteria);

        CriteriaBuffer buffer = newBuffer();
        for (int priority : orders.keySet()) {
            for (AliasedSimpleOrder order : orders.get(priority)) {
                if (!buffer.isEmpty()) {
                    buffer.appendComma();
                }
                buffer.append(order);
            }
        }

        if (!buffer.isEmpty()) {
            buffer = newBuffer().append(ReservedIdentifier.ORDER_BY).append(buffer);
        }

        return buffer;
    }

    @Override
    public String toString() {
        return
                newBuffer()
                        .append(buildSelect())
                        .append(buildFrom())
                        .append(buildWhere())
                        .append(buildGroupBy())
                        .append(buildHaving())
                        .append(buildOrderBy())
                        .toString();
    }
}
