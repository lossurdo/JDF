package com.jdf.swing.helper;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jdf.swing.helper.JButtonHelper;
import com.jdf.swing.helper.JFrameHelper;
import com.jdf.swing.helper.JOptionPaneHelper;
import com.jdf.swing.iface.IconPackBase64;

public class TesteJButtonHelper extends JFrame {

	public TesteJButtonHelper() {
		JFrameHelper jfh = new JFrameHelper(this);
		jfh.setIcon(IconPackBase64.APPLICATION);
		jfh.setMediumSize();
		jfh.setExitOnClose();
		jfh.setTitle("JDF - Java Desktop Framework");
		jfh.centerFrame();
		
		
		setLayout(new FlowLayout());
		JButton bt = new JButton("Exemplo Icone");
		JButton bt2 = new JButton();
		
		JButtonHelper h = new JButtonHelper(bt);
		h.setIcon(IconPackBase64.SHIELD);
		
		JButtonHelper h2 = new JButtonHelper(bt2);
		h2.transformToLOV(this, "chamaLov");
		
		add(bt);
		add(new JLabel("Clique aqui para acessar a LOV:"));				
		add(bt2);
		
		setVisible(true);
	}

	public void chamaLov() {
		JOptionPaneHelper.warning("Este método chamaria uma janela de LOV (JDialog)");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TesteJButtonHelper();
	}

}
