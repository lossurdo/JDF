package net.sf.jpacriteria.operator;

import net.sf.jpacriteria.ReservedIdentifier;

/**
 * @author Maxim Butov
 * @version $Id: SuffixOperator.java,v 1.2 2007/09/24 09:40:23 maxim_butov Exp $
 */
public class SuffixOperator extends OperatorImpl {

    public static final SuffixOperator IS_NULL = new SuffixOperator(ReservedIdentifier.IS_NULL.toString());
    public static final SuffixOperator IS_NOT_NULL = new SuffixOperator(ReservedIdentifier.IS_NOT_NULL.toString());

    public SuffixOperator(String operator) {
        super(operator);
    }
}
