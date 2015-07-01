package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.ReservedIdentifier;
import net.sf.jpacriteria.builder.CriteriaBuffer;

/**
 * @author Maxim Butov
 * @version $Id: NotRestriction.java,v 1.1 2007/03/24 17:09:02 maxim_butov Exp $
 */
public class NotRestriction extends RestrictionImpl {

    private Restriction restriction;

    public NotRestriction(Restriction restriction) {
        this.restriction = restriction;
    }

    public void build(CriteriaBuffer buffer) {
        buffer.append(buffer.newBuffer().append(restriction).enclose(ReservedIdentifier.NOT));
    }
}
