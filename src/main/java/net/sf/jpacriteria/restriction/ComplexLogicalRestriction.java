package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.operator.BinaryLogicalOperator;

/**
 * @author Maxim Butov
 * @version $Id: ComplexLogicalRestriction.java,v 1.2 2007/03/25 20:59:37 maxim_butov Exp $
 */
public class ComplexLogicalRestriction extends RestrictionImpl {

    private Restriction restriction1;
    private BinaryLogicalOperator operator;
    private Restriction restriction2;

    public ComplexLogicalRestriction(Restriction restriction1, BinaryLogicalOperator operator, Restriction restriction2) {
        this.restriction1 = restriction1;
        this.operator = operator;
        this.restriction2 = restriction2;
    }

    public void build(CriteriaBuffer buffer) {
        CriteriaBuffer b1 = buffer.newBuffer().append(restriction1).enclose();
        CriteriaBuffer b2 = buffer.newBuffer().append(restriction2).enclose();
        buffer.append(b1).append(operator).append(b2);
    }
}
