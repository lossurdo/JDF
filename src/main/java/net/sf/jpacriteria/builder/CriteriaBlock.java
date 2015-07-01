package net.sf.jpacriteria.builder;

/**
 * @author Maxim Butov
 * @version $Id: CriteriaBlock.java,v 1.2 2007/03/19 22:48:50 maxim_butov Exp $
 */
public interface CriteriaBlock {

    void build(CriteriaBuffer buffer);
}
