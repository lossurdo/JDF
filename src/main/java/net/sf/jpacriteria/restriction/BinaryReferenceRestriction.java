package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.operator.Operator;
import net.sf.jpacriteria.reference.Reference;

/**
 * @author Maxim Butov
 * @version $Id: BinaryReferenceRestriction.java,v 1.2 2007/04/02 10:39:28 maxim_butov Exp $
 */
public class BinaryReferenceRestriction extends RestrictionImpl {

    private String property;
    private Operator operator;
    private Reference reference;

    public BinaryReferenceRestriction(String property, Operator operator, Reference reference) {
        this.property = property;
        this.operator = operator;
        this.reference = reference;
    }

    public void build(CriteriaBuffer buffer) {
        buffer.appendAliased(property).append(operator).append(reference);
    }
}
