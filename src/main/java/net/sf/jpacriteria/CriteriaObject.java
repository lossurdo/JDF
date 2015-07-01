package net.sf.jpacriteria;

/**
 * @author Maxim Butov
 * @version $Id: CriteriaObject.java,v 1.3 2007/09/23 19:41:45 maxim_butov Exp $
 */
public interface CriteriaObject<T extends CriteriaObject> {

    T copy();
}
