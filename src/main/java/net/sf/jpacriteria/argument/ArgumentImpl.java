package net.sf.jpacriteria.argument;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Maxim Butov
 * @version $Id: ArgumentImpl.java,v 1.10 2007/09/23 19:41:43 maxim_butov Exp $
 */
public class ArgumentImpl implements Argument, Serializable {

    private static final long serialVersionUID = 1791639799830464163L;

    private Map<String, Object> arguments = new HashMap<String, Object>();

    public Argument add(String name, Object value) {
        if (arguments.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        arguments.put(name, value);
        return this;
    }

    public Argument add(Argument argument) {
        return add(argument.asMap());
    }

    public Argument add(Map<String, ?> map) {
        for (String key : map.keySet()) {
            add(key, map.get(key));
        }
        return this;
    }

    public Set<String> names() {
        return arguments.keySet();
    }

    public Object get(String name) {
        if (!arguments.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        return arguments.get(name);
    }

    public Map<String, Object> asMap() {
        return Collections.unmodifiableMap(arguments);
    }

    @Override
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Argument) {
            Argument that = (Argument) obj;
            return asMap().equals(that.asMap());
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (String name : names()) {
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append(name).append(" = ").append(get(name));
        }
        return buffer.toString();
    }
}
