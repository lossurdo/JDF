package com.jdf.util;

import java.lang.reflect.Method;

/**
 * Utilit�rio para tratar de reflex�o em classes
 * @author lossurdo
 * @since 15/03/2009
 */
public final class UtilMethod {
	
	/**
	 * Executa a a��o sem passagem de par�metros
	 * @param object inst�ncia do objeto que cont�m o m�todo a ser executado
	 * @param method m�todo a ser executado
	 */
	
	public static synchronized Object executeMethod(Object object, String method) {
		try {
			Class<?> clazz = object.getClass();
			Method m = clazz.getDeclaredMethod(method, null);
			m.setAccessible(true);
			return m.invoke(object, null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
