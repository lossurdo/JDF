package net.sf.jpacriteria.reference;

import net.sf.jpacriteria.builder.CriteriaBuffer;

import java.io.Serializable;

/**
 * @author Maxim Butov
 * @version $Id: ReferenceImpl.java,v 1.5 2007/09/21 08:26:18 maxim_butov Exp $
 */
public class ReferenceImpl implements Reference, Serializable {

    private static final long serialVersionUID = 1627239492296707000L;

    private String alias;
    private String name;

    public ReferenceImpl(String alias) {
        this(alias, null);
    }

    public ReferenceImpl(String alias, String name) {
        this.alias = alias;
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public String getName() {
        return name;
    }

    public void build(CriteriaBuffer buffer) {
        buffer.appendAliased(alias, name);
    }
}
