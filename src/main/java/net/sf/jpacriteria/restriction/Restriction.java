package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.builder.CriteriaBlock;

/**
 * @author Maxim Butov
 * @version $Id: Restriction.java,v 1.10 2007/09/24 09:40:17 maxim_butov Exp $
 */
public interface Restriction extends CriteriaBlock {

    Restriction not();

    Restriction and(Restriction restriction);

    Restriction or(Restriction restriction);
}
