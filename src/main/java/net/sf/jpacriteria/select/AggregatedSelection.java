package net.sf.jpacriteria.select;

import net.sf.jpacriteria.aggregation.Aggregation;
import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: AggregatedSelection.java,v 1.3 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class AggregatedSelection extends SelectionImpl {

    private static final long serialVersionUID = -53600992568352281L;

    private Selection selection;
    private Aggregation aggregation;

    public AggregatedSelection(Selection selection, Aggregation aggregation) {
        this.selection = selection;
        this.aggregation = aggregation;
    }

    public void build(CriteriaBuffer buffer) {
        CriteriaBuffer b = buffer.newBuffer();
        selection.build(b);
        aggregation.build(b);
        buffer.append(b);
    }
}
