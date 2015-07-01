package net.sf.jpacriteria.operator;

import net.sf.jpacriteria.ReservedIdentifier;

/**
 * @author Maxim Butov
 * @version $Id: BinaryLogicalOperator.java,v 1.3 2007/09/24 09:40:23 maxim_butov Exp $
 */
public class BinaryLogicalOperator extends OperatorImpl {

    public static final BinaryLogicalOperator AND = new BinaryLogicalOperator(ReservedIdentifier.AND.name());
    public static final BinaryLogicalOperator OR = new BinaryLogicalOperator(ReservedIdentifier.OR.name());

    public BinaryLogicalOperator(String operator) {
        super(operator);
    }
}
