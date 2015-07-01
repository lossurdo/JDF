package net.sf.jpacriteria.order;

import net.sf.jpacriteria.alias.Aliased;
import net.sf.jpacriteria.builder.CriteriaBlock;
import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: AliasedSimpleOrder.java,v 1.5 2007/03/30 23:15:51 maxim_butov Exp $
 */
public class AliasedSimpleOrder extends SimpleOrder implements Aliased, CriteriaBlock {

    private String alias;

    public AliasedSimpleOrder(String alias, String property, OrderDirection order) {
        super(property, order);
        this.alias = alias;
    }

    public AliasedSimpleOrder(String alias, String property, OrderDirection order, int priority) {
        super(property, order, priority);
        this.alias = alias;
    }

    public AliasedSimpleOrder(String alias, SimpleOrder order) {
        super(order);
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public SimpleOrder up(int n) {
        return new AliasedSimpleOrder(alias, getProperty(), getDirection(), getPriority() - n);
    }

    public void build(CriteriaBuffer buffer) {
        buffer.appendAliased(getAlias(), getProperty()).append(getDirection());
    }
}
