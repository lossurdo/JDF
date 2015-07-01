
package com.jdf.swing.helper.jtable;

import java.lang.reflect.Field;

/**
 * Classe utilitária para uso nos componentes JTable
 * @author lossurdo
 * @since 22/03/2009
 */
class JTableAssist {

	/**
	 * Capitaliza uma String (ex. umTeste para UmTeste)
	 * @param s Valor
	 * @return
	 */
    public static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * Verifica se um atributo de uma classe (Field) está anotado com JTableColumnMetadata
     * @param f Atributo
     * @return
     */
    public static boolean isAnnotated(Field f) {
        JTableColumnMetadata an = f.getAnnotation(JTableColumnMetadata.class);
        if (an == null) {
            return false;
        }
        return true;
    }

    /**
     * Verifica qual o nome da coluna anotada em um atributo através da annotation JTableColumnMetadata
     * @param f Atributo
     * @return
     */
    public static String getColumnHeaderName(Field f) {
        JTableColumnMetadata an = f.getAnnotation(JTableColumnMetadata.class);
        if (an == null) {
            return "N/D";
        } else {
            return an.name();
        }
    }

    /**
     * Verifica qual o formato da coluna anotada em um atributo através da annotation JTableColumnMetadata
     * @param f Atributo
     * @return
     */
    public static ColumnMetadataFormat getColumnFormat(Field f) {
        JTableColumnMetadata an = f.getAnnotation(JTableColumnMetadata.class);
        if (an == null) {
            return ColumnMetadataFormat.DEFAULT;
        } else {
            return an.format();
        }
    }

    /**
     * Verifica qual o alinhamento da coluna anotada em um atributo através da annotation JTableColumnMetadata
     * @param f Atributo
     * @return
     */
	public static ColumnMetadataAlign getColumnAlign(Field f) {
        JTableColumnMetadata an = f.getAnnotation(JTableColumnMetadata.class);
        if (an == null) {
            return ColumnMetadataAlign.LEFT;
        } else {
            return an.align();
        }
	}
}
