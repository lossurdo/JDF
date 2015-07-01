package com.jdf.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.CriteriaImpl;
import net.sf.jpacriteria.aggregation.Aggregations;
import net.sf.jpacriteria.argument.ArgumentImpl;
import net.sf.jpacriteria.restriction.Restriction;


/**
 * Acesso ao banco de dados para CRUD Genérico
 * @author lossurdo
 * @since 27/03/2009
 * @param <TED>
 * @param <TPED>
 */
public class CrudBDImpl<TED, TPED extends TED> implements CrudBD<TED, TPED> {

	private EntityManager em;
	private EntityTransaction tx;
	private UtilQuery utilQuery = new UtilQuery();

	public CrudBDImpl(String persistenceUnit) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnit);
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public EntityTransaction getEntityTransaction() {
		return tx;
	}

	@Override
	public long conta(TPED ed) {
		Class<?> classeEntity = ed.getClass();
		if (classeEntity.getAnnotation(Table.class) == null) {
			classeEntity =  UtilAnnotation.getClassWithAnnotation(classeEntity, Table.class);
		}
		Criteria criteria = new CriteriaImpl(classeEntity.getSimpleName());
		ArrayList<Restriction> lista  = new UtilQuery().getRestrictionList(ed);
		for (Restriction restriction : lista) {
			criteria.where(restriction);
		}
		return conta(ed, criteria);
	}	
	
	@Override
	public long conta(TPED ed, Criteria crit) {
		crit.aggregate(Aggregations.COUNT);
		Query query = crit.toQuery(em, new ArgumentImpl());
		Long qtd = (Long) query.getSingleResult();
		if (qtd == null) {
			return 0;
		}
		return qtd.longValue();
	}
	
	@Override
	public void altera(TED ed) {
		tx.begin();
		em.merge(ed);
		em.flush();
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public TED consulta(TED ed) {
		Object conteudoPk = UtilAnnotation.getPropIdContent(ed);
		TED edRetorno = (TED) em.find(ed.getClass(), conteudoPk);
		return edRetorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void exclui(TED ed) {
		Object conteudoPk = UtilAnnotation.getPropIdContent(ed);
		TED edFind = (TED) em.getReference(ed.getClass(), conteudoPk);
		tx.begin();
		em.remove(edFind);
		em.flush();
		tx.commit();
	}

	@Override
	public void exclui(List<TED> col) {
		for (TED ted : col) {
			em.remove(ted);
		}
	}

	@Override
	public TED inclui(TED ed) {
		tx.begin();
		em.persist(ed);
		em.flush();
		tx.commit();
		return ed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TED> lista(TPED ed, Criteria criteria,
			ListConfig propsLista) {
		TED entity = ed;
		if (entity.getClass().getAnnotation(Table.class) == null) {
			entity = (TED) UtilAnnotation.getAnnotation(entity.getClass(),
					Table.class);
		}
		utilQuery.addOrderBy(criteria, propsLista);
		Query query = criteria.toQuery(em, new ArgumentImpl());
		if (propsLista != null && propsLista.getSize() != 0) {
			query.setFirstResult(propsLista.getFirst());
			query.setMaxResults(propsLista.getSize());
		}
		List<TED> col = null;
		col = query.getResultList();
		return col;
	}

	@Override
	public List<TED> lista(TPED ed, ListConfig propriedadesLista) {
		Class<?> classeEntity = ed.getClass();
		if (classeEntity.getAnnotation(Table.class) == null) {
			classeEntity = UtilAnnotation.getClassWithAnnotation(classeEntity,
					Table.class);
		}
		Criteria criteria = new CriteriaImpl(classeEntity.getSimpleName());
		ArrayList<Restriction> lista = utilQuery.getRestrictionList(ed);
		for (Restriction restriction : lista) {
			criteria.where(restriction);
		}
		return lista(ed, criteria, propriedadesLista);
	}

}
