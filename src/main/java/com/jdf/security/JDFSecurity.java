package com.jdf.security;

/**
 * Interface implementada pelos objetos de tela para controle de segurança
 * @author rafael-lossurdo
 * @since 22/04/2009
 */
public interface JDFSecurity {
	/**
	 * Verifica permissão do usuário logado
	 * @param object Objeto a ser verificado
	 * @param action Ação a ser verificada
	 */
	public void verifyPermission(String object, String action);
}
