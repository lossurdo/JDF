package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: SuffixRestriction.java,v 1.2 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class SuffixRestriction extends RestrictionImpl {

    private static final long serialVersionUID = -2432861729211751534L;

    private String property;
    private String suffix;

    public SuffixRestriction(String property, String suffix) {
        this.property = property;
        this.suffix = suffix;
    }

    public void build(CriteriaBuffer buffer) {
        buffer.appendAliased(property).append(suffix);
    }
}
