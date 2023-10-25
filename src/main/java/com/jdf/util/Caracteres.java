package com.jdf.util;

/**
 * Classe utilitária para tratamento de Strings 
 * @author lossurdo
 * @since 20/04/2009
 */
public final class Caracteres {

	/**
	 * Adiciona zeros antes de um número
	 * @param value Valor
	 * @param numberOfZeros Número de casas a utilizar
	 * @return
	 */
	public static final String strzero(int value, int numberOfZeros) {
		String zeros = "";
		for (int i = 0; i < numberOfZeros; i++)
			zeros += "0";
		return value < 10 ? (zeros + value) : (zeros + value);
	}

	/**
	 * Adiciona um zero antes de um número
	 * @param value Valor
	 * @return
	 */
	public static final String strzero(int value) {
		return strzero(value, 0);
	}
	
	/**
	 * Capitalizar uma String
	 * @param s String
	 * @return Exemplo: de get para Get
	 */
    public static synchronized String capitalize(String s) {
        if (s.length() == 0) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

}
