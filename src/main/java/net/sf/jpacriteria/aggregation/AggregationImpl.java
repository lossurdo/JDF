package net.sf.jpacriteria.aggregation;

import java.io.Serializable;

/**
 * @author Maxim Butov
 * @version $Id: AggregationImpl.java,v 1.2 2007/04/04 13:55:52 maxim_butov Exp $
 */
public abstract class AggregationImpl implements Aggregation, Serializable {

    public Aggregation append(Aggregation aggregation) {
        return Aggregations.join(this, aggregation);
    }
}
