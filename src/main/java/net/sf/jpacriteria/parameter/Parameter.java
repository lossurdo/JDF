package net.sf.jpacriteria.parameter;

import net.sf.jpacriteria.builder.CriteriaBlock;

/**
 * @author Maxim Butov
 * @version $Id: Parameter.java,v 1.5 2007/04/02 10:39:29 maxim_butov Exp $
 */
public interface Parameter<T> extends CriteriaBlock {

    T getValue();
}
