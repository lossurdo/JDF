package net.sf.jpacriteria.select;

import net.sf.jpacriteria.aggregation.Aggregation;

import java.io.Serializable;

/**
 * @author Maxim Butov
 * @version $Id: SelectionImpl.java,v 1.3 2007/04/04 13:55:54 maxim_butov Exp $
 */
public abstract class SelectionImpl implements Selection, Serializable {

    public Selection append(Selection selection) {
        return Selections.join(this, selection);
    }

    public Selection aggregate(Aggregation aggregation) {
        return Selections.aggregate(this, aggregation);
    }
}
