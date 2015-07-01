package com.jdf.swing.misc;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.KeyStroke;

import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.iface.ImageReaderBase64;
import com.jdf.swing.iface.Shortcut;
import com.jdf.util.UtilMethod;

/**
 * Classe utilizada para exibir e controlar itens de menu no traybar
 * @author lossurdo
 * @since 29/03/2009
 */
public class TrayBar {

	private SystemTray tray;
	private Image icon;
	private String tooltip;
	private PopupMenu popupMenu;
	private TrayIcon trayIcon;

	/**
	 * Construtor
	 */
	public TrayBar() {
		tray = SystemTray.getSystemTray();
		popupMenu = new PopupMenu();
	}

	/**
	 * Construtor
	 * 
	 * @param icon
	 */
	public TrayBar(IconPackBase64 icon) {
		this();
		this.setIcon(new ImageReaderBase64(icon).toImage().getImage());
	}

	/**
	 * Construtor
	 * 
	 * @param icon
	 * @param tooltip
	 */
	public TrayBar(IconPackBase64 icon, String tooltip) {
		this(icon);
		this.setTooltip(tooltip);
	}

	/**
	 * Adiciona um item ao menu
	 * @param object Objeto que contém o método a ser executado no momento do clique
	 * @param action Nome do método a ser executado
	 * @param txt Texto do menu
	 * @return
	 */
	public TrayBar addItem(Object object,String action, String txt) {
		return addItem(object, action, txt, null);
	}

	/**
	 * Adiciona um item ao menu
	 * @param object Objeto que contém o método a ser executado no momento do clique
	 * @param action Nome do método a ser executado
	 * @param txt Texto do menu
	 * @param shortcut Tecla de atalho
	 * @return
	 */
	public TrayBar addItem(final Object object, final String action,
			String txt, Shortcut shortcut) {
		MenuItem mi = null;
		if (shortcut == null) {
			mi = new MenuItem(txt);
		} else {
			mi = new MenuItem(txt, new MenuShortcut(KeyStroke
					.getKeyStroke(shortcut.toString()).getKeyCode()));
		}
		mi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UtilMethod.executeMethod(object, action);
			}
		});
		popupMenu.add(mi);
		return this;
	}

	/**
	 * Adiciona um separador ao menu
	 * @return
	 */
	public TrayBar addSeparator() {
		popupMenu.addSeparator();
		return this;
	}

	/**
	 * Inicializa e exibe o icone no traybar
	 */
	public void display() {
		trayIcon = new TrayIcon(icon, tooltip);
		trayIcon.setImageAutoSize(true);
		trayIcon.setPopupMenu(popupMenu);
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Mostra mensagem popup de informação
	 * @param caption Título
	 * @param txt Mensagem
	 */
	public void popupInfoMessage(String caption, String txt) {
		popupMessage(caption, txt, MessageType.INFO);
	}
	
	/**
	 * Mostra mensagem popup de erro
	 * @param caption Título
	 * @param txt Mensagem
	 */
	public void popupErrorMessage(String caption, String txt) {
		popupMessage(caption, txt, MessageType.ERROR);
	}
	
	/**
	 * Mostra mensagem popup de alerta
	 * @param caption Título
	 * @param txt Mensagem
	 */
	public void popupWarningMessage(String caption, String txt) {
		popupMessage(caption, txt, MessageType.WARNING);
	}
	
	private void popupMessage(String caption, String txt, MessageType messageType) {
		if (trayIcon != null) {
			trayIcon.displayMessage(caption, txt, messageType);
		}
	}
	
	/**
	 * Informa se o traybar é compatível com o SO em questão
	 * @return
	 */
	public static Boolean isSupported() {
		return SystemTray.isSupported();
	}

	/**
	 * Seta icone do traybar
	 * @param icon
	 */
	public void setIcon(Image icon) {
		this.icon = icon;
	}

	/**
	 * Seta dica ao posicionar o mouse no traybar
	 * @param tooltip
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

}
