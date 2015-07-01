package net.sf.jpacriteria.select;

import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: ObjectSelection.java,v 1.3 2007/04/02 10:39:28 maxim_butov Exp $
 */
public class ObjectSelection extends SelectionImpl {

    public void build(CriteriaBuffer buffer) {
        buffer.appendAliased(null);
    }
}
