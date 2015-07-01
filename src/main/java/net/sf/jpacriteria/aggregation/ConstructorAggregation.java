package net.sf.jpacriteria.aggregation;

import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: ConstructorAggregation.java,v 1.1 2007/03/25 00:32:50 maxim_butov Exp $
 */
public class ConstructorAggregation extends AggregationImpl {

    private Class aggregationClass;

    public ConstructorAggregation(Class aggregationClass) {
        this.aggregationClass = aggregationClass;
    }

    public void build(CriteriaBuffer buffer) {
        buffer.enclose().insert(aggregationClass.getName()).insert(ReservedIdentifier.NEW);
    }
}
