package net.sf.jpacriteria.join;

/**
 * @author Maxim Butov
 * @version $Id: LateJoin.java,v 1.2 2007/03/28 17:17:40 maxim_butov Exp $
 */
public interface LateJoin<T extends LateJoin> extends Join<T> {

    boolean isFetch();

    LateJoinType getType();
}
