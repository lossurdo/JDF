package net.sf.jpacriteria.select;

import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: AliasedSelection.java,v 1.2 2007/03/25 00:32:51 maxim_butov Exp $
 */
public class AliasedSelection extends SimpleSelection {

    private String alias;

    public AliasedSelection(String alias, String property) {
        super(property);
        this.alias = alias;
    }

    public void build(CriteriaBuffer buffer) {
        CriteriaBuffer b = buffer.newBuffer();
        super.build(b);
        buffer.append(b);
    }
}
