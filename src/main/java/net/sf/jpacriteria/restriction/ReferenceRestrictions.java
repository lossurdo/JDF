package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.operator.Operators;
import net.sf.jpacriteria.parameter.CollectionParameter;
import net.sf.jpacriteria.reference.Reference;

import java.util.Collection;

/**
 * @author Maxim Butov
 * @version $Id: ReferenceRestrictions.java,v 1.3 2007/05/19 14:35:08 maxim_butov Exp $
 */
public class ReferenceRestrictions extends SubCriteriaRestrictions {

    public static Restriction eq(String property, Reference reference) {
        return new BinaryReferenceRestriction(property, Operators.EQ, reference);
    }

    public static Restriction neq(String property, Reference reference) {
        return new BinaryReferenceRestriction(property, Operators.NEQ, reference);
    }

    public static Restriction le(String property, Reference reference) {
        return new BinaryReferenceRestriction(property, Operators.LE, reference);
    }

    public static Restriction lt(String property, Reference reference) {
        return new BinaryReferenceRestriction(property, Operators.LT, reference);
    }

    public static Restriction ge(String property, Reference reference) {
        return new BinaryReferenceRestriction(property, Operators.GE, reference);
    }

    public static Restriction gt(String property, Reference reference) {
        return new BinaryReferenceRestriction(property, Operators.GT, reference);
    }

    public static Restriction in(String property, Reference reference) {
        return new BinaryReferenceRestriction(property, Operators.IN, reference);
    }

    public static Restriction eq(Reference reference, Object value) {
        return new ReferenceRestriction(reference, Operators.EQ, value);
    }

    public static Restriction neq(Reference reference, Object value) {
        return new ReferenceRestriction(reference, Operators.NEQ, value);
    }

    public static Restriction le(Reference reference, Object value) {
        return new ReferenceRestriction(reference, Operators.LE, value);
    }

    public static Restriction lt(Reference reference, Object value) {
        return new ReferenceRestriction(reference, Operators.LT, value);
    }

    public static Restriction ge(Reference reference, Object value) {
        return new ReferenceRestriction(reference, Operators.GE, value);
    }

    public static Restriction gt(Reference reference, Object value) {
        return new ReferenceRestriction(reference, Operators.GT, value);
    }

    public static Restriction in(Reference reference, CollectionParameter values) {
        return new ReferenceInRestriction(reference, values);
    }

    public static Restriction in(Reference reference, Object... values) {
        return new ReferenceInRestriction(reference, values);
    }

    public static Restriction in(Reference reference, Collection values) {
        return new ReferenceInRestriction(reference, values);
    }
}
