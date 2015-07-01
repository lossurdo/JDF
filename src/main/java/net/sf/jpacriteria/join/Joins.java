package net.sf.jpacriteria.join;

/**
 * @author Maxim Butov
 * @version $Id: Joins.java,v 1.7 2007/08/02 14:16:02 maxim_butov Exp $
 */
public class Joins {

    public static EarlierJoin earlierJoin(String property) {
        return new EarlierJoinImpl(property);
    }

    public static EarlierJoin earlierJoin(String property, String alias) {
        return new EarlierJoinImpl(property, alias);
    }

    public static LateJoin<LateJoin> join(String property) {
        return new LateJoinImpl<LateJoin>(property, LateJoinType.INNER);
    }

    public static JoinFetch joinFetch(String property) {
        return new JoinFetchImpl(property, LateJoinType.INNER);
    }

    public static LateJoin<LateJoin> leftJoin(String property) {
        return new LateJoinImpl<LateJoin>(property, LateJoinType.OUTER);
    }

    public static JoinFetch leftJoinFetch(String property) {
        return new JoinFetchImpl(property, LateJoinType.OUTER);
    }

    private Joins() {
    }
}
