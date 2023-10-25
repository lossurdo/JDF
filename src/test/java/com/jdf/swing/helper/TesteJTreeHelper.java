package com.jdf.swing.helper;

import com.jdf.database.bean.Aluno;
import com.jdf.swing.iface.IconPackBase64;


/**
 *
 * @author lossurdo
 */
public class TesteJTreeHelper extends javax.swing.JFrame {

    public TesteJTreeHelper() {
        initComponents();
        
        JFrameHelper jfh = new JFrameHelper(this);
		jfh.setIcon(IconPackBase64.APPLICATION_SIDE_TREE);
		jfh.setExitOnClose();
		jfh.setTitle("JDF - Java Desktop Framework");
		jfh.centerFrame();
        
        tree = new JTreeHelper<Aluno>(arvore, "Cliente");
        tree.addNode(new Aluno(1,"Classe A")).addSubnode(new Aluno(2,"Rafael")).addSubnode(new Aluno(1,"Pedro"));
        tree.addNode(new Aluno(1,"Classe B")).addSubnode(new Aluno(2,"Ana")).addSubnode(new Aluno(1,"Maria"));
        tree.addNode(new Aluno(1,"Classe C")).addSubnode(new Aluno(2,"Gabriela")).addNode(new Aluno(1,"João"), true).addSubnode(new Aluno(1,"José"));
        tree.setAllOpened();
        tree.setDoubleClickAction(this, "imprimeClicado");
    }

    private void imprimeClicado() {
    	JOptionPaneHelper.simpleMessage(tree.getSelected().toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        arvore = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arvore.setAutoscrolls(true);
        jScrollPane1.setViewportView(arvore);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesteJTreeHelper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arvore;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
	private JTreeHelper<Aluno> tree;

}
