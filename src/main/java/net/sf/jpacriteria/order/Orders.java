package net.sf.jpacriteria.order;

/**
 * @author Maxim Butov
 * @version $Id: Orders.java,v 1.5 2007/08/02 14:16:14 maxim_butov Exp $
 */
public class Orders {

    public static Order order(String property, OrderDirection direction) {
        return new SimpleOrder(property, direction);
    }

    public static Order order(String property, OrderDirection direction, int priority) {
        return new SimpleOrder(property, direction, priority);
    }

    public static Order order(String alias, String property, OrderDirection direction) {
        return new AliasedSimpleOrder(alias, property, direction);
    }

    public static Order order(String alias, String property, OrderDirection direction, int priority) {
        return new AliasedSimpleOrder(alias, property, direction, priority);
    }

    public static Order join(Order order, Order... orders) {
        return new ComplexOrder(order, orders);
    }

    private Orders() {
    }
}
