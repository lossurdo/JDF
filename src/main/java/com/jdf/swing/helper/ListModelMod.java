package com.jdf.swing.helper;

import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 * Corresponde ao modelo da listagem
 * @author lossurdo
 * @since 12/03/2009
 */
@SuppressWarnings("unchecked")
class ListModelMod implements ListModel {

	private List list;

	/**
	 * 
	 * @param list
	 */
	public ListModelMod(List list) {
		this.list = list;
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		
	}

	@Override
	public Object getElementAt(int index) {
		return list.get(index);
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		
	}

}
