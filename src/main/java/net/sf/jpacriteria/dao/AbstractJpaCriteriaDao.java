package net.sf.jpacriteria.dao;

import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.argument.Argument;
import net.sf.jpacriteria.argument.Arguments;

import javax.persistence.*;
import java.util.List;

/**
 * @author Maxim Butov
 * @version $Id: AbstractJpaCriteriaDao.java,v 1.9 2007/04/05 22:09:20 maxim_butov Exp $
 */
public abstract class AbstractJpaCriteriaDao implements JpaCriteriaDao {

    public abstract EntityManager getEntityManager();

    private Query toQuery(Criteria criteria, Argument... arguments) {
        return criteria.toQuery(getEntityManager(), Arguments.union(arguments));
    }

    public <T> List<T> find(Criteria criteria, Argument... arguments) throws PersistenceException {
        return (List<T>) toQuery(criteria, arguments).getResultList();
    }

    public <T> T getSingleResult(Criteria criteria, Argument... arguments) throws PersistenceException {
        return (T) toQuery(criteria, arguments).getSingleResult();
    }
}
