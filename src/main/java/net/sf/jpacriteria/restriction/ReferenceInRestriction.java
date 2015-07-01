package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.parameter.CollectionParameter;
import net.sf.jpacriteria.reference.Reference;

import java.util.Collection;

/**
 * @author Maxim Butov
 * @version $Id: ReferenceInRestriction.java,v 1.2 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class ReferenceInRestriction extends RestrictionImpl {

    private static final long serialVersionUID = 7752494481062776052L;

    private Reference reference;
    private CollectionParameter parameter;

    public ReferenceInRestriction(Reference reference, CollectionParameter parameter) {
        this.reference = reference;
        this.parameter = parameter;
    }

    public ReferenceInRestriction(Reference reference, Collection collection) {
        this(reference, new CollectionParameter(collection));
    }

    public ReferenceInRestriction(Reference reference, Object... values) {
        this(reference, new CollectionParameter(values));
    }

    public void build(CriteriaBuffer buffer) {
        if (parameter.isEmpty()) {
            // false expression
            throw new RuntimeException("Not implemented yet");
        } else {
            buffer.appendAliased(reference.getAlias(), reference.getName()).append(ReservedIdentifier.IN).append(parameter);
        }
    }
}
