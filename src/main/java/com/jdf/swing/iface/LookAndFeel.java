package com.jdf.swing.iface;

import javax.swing.UIManager;

/**
 * Classe responsável pelo look and feel
 *
 * @author lossurdo
 * @since 01/03/2009
 */
public class LookAndFeel {

    /**
     * Seta LAF nativo do sistema operacional em questão
     */
    public static void setNativeLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            LookAndFeel.setJavaLookAndFeel();
            throw new RuntimeException(e);
        }
    }

    /**
     * Seta LAF nativo do Java
     */
    public static void setJavaLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager
                    .getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Seta LAF Motif
     */
    public static void setMotifLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Seta LAF Nimbus
     */
    public static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
