package com.jdf.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Define as propriedades adicionais para execução dos métodos de lista
 * @author lossurdo
 * @since 30/03/2009
 */
public final class ListConfig {
	private int first;
	private int size;
	private List<ListOrder> order;

	/**
	 * Construtor
	 */
	public ListConfig() {
		super();
	}

	/**
	 * Construtor
	 * @param first Primeiro registro a ser mostrado
	 * @param size Tamanho da listagem
	 */
	public ListConfig(int first, int size) {
		super();
		this.first = first;
		this.size = size;
	}

	/**
	 * Construtor
	 * @param first Primeiro registro a ser mostrado
	 * @param size Tamanho da listagem
	 * @param order Ordenação da listagem
	 */
	public ListConfig(int first, int size, List<ListOrder> order) {
		super();
		this.first = first;
		this.size = size;
		this.order = order;
	}

	public int getFirst() {
		return first;
	}

	public List<ListOrder> getOrder() {
		return order;
	}

	public void setOrder(List<ListOrder> o) {
		this.order = o;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	/**
	 * Adiciona um ordenador
	 * @param o
	 * @return
	 */
	public ListConfig addOrder(ListOrder o) {
		if (order == null) {
			order = new ArrayList<ListOrder>();
		}
		order.add(o);
		return this;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}