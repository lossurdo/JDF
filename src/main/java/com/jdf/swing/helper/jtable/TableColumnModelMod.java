package com.jdf.swing.helper.jtable;

import java.lang.reflect.Field;
import java.util.Collection;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 * Classe utilizada para configurar as características das colunas
 * adicionadas em um componente JTable
 * @author lossurdo
 * @since 22/03/2009
 */
@SuppressWarnings({"serial","unchecked"})
class TableColumnModelMod extends DefaultTableColumnModel {

	private Collection collection;

    /**
     * Construtor
     * @param list Listagem
     */
    public TableColumnModelMod(Collection list) {
        super();
        this.collection = list;
    }

    /**
     * Método utilizado para controlar a largura
     * das colunas adicionadas no componente JTable
     * @param tc
     */
    @Override
    public void addColumn(TableColumn tc) {
    	if (collection.size() == 0) {
			return;
		}
        String hv = tc.getHeaderValue().toString();
        for (Object obj : collection) {
            Field[] attr = obj.getClass().getDeclaredFields();
            for (Field f : attr) {
                if (JTableAssist.isAnnotated(f) && JTableAssist.getColumnHeaderName(f).equals(hv)) {
                    JTableColumnMetadata an = f.getAnnotation(JTableColumnMetadata.class);
                    if (an.size() != 0) {
                        tc.setPreferredWidth(an.size());
                        tc.setMinWidth(an.size());
                        tc.setMaxWidth(an.size());
                    }
                }
            }
            break; // só precisa do primeiro registro para determinar as colunas
        }
        super.addColumn(tc);
    }
}
