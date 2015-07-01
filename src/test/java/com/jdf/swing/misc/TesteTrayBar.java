package com.jdf.swing.misc;

import com.jdf.swing.helper.JOptionPaneHelper;
import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.misc.TrayBar;

public class TesteTrayBar {

	public static void main(String[] args) {

		TrayBar tb = new TrayBar(IconPackBase64.STAR, "Clique aqui");
		tb.addItem(new TesteTrayBar(), "acaoA", "Valor A").
			addSeparator().
			addItem(new TesteTrayBar(), "acaoB","Valor B").
			addSeparator().
			addItem(new TesteTrayBar(), "exit","Sair");
		tb.display();

	}

	public void acaoA() {
		JOptionPaneHelper.warning("Ação A");
	}
	
	public void acaoB() {
		JOptionPaneHelper.warning("Ação B");		
	}
	
	public void exit() {
		System.exit(0);
	}
}
