package com.jdf.security;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Sessão de singleton para usuário logado na ferramenta
 * @author rafael-lossurdo
 * @since 22/04/2009
 */
public final class JDFUserSession {
	private static final JDFUserSession instance = new JDFUserSession();
	private static String ARQUIVO_CONFIGURACAO = "/META-INF/config.properties";
	private static Properties prop;

	/**
	 * Instância singleton
	 * @return
	 */
	public static JDFUserSession getInstance() {
		File p = new File(ARQUIVO_CONFIGURACAO);
		if (!p.canRead()) {
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

	private String getUserLevel() {
		String userLevel = System.getProperty("user-level");
		return null;
	}
	
	public boolean verifyPermission(String object, String action) {
		if (object == null || action == null || object.equals("")
				|| action.equals("")) {
			throw new RuntimeException("Objeto/Ação nulo ou vazio");
		}

		String pesq = object + "-" + action;
		String permissoes = prop.getProperty(pesq);
		if (permissoes == null || permissoes.equals("")) {
			return false;
		} else {
//			if()
		}
		return false;
	}

}
