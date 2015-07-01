package net.sf.jpacriteria.dao;

import javax.persistence.*;

/**
 * @author Maxim Butov
 * @version $Id: DefaultJpaCriteriaDao.java,v 1.6 2007/08/25 18:49:19 maxim_butov Exp $
 */
public class DefaultJpaCriteriaDao extends AbstractJpaCriteriaDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DefaultJpaCriteriaDao() {
    }

    public DefaultJpaCriteriaDao(EntityManagerFactory entityManagerFactory) {
        if (entityManagerFactory == null) {
            throw new IllegalArgumentException("entityManagerFactory is null");
        }
        this.entityManagerFactory = entityManagerFactory;
    }

    public DefaultJpaCriteriaDao(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("entityManager is null");
        }
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        if (entityManager != null) {
            return entityManager;
        } else {
            return entityManagerFactory.createEntityManager();
        }
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
