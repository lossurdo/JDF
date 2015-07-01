package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.operator.Operators;

import java.util.Collection;

/**
 * @author Maxim Butov
 * @version $Id: SimpleRestrictions.java,v 1.4 2007/09/24 09:53:41 maxim_butov Exp $
 */
public class SimpleRestrictions {

    public static Restriction eq(Object value) {
        return new BinaryRestriction(null, Operators.EQ, value);
    }

    public static Restriction eq(String property, Object value) {
        return new BinaryRestriction(property, Operators.EQ, value);
    }

    public static Restriction neq(String property, Object value) {
        return new BinaryRestriction(property, Operators.NEQ, value);
    }

    public static Restriction le(String property, Object value) {
        return new BinaryRestriction(property, Operators.LE, value);
    }

    public static Restriction lt(String property, Object value) {
        return new BinaryRestriction(property, Operators.LT, value);
    }

    public static Restriction ge(String property, Object value) {
        return new BinaryRestriction(property, Operators.GE, value);
    }

    public static Restriction gt(String property, Object value) {
        return new BinaryRestriction(property, Operators.GT, value);
    }

    public static Restriction in(String property, Collection values) {
        return new InRestriction(property, values);
    }

    public static Restriction in(String property, Object... values) {
        return new InRestriction(property, values);
    }

    public static Restriction isNull(String property) {
        return new SuffixRestriction(property, ReservedIdentifier.IS_NULL.toString());
    }

    public static Restriction isNotNull(String property) {
        return new SuffixRestriction(property, ReservedIdentifier.IS_NOT_NULL.toString());
    }

    public static Restriction isEmpty(String property) {
        return new SuffixRestriction(property, ReservedIdentifier.IS_EMPTY.toString());
    }

    public static Restriction isNotEmpty(String property) {
        return new SuffixRestriction(property, ReservedIdentifier.IS_NOT_EMPTY.toString());
    }

    public static Restriction like(String property, String value) {
        return new LikeRestriction(property, value, false);
    }

    public static Restriction ilike(String property, String value) {
        return new LikeRestriction(property, value, true);
    }

    protected SimpleRestrictions() {
    }
}
