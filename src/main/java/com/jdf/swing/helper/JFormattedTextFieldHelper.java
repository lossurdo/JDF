package com.jdf.swing.helper;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 * Classe utilit�ria para formata��o do componente JFormattedTextField
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
	 * Aplica formata��o de data
	 */
	public void applyDateFormat() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("##/##/####")).getFormatterFactory());
	}

	/**
	 * Aplica formata��o de telefone
	 */
	public void applyPhoneFormat() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("####.####")).getFormatterFactory());
	}

	/**
	 * Aplica formata��o de telefone - 10 posi��es
	 */
	public void applyPhoneFormat10() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("#####.#####")).getFormatterFactory());
	}

	/**
	 * Aplica formata��o de DDD
	 */
	public void applyDDDFormat() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("(##)")).getFormatterFactory());
	}

	/**
	 * Aplica formata��o de hora
	 */
	public void applyHourFormat() {
		formatted.setFormatterFactory(new JFormattedTextField(getMask("##:##")).getFormatterFactory());
	}

	/**
	 * Aplica formata��o de hora/segundo
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
