package net.sf.jpacriteria.parameter;

import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: ConstantParameter.java,v 1.2 2007/03/26 11:56:00 maxim_butov Exp $
 */
public class ConstantParameter<T> extends ParameterImpl<T> {

    public ConstantParameter(T value) {
        super(value);
    }

    public void build(CriteriaBuffer buffer) {
        buffer.append(getValue());
    }
}
