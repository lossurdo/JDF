package net.sf.jpacriteria.restriction;

import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.operator.Operators;

/**
 * @author Maxim Butov
 * @version $Id: ExistsSubCriteriaRestriction.java,v 1.3 2007/09/24 09:40:17 maxim_butov Exp $
 */
public class ExistsSubCriteriaRestriction extends RestrictionImpl {

    private static final long serialVersionUID = -8627589242417299713L;

    private Criteria subCriteria;

    public ExistsSubCriteriaRestriction(Criteria subCriteria) {
        this.subCriteria = subCriteria.compile();
    }

    public void build(CriteriaBuffer buffer) {
        CriteriaBuffer subBuffer = buffer.newBuffer();
        subBuffer.append(subCriteria.toQueryString()).enclose();
        buffer.getArgument().add(subCriteria.getArgument());
        buffer.append(Operators.EXISTS).append(subBuffer);
    }
}
