package net.sf.jpacriteria.reference;

/**
 * @author Maxim Butov
 * @version $Id: References.java,v 1.4 2007/08/02 14:16:14 maxim_butov Exp $
 */
public class References {

    public static Reference reference(String alias) {
        return new ReferenceImpl(alias);
    }

    public static Reference reference(String alias, String name) {
        return new ReferenceImpl(alias, name);
    }

    private References() {
    }
}
