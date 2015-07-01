package net.sf.jpacriteria.dao.spring;

import net.sf.jpacriteria.dao.AbstractJpaCriteriaDao;
import net.sf.jpacriteria.dao.JpaCriteriaDao;
import org.springframework.orm.jpa.JpaCallback;

import javax.persistence.*;

/**
 * @author Maxim Butov
 * @version $Id: JpaCriteriaCallback.java,v 1.2 2007/03/30 23:15:50 maxim_butov Exp $
 */
public abstract class JpaCriteriaCallback implements JpaCallback {

    public final Object doInJpa(final EntityManager entityManager) throws PersistenceException {
        return doInJpa(new AbstractJpaCriteriaDao() {
            @Override
            public EntityManager getEntityManager() {
                return entityManager;
            }
        });
    }

    public abstract Object doInJpa(JpaCriteriaDao dao) throws PersistenceException;
}
