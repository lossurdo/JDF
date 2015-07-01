package com.jdf.swing.helper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.jdf.security.JDFSecurity;
import com.jdf.security.JDFUserSession;
import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.iface.ImageReaderBase64;
import com.jdf.util.Caracteres;
import com.jdf.util.UtilMethod;

/**
 * Classe auxiliar para objetos JButton
 * 
 * @author lossurdo
 * @since 01/03/2009
 */
public class JButtonHelper implements IconSets, JDFSecurity {

	private JButton button;
	private Date date;
	private static final DateChooser dateChooser = new DateChooser((JFrame) null);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"dd/MM/yyyy");
	private static final TimeChooser timeChooser = new TimeChooser(null);

	/**
	 * Construtor
	 * @param btn
	 */
	public JButtonHelper(JButton btn) {
		this.button = btn;
	}

	public void verifyPermission(String object, String action) {
		if(!JDFUserSession.getInstance().verifyPermission(object, action)) {
			this.button.setEnabled(false);
		}
	}
	
	/**
	 * Transforma um bot�o em campo hora utilizando a data atual
	 */
	public void transformToTimeButton() {
		transformToTimeButton(Calendar.getInstance().getTime());
	}
	
	/**
	 * Transforma um bot�o em campo hora
	 * @param time Hora
	 */
	public void transformToTimeButton(Date time) {
		button.setIcon(new ImageReaderBase64(IconPackBase64.TIME).toImage());
		button.setFocusable(false);
		button.setText(extractTimeFromDate(time));
		this.date = time;
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fireTimeChooser(JButtonHelper.this.date);
			}
		});
	}

	/**
	 * Chama o TimeChooser e disponibiliza a hora escolhida
	 * @param date
	 */
	private void fireTimeChooser(Date date) {
		Date newDate = timeChooser.select(date);
		if (newDate == null) {
			return;
		}
		button.setText(extractTimeFromDate(newDate));
		this.date = newDate;
	}

	/**
	 * Transforma um bot�o em campo data (calend�rio) utilizando a data atual
	 */
	public void transformToDateButton() {
		transformToDateButton(Calendar.getInstance().getTime());
	}

	/**
	 * Transforma um bot�o em campo data (calend�rio)
	 * @param date Data inicial do campo
	 */
	public void transformToDateButton(Date date) {
		button.setIcon(new ImageReaderBase64(IconPackBase64.CALENDAR).toImage());
		button.setFocusable(false);
		button.setText(DATE_FORMAT.format(date));
		this.date = date;
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fireDateChooser(JButtonHelper.this.date);
			}
		});
	}

	/**
	 * Chama o DateChooser e disponibiliza a data escolhida
	 * @param date
	 */
	private void fireDateChooser(final Date date) {
		Date newDate = dateChooser.select(date);
		if (newDate == null) {
			return;
		}
		button.setText(DATE_FORMAT.format(newDate));
		this.date = newDate;
	}

	/**
	 * Seta o valor da data
	 * @param date Novo valor da data
	 * @return Antigo valor da data
	 **/
	public void setDate(Date date) {
		this.date = date;
		button.setText(DATE_FORMAT.format(date));
	}

	/**
	 * Retorna o valor da data
	 * @return Data
	 **/
	public Date getDate() {
		return this.date;
	}

	/**
	 * Transforma bot�o em um "chamador" de LOV
	 * @param object Objeto que cont�m a a��o/m�todo a ser executado
	 * @param action A��o a ser executada
	 */
	public void transformToLOV(final Object object, final String action) {
		button.setText("");
		button.setToolTipText("Lista de Valores");
		setIcon(IconPackBase64.APPLICATION_VIEW_LIST);
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UtilMethod.executeMethod(object, action);
			}
		});
	}
	
	/**
	 * Insere um �cone em um bot�o
	 * @param icon Enum com refer�ncia ao �cone
	 */
	public void setIcon(IconPackBase64 icon) {
		button.setIcon(new ImageReaderBase64(icon).toImage());
	}

	/**
	 * Insere um �cone em um bot�o
	 * @param icon Refer�ncia ao arquivo
	 */
	public void setIcon(String icon) {
		button.setIcon(new ImageReaderBase64(icon).toImage());
	}

	/**
	 * Adiciona uma a��o ao evento de clique no bot�o
	 * @param object Objeto que cont�m a a��o a ser executada
	 * @param method M�todo a ser executado
	 */
	public void addAction(final Object object, final String method) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UtilMethod.executeMethod(object, method);
			}
		});
	}

	private String extractTimeFromDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String h = Caracteres.strzero(cal.get(Calendar.HOUR_OF_DAY)); 
		String m = Caracteres.strzero(cal.get(Calendar.MINUTE)); 
		return h+":"+m;
	}

	@Override
	public void setIcon(ImageIcon icon) {
	}

}
