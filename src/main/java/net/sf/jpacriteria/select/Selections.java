package net.sf.jpacriteria.select;

import net.sf.jpacriteria.aggregation.Aggregation;
import net.sf.jpacriteria.aggregation.Aggregations;

/**
 * @author Maxim Butov
 * @version $Id: Selections.java,v 1.7 2007/08/02 14:16:14 maxim_butov Exp $
 */
public class Selections {

    public static Selection object() {
        return new ObjectSelection();
    }

    public static Selection property(String property) {
        return new SimpleSelection(property);
    }

    public static Selection property(String alias, String property) {
        return new AliasedSelection(alias, property);
    }

    public static Selection join(Selection selection, Selection... selections) {
        for (Selection s : selections) {
            selection = new ComplexSelection(selection, s);
        }
        return selection;
    }

    public static Selection aggregate(Selection selection, Aggregation aggregation, Aggregation... aggregations) {
        return new AggregatedSelection(selection, Aggregations.join(aggregation, aggregations));
    }

    private Selections() {
    }
}
