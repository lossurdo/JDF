package com.jdf.swing.helper;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.jdf.swing.helper.JDialogHelper;
import com.jdf.swing.helper.JFrameHelper;
import com.jdf.swing.iface.IconPackBase64;

public class TesteJDialogHelper extends JFrame {

	public TesteJDialogHelper()  {
		JFrameHelper jfh = new JFrameHelper(this);
		jfh.setIcon(IconPackBase64.APPLICATION);
		jfh.setMediumSize();
		jfh.setExitOnClose();
		jfh.setTitle("JDF - Java Desktop Framework");
		jfh.centerFrame();
	}

	public static void main(String[] args) {
		TesteJDialogHelper v = new TesteJDialogHelper();
		v.setVisible(true);

		JDialog d = new JDialog();
		JDialogHelper jd = new JDialogHelper(d, v);
		jd.setIcon(IconPackBase64.ZOOM);
		jd.setSmallSize();
		jd.setHideOnClose();
		jd.setTitle("Teste de Dialog");
		jd.centerFrame();
		
		d.setVisible(true);
	}

}
