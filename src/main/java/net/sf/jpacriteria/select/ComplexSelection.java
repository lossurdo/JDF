package net.sf.jpacriteria.select;

import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: ComplexSelection.java,v 1.2 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class ComplexSelection extends SelectionImpl {

    private static final long serialVersionUID = -6519344584803634981L;

    private Selection selection1;
    private Selection selection2;

    public ComplexSelection(Selection selection1, Selection selection2) {
        this.selection1 = selection1;
        this.selection2 = selection2;
    }

    public void build(CriteriaBuffer buffer) {
        buffer.append(selection1).appendComma().append(selection2);
    }
}
