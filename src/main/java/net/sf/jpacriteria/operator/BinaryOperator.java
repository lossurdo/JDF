package net.sf.jpacriteria.operator;

import net.sf.jpacriteria.ReservedIdentifier;

/**
 * @author Maxim Butov
 * @version $Id: BinaryOperator.java,v 1.4 2007/09/21 08:26:18 maxim_butov Exp $
 */
public class BinaryOperator extends OperatorImpl {

    private static final long serialVersionUID = 3698197355283158814L;

    public static final BinaryOperator EQ = new BinaryOperator("=");
    public static final BinaryOperator NEQ = new BinaryOperator("<>");
    public static final BinaryOperator LE = new BinaryOperator("<=");
    public static final BinaryOperator LT = new BinaryOperator("<");
    public static final BinaryOperator GE = new BinaryOperator(">=");
    public static final BinaryOperator GT = new BinaryOperator(">");
    public static final BinaryOperator IN = new BinaryOperator(ReservedIdentifier.IN.name());
    public static final BinaryOperator LIKE = new BinaryOperator(ReservedIdentifier.LIKE.name());

    public BinaryOperator(String operator) {
        super(operator);
    }
}
