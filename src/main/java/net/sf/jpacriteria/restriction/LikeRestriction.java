package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.parameter.Parameter;
import net.sf.jpacriteria.parameter.Parameters;

/**
 * @author Maxim Butov
 * @version $Id: LikeRestriction.java,v 1.2 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class LikeRestriction extends RestrictionImpl {

    private static final long serialVersionUID = -7031028114985541131L;

    private String property;
    private Parameter parameter;
    private boolean caseInsensitive = false;

    public LikeRestriction(String property, String value, boolean caseInsensitive) {
        this(property, Parameters.value(value), caseInsensitive);
    }

    public LikeRestriction(String property, Parameter<String> value, boolean caseInsensitive) {
        this.property = property;
        this.parameter = value;
        this.caseInsensitive = caseInsensitive;
        if (caseInsensitive) {
            parameter = Parameters.value(value.getValue().toLowerCase());
        }
    }

    public void build(CriteriaBuffer buffer) {
        CriteriaBuffer b = buffer.newBuffer();
        b.appendAliased(property);
        if (caseInsensitive) {
            b.enclose(ReservedIdentifier.LOWER);
        }
        b.append(ReservedIdentifier.LIKE).append(parameter);
        buffer.append(b);
    }
}
