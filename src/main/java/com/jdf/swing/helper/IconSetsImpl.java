package com.jdf.swing.helper;

import java.awt.Component;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.iface.ImageReaderBase64;

/**
 * Classe abstrata que implementa a formatação de ícones
 * @author lossurdo
 * @since 16/04/2009
 */
abstract class IconSetsImpl implements IconSets {

	private static final String MSG_EXCEPTION = "Este componente não foi mapeado no framework, deve-se implementar: ";
	protected Component window;

	/**
	 * Construtor
	 * @param window Objeto do tipo janela
	 */
	protected IconSetsImpl(Window window) {
		this.window = window;
	}

	@Override
	public void setIcon(ImageIcon icon) {
		if(window instanceof JButton) {
			JButton comp = (JButton) window;
			comp.setIcon(icon);
		} else if(window instanceof JFrame) {
			JFrame comp = (JFrame) window;
			comp.setIconImage(icon.getImage());
		} else if(window instanceof JDialog) {
			JDialog comp = (JDialog) window;
			comp.setIconImage(icon.getImage());
		} else {
			throw new RuntimeException(MSG_EXCEPTION + window.getClass());
		}
	}

	@Override
	public void setIcon(IconPackBase64 icon) {
		if(window instanceof JButton) {
			JButton comp = (JButton) window;
			comp.setIcon(new ImageReaderBase64(icon).toImage());
		} else if(window instanceof JFrame) {
			JFrame comp = (JFrame) window;
			comp.setIconImage(new ImageReaderBase64(icon).toImage().getImage());
		} else if(window instanceof JDialog) {
			JDialog comp = (JDialog) window;
			comp.setIconImage(new ImageReaderBase64(icon).toImage().getImage());
		} else {
			throw new RuntimeException(MSG_EXCEPTION + window.getClass());
		}
	}

	@Override
	public void setIcon(String icon) {
		if(window instanceof JButton) {
			JButton comp = (JButton) window;
			comp.setIcon(new ImageReaderBase64(icon).toImage());
		} else if(window instanceof JFrame) {
			JFrame comp = (JFrame) window;
			comp.setIconImage(new ImageReaderBase64(icon).toImage().getImage());
		} else if(window instanceof JDialog) {
			JDialog comp = (JDialog) window;
			comp.setIconImage(new ImageReaderBase64(icon).toImage().getImage());
		} else {
			throw new RuntimeException(MSG_EXCEPTION + window.getClass());
		}
	}

	/**
	 * Devolve uma referência ao objeto da janela
	 * @return
	 */
	protected Component getWindow() {
		return window;
	}

	/**
	 * Seta um objeto de janela
	 * @param window
	 */
	protected void setWindow(Component window) {
		this.window = window;
	}
}
