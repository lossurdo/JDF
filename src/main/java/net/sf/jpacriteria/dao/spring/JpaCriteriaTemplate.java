package net.sf.jpacriteria.dao.spring;

import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.argument.Argument;
import net.sf.jpacriteria.dao.JpaCriteriaDao;
import org.springframework.orm.jpa.JpaTemplate;

import javax.persistence.*;
import java.util.List;

/**
 * @author Maxim Butov
 * @version $Id: JpaCriteriaTemplate.java,v 1.15 2007/04/05 22:09:20 maxim_butov Exp $
 */
public class JpaCriteriaTemplate extends JpaTemplate implements JpaCriteriaDao {

    public JpaCriteriaTemplate() {
    }

    public JpaCriteriaTemplate(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    public JpaCriteriaTemplate(EntityManager entityManager) {
        super(entityManager);
    }

    public List find(final Criteria criteria, final Argument... arguments) throws PersistenceException {
        return executeFind(new JpaCriteriaCallback() {
            @Override
            public Object doInJpa(JpaCriteriaDao dao) throws PersistenceException {
                return dao.find(criteria, arguments);
            }
        });
    }

    public Object getSingleResult(final Criteria criteria, final Argument... arguments) throws PersistenceException {
        return execute(new JpaCriteriaCallback() {
            @Override
            public Object doInJpa(JpaCriteriaDao dao) throws PersistenceException {
                return dao.getSingleResult(criteria, arguments);
            }
        });
    }
}
