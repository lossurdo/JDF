package com.jdf.swing.helper.jtable;

/**
 * Enum utilizado para formatar os dados que serão apresentados
 * no componente JTable
 * @author lossurdo
 * @since 22/03/2009
 */
public enum ColumnMetadataFormat {
	/**
	 * Formato Padrão
	 */
	DEFAULT(null),
	/**
	 * Formato Moeda
	 */
	CURRENCY(null),
	/**
	 * Formato dd/mm/yyyy
	 */
	DATE_DD_MM_YYYY("dd/MM/yyyy"),
	/**
	 * Formato mm/yyyy
	 */
	DATE_MM_YYYY("MM/yyyy"), 
	/**
	 * Formato dd/mm/yyyy hh:mm
	 */
	DATE_DD_MM_YYYY_HH_MM("dd/MM/YYYY HH:mm");
	
	private String value;

	private ColumnMetadataFormat(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
