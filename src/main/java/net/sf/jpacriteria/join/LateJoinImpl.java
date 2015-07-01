package net.sf.jpacriteria.join;

/**
 * @author Maxim Butov
 * @version $Id: LateJoinImpl.java,v 1.4 2007/03/28 17:17:40 maxim_butov Exp $
 */
public class LateJoinImpl<T extends LateJoin> extends JoinImpl<T> implements LateJoin<T> {

    private LateJoinType type;

    public LateJoinImpl(String entity, LateJoinType type) {
        this(entity, null, type);
    }

    public LateJoinImpl(String entity, String alias, LateJoinType type) {
        super(entity, alias);
        this.type = type;
    }

    public boolean isFetch() {
        return this instanceof JoinFetch;
    }

    public LateJoinType getType() {
        return type;
    }
}
