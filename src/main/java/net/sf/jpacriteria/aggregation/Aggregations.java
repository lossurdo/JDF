package net.sf.jpacriteria.aggregation;

import net.sf.jpacriteria.ReservedIdentifier;

/**
 * @author Maxim Butov
 * @version $Id: Aggregations.java,v 1.8 2007/09/23 19:41:45 maxim_butov Exp $
 */
public class Aggregations {

    public static final Aggregation MAX = new SimpleAggregation(ReservedIdentifier.MAX);
    public static final Aggregation AVG = new SimpleAggregation(ReservedIdentifier.AVG);
    public static final Aggregation MIN = new SimpleAggregation(ReservedIdentifier.MIN);
    public static final Aggregation COUNT = new SimpleAggregation(ReservedIdentifier.COUNT);
    public static final Aggregation DISTINCT = new DistinctAggregation();
    public static final Aggregation SUM = new SimpleAggregation(ReservedIdentifier.SUM);

    public static Aggregation join(Aggregation aggregation, Aggregation... aggregations) {
        for (Aggregation a : aggregations) {
            aggregation = new ComplexAggregation(aggregation, a);
        }
        return aggregation;
    }

    public static Aggregation constructor(Class aClass) {
        return new ConstructorAggregation(aClass);
    }

    private Aggregations() {
    }
}
