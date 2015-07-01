package net.sf.jpacriteria.operator;

import net.sf.jpacriteria.builder.CriteriaBuffer;

import java.io.Serializable;

/**
 * @author Maxim Butov
 * @version $Id: OperatorImpl.java,v 1.2 2007/04/04 13:55:53 maxim_butov Exp $
 */
public abstract class OperatorImpl implements Operator, Serializable {

    private String operator;

    protected OperatorImpl(String operator) {
        this.operator = operator;
    }

    public void build(CriteriaBuffer buffer) {
        buffer.append(operator);
    }
}
