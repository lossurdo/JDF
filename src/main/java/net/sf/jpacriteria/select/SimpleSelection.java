package net.sf.jpacriteria.select;

import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: SimpleSelection.java,v 1.2 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class SimpleSelection extends SelectionImpl {

    private static final long serialVersionUID = 6009436444872235366L;

    private String property;

    public SimpleSelection(String property) {
        this.property = property;
    }

    public void build(CriteriaBuffer buffer) {
        buffer.appendAliased(property);
    }
}
