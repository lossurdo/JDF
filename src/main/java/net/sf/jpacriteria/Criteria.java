package net.sf.jpacriteria;

import net.sf.jpacriteria.argument.Argument;

import javax.persistence.*;

/**
 * @author Maxim Butov
 * @version $Id: Criteria.java,v 1.12 2007/04/04 22:44:40 maxim_butov Exp $
 */
public interface Criteria extends BasicCriteria<Criteria> {

    Criteria firstResult(int firstResult);

    Criteria maxResults(int resultCount);

    Criteria argument(Argument argument, Argument... arguments);

    Argument getArgument();

    Criteria compile();

    String toQueryString();

    Query toQuery(EntityManager entityManager, Argument argument);
}
