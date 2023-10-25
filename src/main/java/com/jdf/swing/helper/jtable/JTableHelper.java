package com.jdf.swing.helper.jtable;

import java.util.List;

import javax.swing.JTable;

import com.jdf.swing.iface.JDFMessageException;

/**
 * Classe auxiliar para objetos JTable
 * @author lossurdo
 * @since 22/03/2009
 * @param <T> ED a ser listado no componente JTable
 */
public class JTableHelper<T> {

    private JTable table;
    private List<T> sourceList;

    /**
     * Construtor
     * @param table
     */
    public JTableHelper(JTable table) {
        this.table = table;
    }

    /**
     * Seta a lista padrão
     * @param list
     */
    public void setModel(List<T> list) {
        this.sourceList = list;
        table.setColumnModel(new TableColumnModelMod(list));
        table.setModel(new TableModelMod(list));
        table.setSelectionModel(new ListSelectionModelMod(list));
        table.setDefaultRenderer(Object.class, new TableCellRendererMod(list));
    }
    
    /**
     * Devolve o ED selecionado no JTable
     * @return ED
     */
    public T getSelectedObject() {
    	if(!table.getSelectionModel().isSelectionEmpty()) {
    		return sourceList.get(table.getSelectionModel().getLeadSelectionIndex());
    	}
		throw new JDFMessageException("Nenhuma linha selecionada"); 
    }
}
