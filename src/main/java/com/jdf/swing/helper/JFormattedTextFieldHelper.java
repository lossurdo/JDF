package com.jdf.swing.helper;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 * Classe utilitária para formatação do componente JFormattedTextField
 * @author rafael-lossurdo
 * @since 03/03/2009
 */
public class JFormattedTextFieldHelper {

	private JFormattedTextField formatted;

	/**
	 * Construtor
	 * @param formatted
	 */
	public JFormattedTextFieldHelper(JFormattedTextField formatted) {
		this.formatted = formatted;
	}

	/**
	 * Aplica formatação de data
	 */
	public void applyDateFormat() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("##/##/####")).getFormatterFactory());
	}

	/**
	 * Aplica formatação de telefone
	 */
	public void applyPhoneFormat() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("####.####")).getFormatterFactory());
	}

	/**
	 * Aplica formatação de telefone - 10 posições
	 */
	public void applyPhoneFormat10() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("#####.#####")).getFormatterFactory());
	}

	/**
	 * Aplica formatação de DDD
	 */
	public void applyDDDFormat() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("(##)")).getFormatterFactory());
	}

	/**
	 * Aplica formatação de hora
	 */
	public void applyHourFormat() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("##:##")).getFormatterFactory());
	}

	/**
	 * Aplica formatação de hora/segundo
	 */
	public void applyHourSecondFormat() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("##:##:##")).getFormatterFactory());
	}

	private MaskFormatter getMask(String mask) {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter(mask);
			mascara.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
		}
		return mascara;
	}
}
