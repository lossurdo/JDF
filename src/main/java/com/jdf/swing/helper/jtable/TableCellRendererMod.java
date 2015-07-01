package com.jdf.swing.helper.jtable;

import java.awt.Component;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe utilizada para formatar a exibição de dados em uma listagem para o
 * componente JTable
 * 
 * @author lossurdo
 * @since 22/03/2009
 */
@SuppressWarnings( { "unchecked" })
class TableCellRendererMod extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	private Collection collection;
	private List<ColumnMetadataAlign> columns;

	/**
	 * Construtor
	 * @param list
	 * @param highlight Diferenciação entre as linhas exibidas
	 */
	public TableCellRendererMod(Collection list, Boolean highlight) {
		super();
		this.collection = list;
		
        columns = new ArrayList<ColumnMetadataAlign>();

        if (collection != null && collection.size() > 0) {
            for (Object obj : collection) {
                Field[] attr = obj.getClass().getDeclaredFields();

                for (Field f : attr) {
                    if(JTableAssist.isAnnotated(f)) {
                        columns.add(JTableAssist.getColumnAlign(f));
                    }
                }

                break;
            }
        }
	}
	
	/**
	 * Construtor
	 * @param list
	 */
	public TableCellRendererMod(Collection list) {
		this(list, false);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		// controle de alinhamento das colunas
		if(columns.get(column).equals(ColumnMetadataAlign.CENTER))
			setHorizontalAlignment(CENTER);
		if(columns.get(column).equals(ColumnMetadataAlign.LEFT))
			setHorizontalAlignment(LEFT);
		if(columns.get(column).equals(ColumnMetadataAlign.RIGHT))
			setHorizontalAlignment(RIGHT);

		return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
	}
}
