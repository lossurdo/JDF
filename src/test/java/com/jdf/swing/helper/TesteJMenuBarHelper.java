/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TesteJMenu.java
 *
 * Created on Mar 24, 2009, 6:56:23 PM
 */

package com.jdf.swing.helper;

import com.jdf.swing.helper.JFrameHelper;
import com.jdf.swing.helper.JMenuBarHelper;
import com.jdf.swing.helper.JOptionPaneHelper;
import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.iface.Shortcut;

/**
 *
 * @author lossurdo
 */
public class TesteJMenuBarHelper extends javax.swing.JFrame {

    public TesteJMenuBarHelper() {
        initComponents();
        
        JFrameHelper jh = new JFrameHelper(this);
        jh.setTitle("Componente de Menu");
        jh.setMediumSize();
        jh.centerFrame();
        
        JMenuBarHelper jmbh = new JMenuBarHelper(menuBar);
        jmbh.addMenu("Arquivo", 'a')
        	.addItem(this, "menuAbrir", "Abrir...", IconPackBase64.FOLDER_PAGE, Shortcut.F5, 'b')
        	.addSeparator()
        	.addItem(this, "sair", "Fechar", IconPackBase64.DOOR_IN);
        jmbh.addMenu("Sobre", 's')
        	.addItem(this,"menuSobre","Copyright(c)",IconPackBase64.USER, Shortcut.F3, 'y');
    }

    public void sair() {
    	System.exit(0);
    }
    
    public void menuSobre() {
    	JOptionPaneHelper.warning("Clicado em Copyright");
    }
    
    public void menuAbrir() {
    	JOptionPaneHelper.warning("Clicado em Abrir");
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesteJMenuBarHelper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
