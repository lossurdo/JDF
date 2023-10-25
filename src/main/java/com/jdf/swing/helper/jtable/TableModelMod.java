package com.jdf.swing.helper.jtable;

import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.jdf.util.UtilMethod;

/**
 * Classe utilizada para representar os dados
 * inserido em componentes JTable
 * @author lossurdo
 * @since 22/03/2009
 */
@SuppressWarnings({"unchecked"})
class TableModelMod implements TableModel {

    private Collection collection;
    private List<String> columns;
    private List<String> columnHeader;
    private List<ColumnMetadataFormat> columnFormat;

    /**
     * Construtor
     * @param list Listagem
     */
    public TableModelMod(Collection list) {
        this.collection = list;

        columns = new ArrayList<String>();
        columnHeader = new ArrayList<String>();
        columnFormat = new ArrayList<ColumnMetadataFormat>();

        if (collection != null && collection.size() > 0) {
            for (Object obj : collection) {
                Field[] attr = obj.getClass().getDeclaredFields();

                for (Field f : attr) {
                    if(JTableAssist.isAnnotated(f)) {
                        columns.add("get" + JTableAssist.capitalize(f.getName()));
                        columnHeader.add(JTableAssist.getColumnHeaderName(f));
                        columnFormat.add(JTableAssist.getColumnFormat(f));
                    }
                }

                break;
            }
        }
    }

    public int getRowCount() {
        return collection.size();
    }

    public int getColumnCount() {
        return columns.size();
    }

    public String getColumnName(int columnIndex) {
        return columnHeader.get(columnIndex);
    }

    /**
     * TODOS OBJETOS STRING
     */
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    /**
     * NENHUMA CÉLULA EDITÁVEL
     */
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        List lista = new ArrayList(collection);
        Object obj = lista.get(rowIndex);
        Object ret = UtilMethod.executeMethod(obj, columns.get(columnIndex));
        
        if(columnFormat.get(columnIndex).equals(ColumnMetadataFormat.CURRENCY)) {
        	return NumberFormat.getCurrencyInstance().format(new Double((Double) ret)); 
        } else if(columnFormat.get(columnIndex).equals(ColumnMetadataFormat.DATE_DD_MM_YYYY)) {
        	validateDateField(ret);
        	Calendar cal = Calendar.getInstance();
        	setDateCalendar(ret, cal);
        	return cal.get(Calendar.DAY_OF_MONTH) + "/"
					+ formatSingleNumber(cal.get(Calendar.MONTH)) + "/"
					+ cal.get(Calendar.YEAR);
        } else if(columnFormat.get(columnIndex).equals(ColumnMetadataFormat.DATE_DD_MM_YYYY_HH_MM)) {
        	validateDateField(ret);
        	Calendar cal = Calendar.getInstance();
        	setDateCalendar(ret, cal);
        	return cal.get(Calendar.DAY_OF_MONTH) + "/"
					+ formatSingleNumber(cal.get(Calendar.MONTH)) + "/"
					+ cal.get(Calendar.YEAR) + " " + 
					formatSingleNumber(cal.get(Calendar.HOUR_OF_DAY)) + ":" + 
					formatSingleNumber(cal.get(Calendar.MINUTE));
        } else if(columnFormat.get(columnIndex).equals(ColumnMetadataFormat.DATE_MM_YYYY)) {
        	validateDateField(ret);
        	Calendar cal = Calendar.getInstance();
        	setDateCalendar(ret, cal);
        	return formatSingleNumber(cal.get(Calendar.MONTH)) + "/"
					+ cal.get(Calendar.YEAR);
        } else { // DEFAULT        
        	return ret;
        }
    }

    /**
     * Formata número, adicionando zero (ex. 9 para 09)
     * @param number
     * @return
     */
    private String formatSingleNumber(int number) {
    	number++;
    	if(number<10) {
    		return "0"+number; 
    	} else {
    		return ""+number;
    	}
    }
    
    /**
     * Verifica o tipo de data passada (Date ou Calendar) e faz o casting
     * @param ret Objeto a ser testado
     * @param cal Calendar
     */
	private void setDateCalendar(Object ret, Calendar cal) {
		if(ret instanceof Date) {
			cal.setTime((Date) ret);
		} else {
			cal.setTime(((Calendar) ret).getTime());
		}
	}

	/**
	 * Valida se objeto passível de retorno é do tipo Date ou Calendar
	 * @param ret
	 */
	private void validateDateField(Object ret) {
		if(!(ret instanceof Date) && !(ret instanceof Calendar)) {
			throw new RuntimeException("Informado formato de data para campo diferente de Date e Calendar");
		}
	}

    /**
     * NÃO IMPLEMENTADO
     */
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // nada
    }

    /**
     * NÃO IMPLEMENTADO
     */
    public void addTableModelListener(TableModelListener l) {
        // nada
    }

    /**
     * NÃO IMPLEMENTADO
     */
    public void removeTableModelListener(TableModelListener l) {
        // nada
    }
}
