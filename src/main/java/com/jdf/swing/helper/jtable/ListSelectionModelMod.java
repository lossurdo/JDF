package com.jdf.swing.helper.jtable;

import java.util.Collection;

import javax.swing.DefaultListSelectionModel;

/**
 * Classe utilizada para configurar características
 * de seleção para o componente JTable 
 * @author lossurdo
 * @since 22/03/2009
 */
@SuppressWarnings({"serial","unchecked"})
class ListSelectionModelMod extends DefaultListSelectionModel {

//    private Collection collection;

    /**
     * Construtor
     * @param list Listagem a ser exibida
     */
    public ListSelectionModelMod(Collection list) {
        super();
//        this.collection = list;
        super.setSelectionMode(SINGLE_SELECTION);
    }

}
