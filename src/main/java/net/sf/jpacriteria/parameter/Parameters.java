package net.sf.jpacriteria.parameter;

/**
 * @author Maxim Butov
 * @version $Id: Parameters.java,v 1.5 2007/08/02 14:16:14 maxim_butov Exp $
 */
public class Parameters {

    public static <T> Parameter<T> value(T value) {
        return new VariableParameter<T>(value);
    }

    public static <T> Parameter<T> constant(T value) {
        return new ConstantParameter<T>(value);
    }

    private Parameters() {
    }
}
