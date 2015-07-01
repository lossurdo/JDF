package net.sf.jpacriteria.parameter;

import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.builder.UniqueIdentifiers;

/**
 * @author Maxim Butov
 * @version $Id: VariableParameter.java,v 1.7 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class VariableParameter<T> extends ParameterImpl<T> {

    private static final long serialVersionUID = -6964829141192523717L;

    public VariableParameter(T value) {
        super(value);
    }

    public void build(CriteriaBuffer buffer) {
        String param = UniqueIdentifiers.generate("p", this);
        buffer.append(':' + param);
        buffer.getArgument().add(param, getValue());
    }
}
