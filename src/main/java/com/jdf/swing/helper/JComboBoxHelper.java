package com.jdf.swing.helper;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Classe auxiliar para criação do objeto combobox
 * 
 * @author lossurdo
 * @since 01/03/2009
 */
@SuppressWarnings("unchecked")
public class JComboBoxHelper {

	private JComboBox combobox;

	public JComboBoxHelper(JComboBox combobox) {
		this.combobox = combobox;
	}

	public void setModel(String... values) {
		combobox.setModel(new DefaultComboBoxModel(values));
	}

	public void setModel(List list) {
		combobox.setModel(new ComboBoxModelMod(list));
	}
	
	public Object getSelectedObject() {
		return combobox.getSelectedItem();
	}
}
