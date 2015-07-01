package com.jdf.swing.helper;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * Classe auxiliar para objetos JFileChooser
 * @author lossurdo
 * @since 20/04/2009
 */
public final class JFileChooserHelper {

	private JFileChooser fileChooser;

	static {
		UIManager.put("FileChooser.lookInLabelText", "Consulte:");
		UIManager.put("FileChooser.lookInLabelMnemonic", "o");
		UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo:");
		UIManager.put("FileChooser.fileNameLabelMnemonic", "N");
		UIManager.put("FileChooser.filesOfTypeLabelText", "Arquivos do tipo:");
		UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "t");
		UIManager.put("FileChooser.upFolderToolTipText", "Um Nível Acima");
		UIManager.put("FileChooser.upFolderAccessibleName", "Para Cima");
		UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
		UIManager.put("FileChooser.homeFolderAccessibleName", "Inicio");
		UIManager.put("FileChooser.newFolderToolTipText", "Criar uma Nova Pasta");
		UIManager.put("FileChooser.newFolderAccessibleName", "Nova Pasta");
		UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
		UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");
		UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
		UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");
		UIManager.put("FileChooser.cancelButtonText", "Cancelar");
		UIManager.put("FileChooser.cancelButtonMnemonic", "C");
		UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
		UIManager.put("FileChooser.openButtonText", "Abrir");
		UIManager.put("FileChooser.openButtonMnemonic", "A");
		UIManager.put("FileChooser.saveButtonText", "Salvar");
		UIManager.put("FileChooser.saveButtonToolTipText", "Salvar Arquivo");
	}
	
	/**
	 * Construtor
	 * @param fileChooser
	 */
	public JFileChooserHelper(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	/**
	 * Construtor JFileChooser padrão
	 */
	public JFileChooserHelper() {
		this(new JFileChooser());
	}
	
	/**
	 * Referência do objeto JFileChooser, caso necessário
	 * @return
	 */
	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setApproveButtonText(String txt) {
		fileChooser.setApproveButtonText(txt);
	}

	public void setDialogTitle(String txt) {
		fileChooser.setDialogTitle(txt);
	}

	public int showOpenDialog(Component component) {
		return fileChooser.showOpenDialog(component);
	}

	public void setFileSelectionMode(int type) {
		fileChooser.setFileSelectionMode(type);
	}

	public File getSelectedFile() {
		return fileChooser.getSelectedFile();
	}
}
