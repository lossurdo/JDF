package com.jdf.swing.helper;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSlider;

import com.jdf.util.Caracteres;

/**
 * Janela para escolha de uma hora
 * @author lossurdo
 * @since 19/04/2009
 */
class TimeChooser extends JDialog {

	private static final long serialVersionUID = 1L;
	private Date date;

	/**
	 * Construtor
	 * @param frame
	 */
	public TimeChooser(JFrame frame) {
        super(frame, true);
        setTitle("Selecione a hora");
        initComponents();

        configSlider(sliderHora);
        sliderHora.setMajorTickSpacing(6);
        configSlider(sliderMinuto);
        sliderMinuto.setMajorTickSpacing(10);
        
        setLocationRelativeTo(null);
    }

	/**
	 * Abre seletor de horário
	 * @param date Hora inicial
	 * @return Hora escolhida
	 */
	public Date select(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		sliderHora.setValue(cal.get(Calendar.HOUR_OF_DAY));
		sliderMinuto.setValue(cal.get(Calendar.MINUTE));
		atualizaHora();
		setVisible(true);
		return this.date;
	}
	
	/**
	 * Configurações básicas do componente de slider
	 * @param s
	 */
	private void configSlider(JSlider s) {
		s.setPaintLabels(true);
        s.setPaintTicks(true);
        s.setPaintTrack(true);
        s.setMinorTickSpacing(1);
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        sliderHora = new javax.swing.JSlider();
        sliderMinuto = new javax.swing.JSlider();
        btnSeleciona = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        sliderHora.setMaximum(23);
        sliderHora.setOrientation(javax.swing.JSlider.VERTICAL);
        sliderHora.setPaintTicks(true);
        sliderHora.setValue(12);
        sliderHora.setFocusable(false);
        sliderHora.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderHoraStateChanged(evt);
            }
        });

        sliderMinuto.setMaximum(59);
        sliderMinuto.setOrientation(javax.swing.JSlider.VERTICAL);
        sliderMinuto.setPaintLabels(true);
        sliderMinuto.setPaintTicks(true);
        sliderMinuto.setValue(31);
        sliderMinuto.setFocusable(false);
        sliderMinuto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderMinutoStateChanged(evt);
            }
        });

        btnSeleciona.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSeleciona.setText("00:00");
        btnSeleciona.setToolTipText("Clique para selecionar");
        btnSeleciona.setFocusable(false);
        btnSeleciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sliderHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sliderMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sliderMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderHoraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderHoraStateChanged
        atualizaHora();
    }//GEN-LAST:event_sliderHoraStateChanged

    private void sliderMinutoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderMinutoStateChanged
        atualizaHora();
    }//GEN-LAST:event_sliderMinutoStateChanged

    private void btnSelecionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionaActionPerformed
        setVisible(false);        
        
    }//GEN-LAST:event_btnSelecionaActionPerformed

	/**
	 * Atualiza a hora no botão e no atributo a ser devolvido
	 */
    private void atualizaHora() {
        String h = Caracteres.strzero(sliderHora.getValue());
        String m = Caracteres.strzero(sliderMinuto.getValue());
        btnSeleciona.setText(h+":"+m);
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, sliderHora.getValue());
        cal.set(Calendar.MINUTE, sliderMinuto.getValue());
        cal.set(Calendar.SECOND, 0);
        this.date = cal.getTime(); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleciona;
    private javax.swing.JSlider sliderHora;
    private javax.swing.JSlider sliderMinuto;
    // End of variables declaration//GEN-END:variables

}
