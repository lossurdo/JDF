package com.jdf.database;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.jpacriteria.Criteria;
import net.sf.jpacriteria.order.OrderDirection;
import net.sf.jpacriteria.order.Orders;
import net.sf.jpacriteria.restriction.Restriction;
import net.sf.jpacriteria.restriction.Restrictions;


/**
 * Classe utilitária para manipulação de Queries
 * @author rafael-lossurdo
 * @since 30/03/2009
 */
final class UtilQuery {

	/**
	 * Adiciona ao criteria a cláusula ORDER BY a partir do que foi informado na
	 * propriedade ordenacação do parametro
	 * 
	 * @param crit
	 * @param prop
	 */
	public void addOrderBy(Criteria crit, ListConfig prop) {
		if (prop == null) {
			return;
		}
		List<ListOrder> listaOrdenacao = prop.getOrder();
		if (listaOrdenacao == null || listaOrdenacao.size() == 0) {
			return;
		}

		for (ListOrder ordem : listaOrdenacao) {
			OrderDirection od = OrderDirection.ASC;
			if (!ordem.isAscending()) {
				od = OrderDirection.DESC;
			}
			crit.order(Orders.order(ordem.getProperty(), od));
		}
	}

	/**
	 * Executa um Query.setParamenter para cada uma das propriedades definidas
	 * no Map
	 * 
	 * @param query
	 * @param mapParameters
	 */
	public void setParam(Query query, Map<String, Object> mapParameters) {
		if (mapParameters != null) {
			Set<String> keys = mapParameters.keySet();
			for (String key : keys) {
				query.setParameter(key, mapParameters.get(key));
			}
		}
	}

	/**
	 * Tranforma uma Query comum em uma Query de contagem mantendo a mesma
	 * cláusula WHERE
	 * 
	 * <pre>
	 * Exemplo:  
	 * Entrada: &quot;SELECT t FROM TurmaED t WHERE ...&quot;
	 *  
	 * Saida:   &quot;SELECT COUNT(t) WHERE ...&quot;
	 * </pre>
	 * 
	 * @param strQuery
	 * @return
	 */
	public String tranformListInCount(String strQuery) {
		String strQueryUpper = strQuery.toUpperCase();
		int pFrom = strQueryUpper.indexOf("FROM");
		String partes[] = strQuery.substring(pFrom).split("\\ ");
		if (partes.length < 3) {
			throw new RuntimeException("Query inválida: " + strQuery);
		}
		return "SELECT COUNT(" + partes[2] + " ) " + strQuery.substring(pFrom);
	}

	/**
	 * Retorna a Query dado o nome de uma NamedQuery.
	 * 
	 * @param nomeQuery
	 * @param entity
	 * @return
	 */
	public String getNamedQuery(String nomeQuery, Object entity) {
		NamedQueries nqs = entity.getClass().getAnnotation(NamedQueries.class);
		if (nqs == null) {
			return null;
		}
		NamedQuery nq[] = nqs.value();
		for (int i = 0; i < nq.length; i++) {
			if (nq[i].name().equals(nomeQuery)) {
				return nq[i].query();
			}
		}
		return null;
	}

	/**
	 * Monta de forma recursiva uma lista de restricoes(criteria) com base nas
	 * propriedades preenchidas do entity. As propriedades assinaladas como
	 * transiente não são consideradas. A propridades dentro de uma propriedade
	 * anotadas com @Embebed ou @JoinColumn também são consideredas.
	 * 
	 * 
	 * @param obj
	 * @return
	 */
	public ArrayList<Restriction> getRestrictionList(Object obj) {
		return getRestrictionList(obj, new ArrayList<Restriction>(), null);
	}

	private ArrayList<Restriction> getRestrictionList(Object obj,
			ArrayList<Restriction> list, String superED) {

		PropertyDescriptor pds[];
		try {
			pds = Introspector.getBeanInfo(
					UtilAnnotation.getClassWithAnnotation(obj.getClass(),
							Table.class)).getPropertyDescriptors();
		} catch (IntrospectionException e1) {
			throw new RuntimeException(e1);
		}
		if (pds == null) {
			return null;
		}
		for (int i = 0; i < pds.length; i++) {
			Method mread = pds[i].getReadMethod();
			if (mread == null) {
				continue;
			}

			Field f = null;
			Class<?> caux = obj.getClass();
			// procura o field na propria classe e nas super classes.
			while (f == null && caux != Object.class) {
				try {
					f = caux.getDeclaredField(pds[i].getName());
				} catch (Exception e) {
				} finally {
					caux = caux.getSuperclass();
				}
			}
			if (f == null) {
				continue;
			}

			if (f.getAnnotation(Transient.class) != null) {
				continue;
			}
			Embedded embedded = f.getAnnotation(Embedded.class);
			JoinColumn joinColumn = f.getAnnotation(JoinColumn.class);

			Object conteudo = null;
			try {
				conteudo = mread.invoke(obj, (Object[]) null);
			} catch (Exception e) {
				throw new RuntimeException("Propriedade: " + pds[i].getName(),
						e);
			}
			if (isEmptyContent(conteudo)) {
				continue;
			}
			if (conteudo instanceof Collection) {
				continue;
			}

			String nomeProp;
			if (embedded != null) {
				nomeProp = superED; // o nome da propriedade embebed não deve
										// ser considerado
			} else {
				nomeProp = pds[i].getName();
				if (superED != null) {
					nomeProp = superED + "." + nomeProp;
				}
			}

			if (embedded == null && joinColumn == null) {
				if (conteudo instanceof String) {
					list.add(Restrictions.ilike(nomeProp, "%"
							+ conteudo.toString() + "%"));
				} else {
					list.add(Restrictions.eq(nomeProp, conteudo));
				}
			} else {
				// se encontrou uma JoinColumn ou uma embbebed- faz uma chamada
				// recursiva
				getRestrictionList(conteudo, list, nomeProp);
			}
		}
		return list;
	}

	private boolean isEmptyContent(Object content) {
		if (content == null) {
			return true;
		}
		if (content instanceof Collection) {
			return (((Collection<?>) content).size() == 0);
		}
		if (content instanceof Number) {
			return (content.toString().equals("0") || content.toString()
					.equals("0.0"));
		}
		return (content.toString().trim().length() == 0);
	}

}