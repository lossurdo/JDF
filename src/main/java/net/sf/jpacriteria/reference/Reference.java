package net.sf.jpacriteria.reference;

import net.sf.jpacriteria.alias.Aliased;
import net.sf.jpacriteria.builder.CriteriaBlock;

/**
 * @author Maxim Butov
 * @version $Id: Reference.java,v 1.2 2007/03/30 22:36:26 maxim_butov Exp $
 */
public interface Reference extends Aliased, CriteriaBlock {

    String getName();
}
