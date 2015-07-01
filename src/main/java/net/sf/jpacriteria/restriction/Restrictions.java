package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.operator.BinaryLogicalOperator;
import net.sf.jpacriteria.operator.Operator;
import net.sf.jpacriteria.parameter.Parameter;

/**
 * @author Maxim Butov
 * @version $Id: Restrictions.java,v 1.12 2007/04/11 14:51:40 maxim_butov Exp $
 */
public class Restrictions extends ReferenceRestrictions {

    public static Restriction restrict(String name, Operator operator, Parameter value) {
        return new BinaryRestriction(name, operator, value);
    }

    public static Restriction and(Restriction restriction, Restriction... restrictions) {
        for (Restriction r : restrictions) {
            restriction = new ComplexLogicalRestriction(restriction, BinaryLogicalOperator.AND, r);
        }
        return restriction;
    }

    public static Restriction or(Restriction restriction, Restriction... restrictions) {
        for (Restriction r : restrictions) {
            restriction = new ComplexLogicalRestriction(restriction, BinaryLogicalOperator.OR, r);
        }
        return restriction;
    }

    public static Restriction not(Restriction r) {
        return new NotRestriction(r);
    }

    public static Restriction falseRestriction(String name) {
        return and(isNull(name), isNotNull(name));
    }

    public static Restriction trueRestriction(String name) {
        return or(isNull(name), isNotNull(name));
    }
}
