package net.sf.jpacriteria.aggregation;

import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: ComplexAggregation.java,v 1.3 2007/09/21 08:26:18 maxim_butov Exp $
 */
public class ComplexAggregation extends AggregationImpl {

    private static final long serialVersionUID = -5392509079167847310L;

    private Aggregation aggregation1;
    private Aggregation aggregation2;

    public ComplexAggregation(Aggregation aggregation1, Aggregation aggregation2) {
        this.aggregation1 = aggregation1;
        this.aggregation2 = aggregation2;
    }

    public void build(CriteriaBuffer buffer) {
        aggregation1.build(buffer);
        aggregation2.build(buffer);
    }
}
