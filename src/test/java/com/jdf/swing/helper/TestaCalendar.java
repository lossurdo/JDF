package com.jdf.swing.helper;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jdf.swing.helper.JButtonHelper;
import com.jdf.swing.helper.JFrameHelper;
import com.jdf.swing.iface.IconPackBase64;

public class TestaCalendar extends JFrame {

	public TestaCalendar() {
		super();
		
		JFrameHelper jfh = new JFrameHelper(this);
		jfh.setIcon(IconPackBase64.APPLICATION);
		jfh.setMediumSize();
		jfh.setExitOnClose();
		jfh.setTitle("JDF - Java Desktop Framework");
		jfh.centerFrame();
		
		setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("Data de nascimento:");
		JButton bt1 = new JButton();
		JLabel l2 = new JLabel("Hora de nascimento:");
		JButton bt2 = new JButton();
		
		final JButtonHelper bh1 = new JButtonHelper(bt1);
		bh1.transformToDateButton();
		final JButtonHelper bh2 = new JButtonHelper(bt2);
		bh2.transformToTimeButton();

		JButton verifData = new JButton("Verificar Data");
		verifData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(bh1.getDate());
			}
		});		
		
		JButton verifHora = new JButton("Verificar Hora");
		verifHora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(bh2.getDate());
			}
		});		
		
		add(l1);
		add(bt1);
		add(verifData);

		add(l2);
		add(bt2);
		add(verifHora);
}

	public static void main(String[] args) {
		new TestaCalendar().setVisible(true);
	}

}
