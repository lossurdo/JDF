package net.sf.jpacriteria.argument;

import java.util.Map;
import java.util.Set;

/**
 * @author Maxim Butov
 * @version $Id: Argument.java,v 1.5 2007/08/02 17:27:29 maxim_butov Exp $
 */
public interface Argument {

    Argument add(String name, Object value);

    Argument add(Argument argument);

    Set<String> names();

    Object get(String name);

    Argument add(Map<String, ?> map);

    Map<String, Object> asMap();
}
