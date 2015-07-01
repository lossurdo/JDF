package net.sf.jpacriteria.dao;

import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.argument.Argument;

import javax.persistence.*;
import java.util.List;

/**
 * @author Maxim Butov
 * @version $Id: JpaCriteriaDao.java,v 1.9 2007/04/05 22:09:20 maxim_butov Exp $
 */
public interface JpaCriteriaDao {

    <T> List<T> find(Criteria criteria, Argument... arguments) throws PersistenceException;

    <T> T getSingleResult(Criteria criteria, Argument... arguments) throws PersistenceException;
}
