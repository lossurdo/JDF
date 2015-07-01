/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TesteToolbar.java
 *
 * Created on Mar 15, 2009, 12:42:42 PM
 */

package com.jdf.swing.helper;

import com.jdf.swing.helper.JFrameHelper;
import com.jdf.swing.helper.JOptionPaneHelper;
import com.jdf.swing.helper.JToolBarHelper;
import com.jdf.swing.iface.IconPackBase64;
import com.jdf.util.JDFProperties;

/**
 *
 * @author lossurdo
 */
public class TesteJToolBar extends javax.swing.JFrame {

    /** Creates new form TesteToolbar */
    public TesteJToolBar() {
        initComponents();
        
        JToolBarHelper jt = new JToolBarHelper(tool);
        jt.addIcon(IconPackBase64.ADD, "Adicionar", this, "acaoAdd");
        jt.addIcon(IconPackBase64.CAKE, "Bolo", this, "acaoAdd");
        jt.addIcon(IconPackBase64.CALCULATOR, "Calculadora", this, "acaoAdd");
        jt.addIcon(IconPackBase64.TELEPHONE, "Telefone", this, "acaoAdd");
        jt.addIcon(IconPackBase64.CONNECT, "Conectar", this, "acaoConnect");        
        jt.addIcon(IconPackBase64.ATTACH, "Conectar", this, "acaoConnect");        
        jt.addIcon(IconPackBase64.EMAIL, "Conectar", this, "acaoConnect");        
        jt.addIcon(IconPackBase64.BELL, "Conectar", this, "acaoConnect");        
        jt.addIcon(IconPackBase64.BOOK, "Conectar", this, "acaoConnect");        
        jt.addIcon(IconPackBase64.OVERLAYS, "Conectar", this, "acaoConnect");        
        jt.addIcon(IconPackBase64.CANCEL, "Sair do sistema", this, "acaoSair");        
        jt.disableButton(2);
        
        JFrameHelper jh = new JFrameHelper(this);
        jh.setIcon(IconPackBase64.APPLICATION_FORM);
        jh.setMediumSize();
        jh.setTitle(JDFProperties.getInstance().get("sistema.titulo"));
        jh.centerFrame();
    }

    public void acaoSair() {
    	System.exit(0);
    }

    public void acaoAdd() {
    	JOptionPaneHelper.warning("clicou em adicionar");
    }

    public void acaoConnect() {
    	JOptionPaneHelper.warning("clicou em conectar");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tool = new javax.swing.JToolBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tool.setFloatable(false);
        tool.setRollover(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tool, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tool, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesteJToolBar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar tool;
    // End of variables declaration//GEN-END:variables

}
