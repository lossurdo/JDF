package net.sf.jpacriteria.join;

import net.sf.jpacriteria.BasicCriteriaImpl;

/**
 * @author Maxim Butov
 * @version $Id: JoinImpl.java,v 1.6 2007/08/02 14:16:02 maxim_butov Exp $
 */
public abstract class JoinImpl<T extends Join> extends BasicCriteriaImpl<T> implements Join<T> {

    public JoinImpl(String entity) {
        super(entity);
    }

    public JoinImpl(String entity, String alias) {
        super(entity, alias);
    }
}
