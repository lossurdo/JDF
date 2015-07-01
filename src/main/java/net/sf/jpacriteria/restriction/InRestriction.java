package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.parameter.CollectionParameter;

import java.util.Collection;

/**
 * @author Maxim Butov
 * @version $Id: InRestriction.java,v 1.4 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class InRestriction extends RestrictionImpl {

    private static final long serialVersionUID = -4658529410907292883L;

    private String property;
    private CollectionParameter parameter;

    public InRestriction(String property, CollectionParameter parameter) {
        this.property = property;
        this.parameter = parameter;
    }

    public InRestriction(String property, Collection collection) {
        this(property, new CollectionParameter(collection));
    }

    public InRestriction(String property, Object... values) {
        this(property, new CollectionParameter(values));
    }

    public void build(CriteriaBuffer buffer) {
        if (parameter.isEmpty()) {
            // false expression
            Restrictions.falseRestriction(property).build(buffer);
        } else {
            buffer.appendAliased(property).append(ReservedIdentifier.IN).append(parameter);
        }
    }
}
