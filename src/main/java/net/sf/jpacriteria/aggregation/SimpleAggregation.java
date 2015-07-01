package net.sf.jpacriteria.aggregation;

import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: SimpleAggregation.java,v 1.6 2007/09/21 08:26:18 maxim_butov Exp $
 */
public class SimpleAggregation extends AggregationImpl {

    private static final long serialVersionUID = -6618688259743379500L;

    private String name;

    public SimpleAggregation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SimpleAggregation(ReservedIdentifier identifier) {
        this(identifier.name());
    }

    public void build(CriteriaBuffer buffer) {
        buffer.enclose();
        buffer.insertNoSpace(name);
    }
}
