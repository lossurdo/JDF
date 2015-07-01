package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.operator.Operator;
import net.sf.jpacriteria.parameter.Parameter;
import net.sf.jpacriteria.parameter.Parameters;

/**
 * @author Maxim Butov
 * @version $Id: BinaryRestriction.java,v 1.4 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class BinaryRestriction extends RestrictionImpl {

    private static final long serialVersionUID = 8337842994054617505L;

    private String property;
    private Operator operator;
    private Parameter parameter;

    public BinaryRestriction(String property, Operator operator, Parameter parameter) {
        this.property = property;
        this.operator = operator;
        this.parameter = parameter;
    }

    public BinaryRestriction(String property, Operator operator, Object value) {
        this(property, operator, Parameters.value(value));
    }

    public void build(CriteriaBuffer buffer) {
        buffer.appendAliased(property).append(operator).append(parameter);
    }
}
