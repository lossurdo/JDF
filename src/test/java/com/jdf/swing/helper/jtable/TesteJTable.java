/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TesteJTable.java
 *
 * Created on Mar 22, 2009, 11:28:42 AM
 */

package com.jdf.swing.helper.jtable;

import com.jdf.database.bean.Aluno;
import com.jdf.swing.helper.JOptionPaneHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class TesteJTable extends javax.swing.JFrame {

    private JTableHelper<Aluno> th;

    public TesteJTable() {
        initComponents();


        List<Aluno> lista = new ArrayList<Aluno>();
        lista.add(new Aluno(1, "Rafael", 5000.00, Calendar.getInstance().getTime()));
        lista.add(new Aluno(2, "José", 6000.00, Calendar.getInstance().getTime()));
        lista.add(new Aluno(3, "Maria", 3000.00, Calendar.getInstance().getTime()));
        lista.add(new Aluno(4, "Ana Cláudia", 1245.67, Calendar.getInstance().getTime()));
        lista.add(new Aluno(5, "João da Silva", 490.12, Calendar.getInstance().getTime()));

        th = new JTableHelper<Aluno>(tabela);
        th.setModel(lista);
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnSel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(8);

        btnSel.setText("Mostrar Selecionado");
        btnSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(btnSel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSel)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelActionPerformed
        try {
			JOptionPaneHelper.warning(th.getSelectedObject().toString());
		} catch (Exception e) {
			JOptionPaneHelper.error(e);
		}
    }//GEN-LAST:event_btnSelActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesteJTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
