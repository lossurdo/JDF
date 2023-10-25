package com.jdf.swing.misc;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.jdf.swing.iface.JDFDefaultImages;

/**
 * Classe utilitária para criação de splash screen
 *
 * @author lossurdo
 * @since 15/03/2009
 */
public final class SplashScreen {

    public static int TEMPO_MINIMO_ABERTURA_SPLASH = 3000; // milisegundos
    private int altura;
    private int largura;
    private JFrame frame;
    private long momentoInicial;

    /**
     * Construtor default.<br>
     * Exibe automaticamente o splash screen ao ser instanciado.
     */
    public SplashScreen() {
        this(JDFDefaultImages.getSplashImage());
    }

    /**
     * Construtor.<br>
     * Exibe automaticamente o splash screen ao ser instanciado.
     */
    public SplashScreen(ImageIcon image) {
        momentoInicial = System.currentTimeMillis();
        frame = new JFrame("Carregando...");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setUndecorated(true);

        // determina tamanho do splashscreen
        final ImageIcon img = image;
        altura = img.getIconHeight();
        largura = img.getIconWidth();

        JPanel p = new JPanel(new BorderLayout()) {
            private static final long serialVersionUID = 1L;
            Image image = img.getImage();

            {
                setOpaque(false);
            }

            public void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, this);
                super.paintComponent(g);
            }
        };

        final JProgressBar prog = new JProgressBar(0, 100);
        prog.setIndeterminate(true);
        frame.add(prog, BorderLayout.SOUTH);

        frame.add(p, BorderLayout.CENTER);
        frame.setSize(largura, altura);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Cancela exibição do splashscreen
     */
    public void cancelExibition() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if ((System.currentTimeMillis() - momentoInicial) > TEMPO_MINIMO_ABERTURA_SPLASH) {
                        frame.setVisible(false);
                        while (frame.isVisible() && frame != null) {
                            frame = null;
                        }
                    }
                }
            }
        }.start();
    }

}
