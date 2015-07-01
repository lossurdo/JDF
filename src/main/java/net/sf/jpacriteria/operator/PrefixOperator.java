package net.sf.jpacriteria.operator;

import net.sf.jpacriteria.ReservedIdentifier;

/**
 * @author Maxim Butov
 * @version $Id: PrefixOperator.java,v 1.4 2007/09/24 09:40:22 maxim_butov Exp $
 */
public class PrefixOperator extends OperatorImpl {

    public static final PrefixOperator EXISTS = new PrefixOperator(ReservedIdentifier.EXISTS.name());

    public PrefixOperator(String operator) {
        super(operator);
    }
}
