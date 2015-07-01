package com.jdf.swing.helper;

import javax.swing.JFrame;

/**
 * Classe auxiliar para objetos JFrame
 * @author lossurdo
 * @since 01/03/2009
 */
public class JFrameHelper extends FrameDialogAbstract {

	private JFrame frame;

	/**
	 * Construtor
	 * @param frame
	 */
	public JFrameHelper(JFrame frame) {
		super(frame);
		this.frame = frame;
	}

	@Override
	public void setExitOnClose() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void setDisposeOnClose() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void setDoNothingOnClose() {
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void setHideOnClose() {
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	@Override
	public void centerFrame() {
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void setTitle(String title) {
		frame.setTitle(title);
	}
}
