package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.operator.Operator;

/**
 * @author Maxim Butov
 * @version $Id: BinarySubCriteriaRestriction.java,v 1.3 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class BinarySubCriteriaRestriction extends RestrictionImpl {

    private static final long serialVersionUID = -1617830242369069225L;

    private String property;
    private Operator operator;
    private Criteria subCriteria;

    public BinarySubCriteriaRestriction(String property, Operator operator, Criteria subCriteria) {
        this.property = property;
        this.operator = operator;
        this.subCriteria = subCriteria.compile();
    }

    public void build(CriteriaBuffer buffer) {
        CriteriaBuffer subBuffer = buffer.newBuffer();
        subBuffer.append(subCriteria.toQueryString()).enclose();
        buffer.getArgument().add(subCriteria.getArgument());
        buffer.appendAliased(property).append(operator).append(subBuffer);
    }
}
