package net.sf.jpacriteria.order;

import net.sf.jpacriteria.builder.CriteriaBlock;
import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: OrderDirection.java,v 1.4 2007/03/18 23:17:57 maxim_butov Exp $
 */
public enum OrderDirection implements CriteriaBlock {

    ASC, DESC,;

    public void build(CriteriaBuffer buffer) {
        buffer.append(name());
    }
}
