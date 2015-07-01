package com.jdf.swing.helper;

import javax.swing.JFrame;

import com.jdf.swing.helper.JFrameHelper;
import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.misc.SplashScreen;
import com.jdf.util.JDFProperties;

public class TesteJFrameHelper extends JFrame {

	static SplashScreen splash = new SplashScreen();

	public TesteJFrameHelper() {
		splash.TEMPO_MINIMO_ABERTURA_SPLASH = 10000;
		
		JFrameHelper j = new JFrameHelper(this);
		j.setIcon(IconPackBase64.ATTACH);		
		j.setHugeSize();
		j.centerFrame();
		j.setExitOnClose();
		j.setTitle(JDFProperties.getInstance().get("sistema.titulo"));
		setVisible(true);
		
		splash.cancelExibition();
		splash = null;
	}

	public static void main(String[] args) {
		new TesteJFrameHelper();
	}

}
