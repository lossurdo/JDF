package net.sf.jpacriteria.order;

import net.sf.jpacriteria.Sequential;

import java.util.List;

/**
 * @author Maxim Butov
 * @version $Id: Order.java,v 1.8 2007/03/30 23:15:51 maxim_butov Exp $
 */
public interface Order<T extends Order> extends Sequential<Order> {

    List<SimpleOrder> orders();

    T up();

    T up(int n);

    T down();

    T down(int n);
}
