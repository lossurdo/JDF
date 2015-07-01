package net.sf.jpacriteria.order;

import java.io.Serializable;

/**
 * @author Maxim Butov
 * @version $Id: OrderImpl.java,v 1.12 2007/09/02 15:06:11 maxim_butov Exp $
 */
public abstract class OrderImpl<T extends Order> implements Order<T>, Serializable {

    public Order append(Order order) {
        return new ComplexOrder(this, order);
    }

    public Order order(String property, OrderDirection direction) {
        return append(Orders.order(property, direction));
    }

    public Order order(String property, OrderDirection direction, int priority) {
        return append(Orders.order(property, direction, priority));
    }

    public final T up() {
        return up(1);
    }

    public final T down() {
        return up(-1);
    }

    public final T down(int n) {
        return up(-n);
    }
}
