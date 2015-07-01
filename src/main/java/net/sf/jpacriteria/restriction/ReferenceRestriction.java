package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.operator.Operator;
import net.sf.jpacriteria.parameter.Parameter;
import net.sf.jpacriteria.parameter.Parameters;
import net.sf.jpacriteria.reference.Reference;

/**
 * @author Maxim Butov
 * @version $Id: ReferenceRestriction.java,v 1.1 2007/03/26 14:04:37 maxim_butov Exp $
 */
public class ReferenceRestriction extends RestrictionImpl {

    private Reference reference;
    private Operator operator;
    private Parameter parameter;

    public ReferenceRestriction(Reference reference, Operator operator, Object value) {
        this(reference, operator, Parameters.value(value));
    }

    public ReferenceRestriction(Reference reference, Operator operator, Parameter parameter) {
        this.reference = reference;
        this.operator = operator;
        this.parameter = parameter;
    }

    public void build(CriteriaBuffer buffer) {
        buffer.append(reference).append(operator).append(parameter);
    }
}
