package com.jdf.swing.helper;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import com.jdf.swing.iface.IconPackBase64;
import com.jdf.util.UtilMethod;

/**
 * Classe utilit�ria para objetos do tipo JToolBar
 * 
 * @author lossurdo
 * @since 15/03/2009
 */
public class JToolBarHelper {

	private JToolBar toolBar;
	private boolean border;

	/**
	 * Construtor
	 * @param toolBar
	 */
	public JToolBarHelper(JToolBar toolBar) {
		this.toolBar = toolBar;
	}

	/**
	 * Limpa toolbar
	 */
	public void clean() {
		setText("");
	}
	
	/**
	 * Adiciona um texto ao toolbar
	 * @param txt
	 */
	public void setText(final String txt) {
		toolBar.removeAll();
		toolBar.add(new JLabel(txt));
		toolBar.revalidate();
		toolBar.repaint();
	}
	
	/**
	 * Adiciona �cone ao toolbar
	 * @param icon
	 * @param toolTip
	 * @param action
	 */
	public void addIcon(IconPackBase64 icon, String toolTip, ActionListener action) {
		JButton bt = new JButton();
		bt.setBorderPainted(border);
		bt.setFocusable(false);

		if (toolTip != null)
			bt.setToolTipText(toolTip);

		if (action != null)
			bt.addActionListener(action);

		IconSets bh = new JButtonHelper(bt);
		bh.setIcon(icon);
		
		toolBar.add(bt);
	}

	/**
	 * Adiciona �cone ao toolbar
	 * @param icon
	 * @param toolTip
	 * @param object inst�ncia do objeto que cont�m o m�todo a ser executado
	 * @param actionMethod m�todo a ser executado
	 */
	public void addIcon(IconPackBase64 icon, String toolTip, final Object object, final String actionMethod) {
		JButton bt = new JButton();
		bt.setBorderPainted(border);
		bt.setFocusable(false);

		if (toolTip != null)
			bt.setToolTipText(toolTip);

		IconSets bh = new JButtonHelper(bt);
		bh.setIcon(icon);

		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UtilMethod.executeMethod(object, actionMethod);
			}
		});
		
		toolBar.add(bt);
	}

	/**
	 * Liga a borda para cada bot�o inserido 
	 */
	public void turnBorderOn() {
		this.border = true;
	}
	
	/**
	 * Habilita acesso ao bot�o
	 * @param pos posi��o do bot�o dentro do toolbar, iniciando em 1
	 */
	public void enableButton(int pos) {
		Component[] lis = toolBar.getComponents();
		if (pos < 1 || pos > lis.length)
			throw new IllegalArgumentException(
					"Posi��o do bot�o informada inv�lida");
		lis[pos-1].setEnabled(true);
	}
	
	/**
	 * Desabilita acesso ao bot�o
	 * @param pos posi��o do bot�o dentro do toolbar, iniciando em 1
	 */
	public void disableButton(int pos) {
		Component[] lis = toolBar.getComponents();
		if (pos < 1 || pos > lis.length)
			throw new IllegalArgumentException(
					"Posi��o do bot�o informada inv�lida");
		lis[pos-1].setEnabled(false);
	}
}
