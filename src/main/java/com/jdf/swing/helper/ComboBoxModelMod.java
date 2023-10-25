package com.jdf.swing.helper;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 * Classe responsável pela estrutura de dados utilizada pelo componente
 * JComboBoxHelper
 *
 * @author lossurdo
 * @since 12/03/2009
 */
@SuppressWarnings("unchecked")
class ComboBoxModelMod implements ComboBoxModel {

    private List list;
    private Object sel;

    /**
     * Construtor
     *
     * @param list Listagem de objetos
     */
    public ComboBoxModelMod(List list) {
        this.list = list;
    }

    @Override
    public Object getSelectedItem() {
        return sel;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.sel = anItem;
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
