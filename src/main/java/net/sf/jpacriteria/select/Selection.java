package net.sf.jpacriteria.select;

import net.sf.jpacriteria.Sequential;
import net.sf.jpacriteria.aggregation.Aggregation;
import net.sf.jpacriteria.builder.CriteriaBlock;

/**
 * @author Maxim Butov
 * @version $Id: Selection.java,v 1.11 2007/09/24 09:40:23 maxim_butov Exp $
 */
public interface Selection extends CriteriaBlock, Sequential<Selection> {

    Selection aggregate(Aggregation aggregation);
}
