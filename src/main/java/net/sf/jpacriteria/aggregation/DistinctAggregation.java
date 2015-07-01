package net.sf.jpacriteria.aggregation;

import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: DistinctAggregation.java,v 1.3 2007/09/21 08:26:18 maxim_butov Exp $
 */
public class DistinctAggregation extends SimpleAggregation {

    private static final long serialVersionUID = 8395469271547949922L;

    public DistinctAggregation() {
        super(ReservedIdentifier.DISTINCT);
    }

    public void build(CriteriaBuffer buffer) {
        buffer.insert(getName());
    }
}
