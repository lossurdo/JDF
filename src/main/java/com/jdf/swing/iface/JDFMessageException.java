package com.jdf.swing.iface;

/**
 * Exceção utilizada para lançar mensagens para interface
 * @author lossurdo
 * @since 22/03/2009
 */
public class JDFMessageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor
	 * @param txt Mensagem
	 */
	public JDFMessageException(String txt) {
		super(txt);
	}

	/**
	 * Construtor
	 * @param ex Objeto Throwable
	 */
	public JDFMessageException(Throwable ex) {
		super(ex);
	}

}
