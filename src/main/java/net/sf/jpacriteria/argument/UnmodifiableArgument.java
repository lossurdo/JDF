package net.sf.jpacriteria.argument;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * @author Maxim Butov
 * @version $Id: UnmodifiableArgument.java,v 1.5 2007/09/23 19:41:43 maxim_butov Exp $
 */
public class UnmodifiableArgument implements Argument, Serializable {

    private static final long serialVersionUID = 4695296202487911959L;

    private Argument argument;

    public UnmodifiableArgument(Argument argument) {
        this.argument = argument;
    }

    public Argument add(String name, Object value) {
        throw new UnsupportedOperationException();
    }

    public Argument add(Argument argument) {
        throw new UnsupportedOperationException();
    }

    public Argument add(Map<String, ?> map) {
        throw new UnsupportedOperationException();
    }

    public Set<String> names() {
        return argument.names();
    }

    public Object get(String name) {
        return argument.get(name);
    }

    public Map<String, Object> asMap() {
        return argument.asMap();
    }

    @Override
    public String toString() {
        return argument.toString();
    }

    @Override
    public int hashCode() {
        return argument.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return argument.equals(obj);
    }
}
