package net.sf.jpacriteria.builder;

/**
 * @author Maxim Butov
 * @version $Id: UniqueIdentifiers.java,v 1.2 2007/08/02 14:16:14 maxim_butov Exp $
 */
public class UniqueIdentifiers {

    public static String generate(String prefix, Object parent) {
        return '$' + prefix + '$' + Integer.toHexString(System.identityHashCode(parent));
    }

    public static String generate(String alias, int n) {
        return alias + '$' + n;
    }

    public static String generate(String prefix, Object parent, int n) {
        return generate(generate(prefix, parent), n);
    }

    private UniqueIdentifiers() {
    }
}
