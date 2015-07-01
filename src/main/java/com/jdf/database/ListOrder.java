package com.jdf.database;

/**
 * Cont�m as propriedades necess�rias para montagem din�mica dos crit�rios de
 * ordena��o de uma lista (ORDER BY)
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
	 * @param attribute Atributo para ordena��o
	 */
	public ListOrder(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * Construtor
	 * @param attribute Atributo para ordena��o
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
