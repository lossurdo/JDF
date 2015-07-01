package net.sf.jpacriteria.join;

/**
 * @author Maxim Butov
 * @version $Id: JoinFetchImpl.java,v 1.2 2007/04/13 12:02:00 maxim_butov Exp $
 */
public class JoinFetchImpl extends LateJoinImpl<JoinFetch> implements JoinFetch {

    public JoinFetchImpl(String entity, LateJoinType type) {
        super(entity, type);
    }

    public JoinFetchImpl(String entity, String alias, LateJoinType type) {
        super(entity, alias, type);
    }
}
