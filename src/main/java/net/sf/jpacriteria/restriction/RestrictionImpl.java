package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.operator.BinaryLogicalOperator;

import java.io.Serializable;

/**
 * @author Maxim Butov
 * @version $Id: RestrictionImpl.java,v 1.3 2007/04/04 13:55:54 maxim_butov Exp $
 */
public abstract class RestrictionImpl implements Restriction, Serializable {

    public Restriction not() {
        return new NotRestriction(this);
    }

    public Restriction and(Restriction restriction) {
        return new ComplexLogicalRestriction(this, BinaryLogicalOperator.AND, restriction);
    }

    public Restriction or(Restriction restriction) {
        return new ComplexLogicalRestriction(this, BinaryLogicalOperator.OR, restriction);
    }
}
