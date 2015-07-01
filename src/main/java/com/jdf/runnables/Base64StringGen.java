package com.jdf.runnables;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;

import javax.swing.JFileChooser;

import com.jdf.swing.helper.JFileChooserHelper;
import com.jdf.swing.helper.JFrameHelper;
import com.jdf.swing.helper.JOptionPaneHelper;
import com.jdf.swing.iface.IconPackBase64;
import com.jdf.util.Image2Base64;

/**
 * Programa gerador de String Base64
 * @author lossurdo
 * @since 20/04/2009
 */
final class Base64StringGen extends javax.swing.JFrame implements ClipboardOwner {

	private static final long serialVersionUID = 1L;

	public Base64StringGen() {
		initComponents();

		JFrameHelper jfh = new JFrameHelper(this);
		jfh.setIcon(IconPackBase64.APPLICATION);
		jfh.setBigSize();
		jfh.setExitOnClose();
		jfh.setTitle("JDF - Gerador de String Base64");
		jfh.centerFrame();
	}

	protected void openDialog() {
		JFileChooserHelper fch = new JFileChooserHelper();		
		fch.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fch.setApproveButtonText("Converter");
		fch.setDialogTitle("Selecione o arquivo a converter");
		int v = fch.showOpenDialog(this);
		if (v != 0) {
			System.exit(0);
		}
		file = fch.getSelectedFile();
		gerar(file);
	}

	private void gerar(final File file) {
		new Thread() {
			@Override
			public void run() {
				String txt;
				try {
					txt = Image2Base64.toString(file);
				} catch (Exception e) {
					JOptionPaneHelper.error(e);
					throw new RuntimeException(e);
				}
				
				String novoTxt = txt;			
				if(sbCheckbox.isSelected()) {
					novoTxt = novoTxt.replaceAll("\r\n", "\");\r\narquivoBase64.append(\"");
					novoTxt = "arquivoBase64.append(\"" + novoTxt.substring(0, novoTxt.length()-25);
					novoTxt += ";";
					novoTxt = "StringBuilder arquivoBase64 = new StringBuilder();\r\n" + novoTxt; 
					txtCode.setText(novoTxt);
				} else {
					txtCode.setText(txt);
				}		
				
				setClipboardContents(txtCode.getText());
				JOptionPaneHelper.simpleMessage("Texto colocado na área de transferência");
			}
		}.start();
	}

    private void setClipboardContents(String txt) {
		StringSelection stringSelection = new StringSelection(txt);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, this);
	}
    
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtCode = new javax.swing.JTextArea();
        sbCheckbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JDF - Gerador de String Base64");
        setResizable(false);

        txtCode.setColumns(20);
        txtCode.setEditable(false);
        txtCode.setLineWrap(true);
        txtCode.setRows(5);
        jScrollPane1.setViewportView(txtCode);

        sbCheckbox.setSelected(true);
        sbCheckbox.setText("Gerar StringBuilder?");
        sbCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addComponent(sbCheckbox)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sbCheckbox)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sbCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbCheckboxActionPerformed
		gerar(file);
    }//GEN-LAST:event_sbCheckboxActionPerformed

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Base64StringGen x = new Base64StringGen();
				x.setVisible(true); 
				x.openDialog();
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox sbCheckbox;
    private javax.swing.JTextArea txtCode;
    // End of variables declaration//GEN-END:variables
	private File file;

	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
	}

}
