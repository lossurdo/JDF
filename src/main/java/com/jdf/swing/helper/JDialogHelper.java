package com.jdf.swing.helper;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Classe auxiliar para objetos JDialog
 * @author lossurdo
 * @since 16/04/2009
 */
public final class JDialogHelper extends FrameDialogAbstract {

	private JDialog dialog;

	/**
	 * Construtor
	 * @param dialog
	 */
	public JDialogHelper(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;
	}

	/**
	 * Construtor para forma modal do componente
	 * @param dialog
	 * @param container Container pai
	 */
	public JDialogHelper(JDialog dialog, JFrame container) {
		super(dialog);
		this.dialog = dialog;
		this.dialog.setContentPane(container.getContentPane());
		this.dialog.setModal(true);
	}

	@Override
	public void setExitOnClose() {
		dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	}

	@Override
	public void setDisposeOnClose() {
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	@Override
	public void setDoNothingOnClose() {
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void setHideOnClose() {
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	}

	@Override
	public void centerFrame() {
		dialog.setLocationRelativeTo(null);
	}

	@Override
	public void setTitle(String title) {
		dialog.setTitle(title);
	}
}
