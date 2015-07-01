package net.sf.jpacriteria;

import net.sf.jpacriteria.builder.CriteriaBlock;
import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: ReservedIdentifier.java,v 1.9 2007/09/24 09:40:23 maxim_butov Exp $
 */
public enum ReservedIdentifier implements CriteriaBlock {

    ALL, AND, ANY, AS, ASC, AVG,
    BETWEEN, BIT_LENGTH, BY,
    CHAR_LENGTH, CHARACTER_LENGTH, COUNT, CURRENT_DATE, CURRENT_TIME, CURRENT_TIMESTAMP,
    DELETE, DESC, DISTINCT,
    EMPTY, ESCAPE, EXISTS,
    FALSE, FETCH, FROM,
    GROUP,
    HAVING,
    IN, INNER, IS,
    JOIN,
    LEFT, LIKE, LOWER,
    MAX, MEMBER, MIN, MOD,
    NEW, NOT, NULL,
    OBJECT, OF, OR, ORDER, OUTER,
    POSITION,
    SELECT, SOME, SUM,
    TRIM, TRUE,
    UNKNOWN, UPDATE, UPPER,
    WHERE,;

    public static boolean isReserved(String word) {
        try {
            Enum.valueOf(ReservedIdentifier.class, word.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void build(CriteriaBuffer buffer) {
        buffer.append(name());
    }

    private static class ReservedIdentifierSequence implements CriteriaBlock {

        private ReservedIdentifier[] identifiers;

        public ReservedIdentifierSequence(ReservedIdentifier... identifiers) {
            this.identifiers = identifiers;
        }

        public void build(CriteriaBuffer buffer) {
            for (ReservedIdentifier idf : identifiers) {
                idf.build(buffer);
            }
        }

        @Override
        public String toString() {
            StringBuilder buffer = new StringBuilder();
            buffer.append(identifiers[0]);
            for (int k = 1; k < identifiers.length; ++k) {
                buffer.append(' ');
                buffer.append(identifiers[k]);
            }
            return buffer.toString();
        }
    }

    public static final CriteriaBlock ORDER_BY = new ReservedIdentifierSequence(ORDER, BY);
    public static final CriteriaBlock GROUP_BY = new ReservedIdentifierSequence(GROUP, BY);

    public static final CriteriaBlock IS_NULL = new ReservedIdentifierSequence(IS, NULL);
    public static final CriteriaBlock IS_NOT_NULL = new ReservedIdentifierSequence(IS, NOT, NULL);

    public static final CriteriaBlock IS_EMPTY = new ReservedIdentifierSequence(IS, EMPTY);
    public static final CriteriaBlock IS_NOT_EMPTY = new ReservedIdentifierSequence(IS, NOT, EMPTY);
}
