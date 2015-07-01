package net.sf.jpacriteria.join;

/**
 * @author Maxim Butov
 * @version $Id: EarlierJoinImpl.java,v 1.2 2007/03/11 22:30:46 maxim_butov Exp $
 */
public class EarlierJoinImpl extends JoinImpl<EarlierJoin> implements EarlierJoin {

    public EarlierJoinImpl(String entity) {
        super(entity);
    }

    public EarlierJoinImpl(String entity, String alias) {
        super(entity, alias);
    }
}
