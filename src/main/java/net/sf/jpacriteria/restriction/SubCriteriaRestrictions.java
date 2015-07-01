package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.operator.Operators;

/**
 * @author Maxim Butov
 * @version $Id: SubCriteriaRestrictions.java,v 1.2 2007/07/12 13:03:42 maxim_butov Exp $
 */
public class SubCriteriaRestrictions extends SimpleRestrictions {

    public static Restriction eq(String property, Criteria subCriteria) {
        return new BinarySubCriteriaRestriction(property, Operators.EQ, subCriteria);
    }

    public static Restriction neq(String property, Criteria subCriteria) {
        return new BinarySubCriteriaRestriction(property, Operators.NEQ, subCriteria);
    }

    public static Restriction le(String property, Criteria subCriteria) {
        return new BinarySubCriteriaRestriction(property, Operators.LE, subCriteria);
    }

    public static Restriction lt(String property, Criteria subCriteria) {
        return new BinarySubCriteriaRestriction(property, Operators.LT, subCriteria);
    }

    public static Restriction ge(String property, Criteria subCriteria) {
        return new BinarySubCriteriaRestriction(property, Operators.GE, subCriteria);
    }

    public static Restriction gt(String property, Criteria subCriteria) {
        return new BinarySubCriteriaRestriction(property, Operators.GT, subCriteria);
    }

    public static Restriction in(String property, Criteria subCriteria) {
        return new BinarySubCriteriaRestriction(property, Operators.IN, subCriteria);
    }

    public static Restriction exists(Criteria subCriteria) {
        return new ExistsSubCriteriaRestriction(subCriteria);
    }
}
