package net.sf.jpacriteria;

import net.sf.jpacriteria.aggregation.Aggregation;
import net.sf.jpacriteria.alias.Aliased;
import net.sf.jpacriteria.join.Join;
import net.sf.jpacriteria.order.Order;
import net.sf.jpacriteria.reference.Reference;
import net.sf.jpacriteria.restriction.Restriction;
import net.sf.jpacriteria.select.Selection;

import java.util.Collection;

/**
 * @author Maxim Butov
 * @version $Id: BasicCriteria.java,v 1.7 2007/04/04 22:44:40 maxim_butov Exp $
 */
public interface BasicCriteria<T extends BasicCriteria> extends Aliased, CriteriaObject<T> {

    String getFrom();

    Selection getSelection();

    Aggregation getAggregation();

    Collection<Join> getJoins();

    Restriction getWhere();

    Selection getGroups();

    Restriction getHaving();

    Order getOrder();

    T select(Selection selection, Selection... selections);

    T aggregate(Aggregation aggregation, Aggregation... aggregations);

    T join(Join join, Join... joins);

    T where(Restriction where, Restriction... restrictions);

    T group(Selection selection, Selection... selections);

    T having(Restriction restriction, Restriction... restrictions);

    T order(Order order, Order... orders);

    Reference getProperty(String name);
}
