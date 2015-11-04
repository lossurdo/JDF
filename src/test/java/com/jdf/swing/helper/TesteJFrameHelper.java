package com.jdf.swing.helper;

import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.misc.SplashScreen;
import com.jdf.util.Propriedades;
import javax.swing.JFrame;

public class TesteJFrameHelper extends JFrame {

	static SplashScreen splash = new SplashScreen();

	public TesteJFrameHelper() {
		splash.TEMPO_MINIMO_ABERTURA_SPLASH = 10000;
		
		JFrameHelper j = new JFrameHelper(this);
		j.setIcon(IconPackBase64.ATTACH);		
		j.setHugeSize();
		j.centerFrame();
		j.setExitOnClose();
		j.setTitle(Propriedades.getInstance().get("sistema.titulo"));
		setVisible(true);
		
		splash.cancelExibition();
		splash = null;
	}

	public static void main(String[] args) {
		new TesteJFrameHelper();
	}

}
