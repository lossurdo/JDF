package com.jdf.security;

/**
 * Interface implementada pelos objetos de tela para controle de seguran�a
 * @author rafael-lossurdo
 * @since 22/04/2009
 */
public interface JDFSecurity {
	/**
	 * Verifica permiss�o do usu�rio logado
	 * @param object Objeto a ser verificado
	 * @param action A��o a ser verificada
	 */
	public void verifyPermission(String object, String action);
}
