package com.jdf.database;

/**
 * Contém as propriedades necessárias para montagem dinâmica dos critérios de
 * ordenação de uma lista (ORDER BY)
 * 
 * @author lossurdo
 * @since 30/03/2009
 */
public final class ListOrder {
	private String attribute;
	private boolean ascending = true;

	/**
	 * Construtor
	 */
	public ListOrder() {
	}

	/**
	 * Construtor
	 * @param attribute Atributo para ordenação
	 */
	public ListOrder(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * Construtor
	 * @param attribute Atributo para ordenação
	 * @param ascending True para listagem ascendente e False para descendente
	 */
	public ListOrder(String attribute, boolean ascending) {
		this.attribute = attribute;
		this.ascending = ascending;
	}

	public String getProperty() {
		return attribute;
	}

	public void setProperty(String attribute) {
		this.attribute = attribute;
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}
}
