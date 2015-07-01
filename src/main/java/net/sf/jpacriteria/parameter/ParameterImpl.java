package net.sf.jpacriteria.parameter;

import java.io.Serializable;

/**
 * @author Maxim Butov
 * @version $Id: ParameterImpl.java,v 1.3 2007/04/04 13:55:53 maxim_butov Exp $
 */
public abstract class ParameterImpl<T> implements Parameter<T>, Serializable {

    private T value;

    protected ParameterImpl(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
