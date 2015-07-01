package net.sf.jpacriteria;

import net.sf.jpacriteria.aggregation.Aggregation;
import net.sf.jpacriteria.aggregation.Aggregations;
import net.sf.jpacriteria.builder.UniqueIdentifiers;
import net.sf.jpacriteria.join.Join;
import net.sf.jpacriteria.order.Order;
import net.sf.jpacriteria.order.Orders;
import net.sf.jpacriteria.reference.Reference;
import net.sf.jpacriteria.reference.References;
import net.sf.jpacriteria.restriction.Restriction;
import net.sf.jpacriteria.restriction.Restrictions;
import net.sf.jpacriteria.select.Selection;
import net.sf.jpacriteria.select.Selections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Maxim Butov
 * @version $Id: BasicCriteriaImpl.java,v 1.11 2007/09/24 09:40:23 maxim_butov Exp $
 */
public abstract class BasicCriteriaImpl<T extends BasicCriteria> implements BasicCriteria<T>, Cloneable, Serializable {

    protected String from;
    protected String alias;
    protected Selection selection;
    protected Aggregation aggregation;
    protected Collection<Join> joins = new ArrayList<Join>();
    protected Restriction where;
    protected Selection groups;
    protected Restriction having;
    protected Order order;

    protected BasicCriteriaImpl(String from) {
        this(from, null);
    }

    protected BasicCriteriaImpl(String from, String alias) {
        this.from = from;
        if (alias == null) {
            alias = UniqueIdentifiers.generate("obj", this);
        }
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public String getFrom() {
        return from;
    }

    public Selection getSelection() {
        return selection;
    }

    public Aggregation getAggregation() {
        return aggregation;
    }

    public Collection<Join> getJoins() {
        return joins;
    }

    public Restriction getWhere() {
        return where;
    }

    public Selection getGroups() {
        return groups;
    }

    public Restriction getHaving() {
        return having;
    }

    public Order getOrder() {
        return order;
    }

    protected T self() {
        return (T) this;
    }

    public T select(Selection selection, Selection... selections) {
        selection = Selections.join(selection, selections);
        this.selection = this.selection == null ? selection : Selections.join(this.selection, selection);
        return self();
    }

    public T aggregate(Aggregation aggregation, Aggregation... aggregations) {
        aggregation = Aggregations.join(aggregation, aggregations);
        this.aggregation = this.aggregation == null ? aggregation : Aggregations.join(this.aggregation, aggregation);
        return self();
    }

    public T join(Join join, Join... joins) {
        this.joins.add(join);
        this.joins.addAll(Arrays.asList(joins));
        return self();
    }

    public T where(Restriction restriction, Restriction... restrictions) {
        restriction = Restrictions.and(restriction, restrictions);
        this.where = this.where == null ? restriction : Restrictions.and(this.where, restriction);
        return self();
    }

    public T group(Selection selection, Selection... selections) {
        selection = Selections.join(selection, selections);
        this.groups = this.groups == null ? selection : Selections.join(this.groups, selection);
        return self();
    }

    public T having(Restriction restriction, Restriction... restrictions) {
        restriction = Restrictions.and(restriction, restrictions);
        this.having = this.having == null ? restriction : Restrictions.and(this.having, restriction);
        return self();
    }

    public T order(Order order, Order... orders) {
        order = Orders.join(order, orders);
        this.order = this.order == null ? order : Orders.join(this.order, order);
        return self();
    }

    public Reference getProperty(String name) {
        return References.reference(getAlias(), name);
    }

    public T copy() {
        try {
            return (T) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
