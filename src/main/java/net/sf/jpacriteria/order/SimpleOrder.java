package net.sf.jpacriteria.order;

import java.util.Arrays;
import java.util.List;

/**
 * @author Maxim Butov
 * @version $Id: SimpleOrder.java,v 1.5 2007/03/24 15:29:54 maxim_butov Exp $
 */
public class SimpleOrder extends OrderImpl<SimpleOrder> {

    private String property;
    private OrderDirection direction;
    private Integer priority;

    public SimpleOrder(String property, OrderDirection order) {
        this(property, order, 0);
    }

    public SimpleOrder(SimpleOrder order) {
        this(order.getProperty(), order.getDirection(), order.getPriority());
    }

    public SimpleOrder(String property, OrderDirection order, int priority) {
        this.property = property;
        this.direction = order;
        this.priority = priority;
    }

    public String getProperty() {
        return property;
    }

    public OrderDirection getDirection() {
        return direction;
    }

    public int getPriority() {
        return priority;
    }

    public SimpleOrder up(int n) {
        return new SimpleOrder(property, direction, priority - n);
    }

    public List<SimpleOrder> orders() {
        return Arrays.asList(this);
    }
}
