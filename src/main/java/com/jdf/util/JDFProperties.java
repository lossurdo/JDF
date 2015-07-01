package com.jdf.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Classe responsável pela leitura do arquivo de properties
 * @author lossurdo
 * @since 02/03/2009
 */
public final class JDFProperties {
	private static final JDFProperties instance = new JDFProperties();
	private static String ARQUIVO_CONFIGURACAO = "/META-INF/config.properties";
	private static Properties prop;
	
	/**
	 * Instância singleton
	 * @return
	 */
	public static JDFProperties getInstance() {		
		File p = new File(ARQUIVO_CONFIGURACAO);
		if(!p.canRead()) {
			ARQUIVO_CONFIGURACAO = "src/META-INF/config.properties"; 
		}
		
		prop = new Properties();
		try {
			prop.load(new FileInputStream(ARQUIVO_CONFIGURACAO));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return instance;
	}
	
	/**
	 * Lê o valor de uma chave
	 * @param chave Chave
	 * @return Valor
	 */
	public String get(String chave) {
		if(chave==null)
			throw new IllegalArgumentException("Chave não pode ser nula");		
		return prop.getProperty(chave);
	}
}
