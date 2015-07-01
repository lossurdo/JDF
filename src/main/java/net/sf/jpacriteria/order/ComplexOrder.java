package net.sf.jpacriteria.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Maxim Butov
 * @version $Id: ComplexOrder.java,v 1.5 2007/09/21 08:26:18 maxim_butov Exp $
 */
public class ComplexOrder extends OrderImpl<ComplexOrder> {

    private static final long serialVersionUID = 2621180929371869366L;

    private List<SimpleOrder> orders;

    public ComplexOrder(Order order, Order... orders) {
        this.orders = new ArrayList<SimpleOrder>();
        this.orders.addAll(order.orders());
        for (Order o : orders) {
            this.orders.addAll(o.orders());
        }
        this.orders = Collections.unmodifiableList(this.orders);
    }

    private ComplexOrder(List<SimpleOrder> orders) {
        this.orders = orders;
    }

    public List<SimpleOrder> orders() {
        return orders;
    }

    public ComplexOrder up(int n) {
        SimpleOrder[] simpleOrders = orders.toArray(new SimpleOrder[orders.size()]);
        int last = simpleOrders.length - 1;
        simpleOrders[last] = simpleOrders[last].up(n);
        return new ComplexOrder(Arrays.asList(simpleOrders));
    }
}
