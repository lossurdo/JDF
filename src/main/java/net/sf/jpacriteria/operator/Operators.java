package net.sf.jpacriteria.operator;

/**
 * @author Maxim Butov
 * @version $Id: Operators.java,v 1.5 2007/07/12 13:03:43 maxim_butov Exp $
 */
public interface Operators {

    BinaryOperator EQ = BinaryOperator.EQ;
    BinaryOperator NEQ = BinaryOperator.NEQ;
    BinaryOperator LE = BinaryOperator.LE;
    BinaryOperator LT = BinaryOperator.LT;
    BinaryOperator GE = BinaryOperator.GE;
    BinaryOperator GT = BinaryOperator.GT;
    BinaryOperator IN = BinaryOperator.IN;

    BinaryLogicalOperator AND = BinaryLogicalOperator.AND;
    BinaryLogicalOperator OR = BinaryLogicalOperator.OR;

    SuffixOperator IS_NULL = SuffixOperator.IS_NULL;
    SuffixOperator IS_NOT_NULL = SuffixOperator.IS_NOT_NULL;

    PrefixOperator EXISTS = PrefixOperator.EXISTS;
}
