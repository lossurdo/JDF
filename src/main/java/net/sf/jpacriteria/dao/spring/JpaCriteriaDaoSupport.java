package net.sf.jpacriteria.dao.spring;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import javax.persistence.*;

/**
 * @author Maxim Butov
 * @version $Id: JpaCriteriaDaoSupport.java,v 1.3 2007/03/09 15:23:24 maxim_butov Exp $
 */
public class JpaCriteriaDaoSupport extends JpaDaoSupport {

    protected JpaCriteriaTemplate createJpaCriteriaTemplate(EntityManagerFactory entityManagerFactory) {
        return new JpaCriteriaTemplate(entityManagerFactory);
    }

    protected JpaCriteriaTemplate createJpaCriteriaTemplate(EntityManager entityManager) {
        return new JpaCriteriaTemplate(entityManager);
    }

    public void setJpaCriteriaTemplate(JpaCriteriaTemplate jpaCriteriaTemplate) {
        setJpaTemplate(jpaCriteriaTemplate);
    }

    public JpaCriteriaTemplate getJpaCriteriaTemplate() {
        return (JpaCriteriaTemplate) getJpaTemplate();
    }

    @Override
    protected JpaTemplate createJpaTemplate(EntityManagerFactory entityManagerFactory) {
        return createJpaCriteriaTemplate(entityManagerFactory);
    }

    @Override
    protected JpaTemplate createJpaTemplate(EntityManager entityManager) {
        return createJpaCriteriaTemplate(entityManager);
    }
}
