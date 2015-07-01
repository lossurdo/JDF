package com.jdf.database;

import java.util.List;

import net.sf.jpacriteria.Criteria;

/**
 * 
 * @author lossurdo
 * @since 27/03/2009
 * @param <TED> ED Principal (Bean)
 * @param <TPED> ED Pesquisa
 */
interface CrudSuper<TED, TPED extends TED>  {
	/**
	 * Faz a inclusão dos dados de um ED em banco
	 * @param ed
	 * @return
	 */
	public TED inclui(TED ed);

	/**
	 * Realiza a alteração dos dados de um ED
	 * @param ed
	 */
	public void altera(TED ed);

	/**
	 * Consulta os dados de um ED
	 * @param ed
	 * @return
	 */
	public TED consulta(TED ed);

	/**
	 * Realiza a exclusão de um ED
	 * @param ed
	 */
	public void exclui(TED ed);

	/**
	 * Realiza a exclusão dos registros ED
	 * @param col Listagem
	 */
	public void exclui(List<TED> col);
	
	/**
	 * Cria uma lista baseado no criteria definido como parametro;
	 * Adiciona ao criteria o order by e a paginacao
	 * @param entity
	 * @param criteria
	 * @param propsLista
	 * @return
	 */
	public List<TED>lista(TPED ed, Criteria criteria, ListConfig propsLista);
	
	/**
	 * Cria uma lista com a clausula where baseada nas propriedades do entity que estão preenchidos
	 */
	public List<TED> lista(TPED ed, ListConfig propriedadesLista);
	
	/**
	 * Retorna a quantidade de registros
	 * @param ed
	 * @return
	 */
	public long conta(TPED ed);
	
	/**
	 * Retorna a quantidade de registros conforme o critério adotado
	 * @param ed
	 * @param crit
	 * @return
	 */
	public long conta(TPED ed, Criteria crit);
}
