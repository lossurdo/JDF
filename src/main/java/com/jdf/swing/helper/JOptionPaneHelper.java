package com.jdf.swing.helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Classe utilit�ria para apresenta��o de mensagens na tela (SWING)
 * @author lossurdo
 * @since 17/08/2008
 */
public class JOptionPaneHelper {
	public static final String DESEJA_MESMO_EXCLUIR_ESTE_ITEM = "Deseja mesmo excluir este item?";

	static {
		changeDefaultMessage();
	}
	
	public static String entryData(String msg) {
		return JOptionPane.showInputDialog(null, msg, "Aten��o", JOptionPane.QUESTION_MESSAGE);
	}
	
	/**
	 * Troca para portugu�s as mensagens do JOptionPane
	 */
	public static void changeDefaultMessage() {
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "N�o");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
	}
	
	public static void success() {
		JOptionPane.showMessageDialog(null, "Opera��o realizada com sucesso",
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
	 * Pedido de confirma��o
	 * @param msg Mensagem a ser mostrada na tela
	 * @param control Objeto que ser� testado, verificando se � ou n�o nulo
	 * @return Verdadeiro caso tenha se pressionado OK e o objeto n�o seja nulo
	 */
	public static Boolean confirmation(String msg, Object control) {
		int opt = JOptionPane.showConfirmDialog(null,
				msg, "Confirma��o",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (opt == JOptionPane.OK_OPTION && control!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Pedido de confirma��o
	 * @return Verdadeiro caso tenhas se pressionado OK
	 */
	public static Boolean confirmation(String msg) {
		return confirmation(msg, new Object());
	}
}
