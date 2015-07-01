package com.jdf.swing.helper;

import java.awt.Window;

/**
 * Classe abstrata utilizada pelos componenes JDialog e JFrame 
 * @author lossurdo
 * @since 19/04/2009
 */
abstract class FrameDialogAbstract extends IconSetsImpl {

	/**
	 * Construtor
	 * @param window Objeto do tipo janela
	 */
	public FrameDialogAbstract(Window window) {
		super(window);
		setWindow(window);
	}

	/**
	 * Seta o título da janela
	 * @param title Título
	 */
	public abstract void setTitle(String title);
	
	/**
	 * Centraliza janela
	 */
	public abstract void centerFrame();

	/**
	 * Seta o tamanho da janela
	 */
	public void setSmallSize() {
		getWindow().setSize(300, 200);
	}

	/**
	 * Seta o tamanho da janela
	 */
	public void setMediumSize() {
		getWindow().setSize(600, 450);
	}

	/**
	 * Seta o tamanho da janela
	 */
	public void setBigSize() {
		getWindow().setSize(800, 600);
	}

	/**
	 * Seta o tamanho da janela
	 */
	public void setBiggerSize() {
		getWindow().setSize(900, 700);
	}

	/**
	 * Seta o tamanho da janela
	 */
	public void setHugeSize() {
		getWindow().setSize(1024, 768);
	}

	/**
	 * Seta o tamanho da janela
	 */
	public void setReallyHugeSize() {
		getWindow().setSize(1280, 800);
	}

	/**
	 * Modifica a forma como a janela se comporta ao fechar
	 */
	public abstract void setExitOnClose();

	/**
	 * Modifica a forma como a janela se comporta ao fechar
	 */
	public abstract void setDisposeOnClose();

	/**
	 * Modifica a forma como a janela se comporta ao fechar
	 */
	public abstract void setDoNothingOnClose();

	/**
	 * Modifica a forma como a janela se comporta ao fechar
	 */
	public abstract void setHideOnClose();

}
