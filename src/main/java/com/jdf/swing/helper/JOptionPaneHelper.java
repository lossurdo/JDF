package com.jdf.swing.helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Classe utilitária para apresentação de mensagens na tela (SWING)
 * @author lossurdo
 * @since 17/08/2008
 */
public class JOptionPaneHelper {
	public static final String DESEJA_MESMO_EXCLUIR_ESTE_ITEM = "Deseja mesmo excluir este item?";

	static {
		changeDefaultMessage();
	}
	
	public static String entryData(String msg) {
		return JOptionPane.showInputDialog(null, msg, "Atenção", JOptionPane.QUESTION_MESSAGE);
	}
	
	/**
	 * Troca para português as mensagens do JOptionPane
	 */
	public static void changeDefaultMessage() {
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
	}
	
	public static void success() {
		JOptionPane.showMessageDialog(null, "Operação realizada com sucesso",
				"Mensagem", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void error(Throwable e) {
		JOptionPane.showMessageDialog(null, e.getMessage(),
				"Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void error(String msg) {
		JOptionPane.showMessageDialog(null, msg,
				"Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void warning(Throwable e) {
		JOptionPane.showMessageDialog(null, e.getMessage(),
				"Mensagem", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void warning(String msg) {
		JOptionPane.showMessageDialog(null, msg,
				"Mensagem", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void simpleMessage(String msg) {
		warning(msg);
	}
	
	/**
	 * Pedido de confirmação
	 * @param msg Mensagem a ser mostrada na tela
	 * @param control Objeto que será testado, verificando se é ou não nulo
	 * @return Verdadeiro caso tenha se pressionado OK e o objeto não seja nulo
	 */
	public static Boolean confirmation(String msg, Object control) {
		int opt = JOptionPane.showConfirmDialog(null,
				msg, "Confirmação",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opt == JOptionPane.OK_OPTION && control!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Pedido de confirmação
	 * @return Verdadeiro caso tenhas se pressionado OK
	 */
	public static Boolean confirmation(String msg) {
		return confirmation(msg, new Object());
	}
}
