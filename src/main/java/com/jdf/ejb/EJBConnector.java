package com.jdf.ejb;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Classe genérica para conexão com EJB's
 * <pre>
 * Exemplos de conexão:
 * 
 * SERVIDOR OPENEJB:
 * EJBConnectionProperties p = new EJBConnectionProperties(
 * 		"ejbd://127.0.0.1:4201",
 * 		EJBConnectionProperties.OPENEJB_INITIAL_CTX_FAC);
 * 
 * SERVIDOR OPENEJB/TOMCAT:
 * EJBConnectionProperties p = new EJBConnectionProperties(
 * 		"PENDENTE",
 * 		EJBConnectionProperties.OPENEJB_INITIAL_CTX_FAC);
 * 
 * SERVIDOR WEBLOGIC:
 * EJBConnectionProperties p = new EJBConnectionProperties(
 * 		"PENDENTE",
 * 		EJBConnectionProperties.WEBLOGIC_INITIAL_CTX_FAC);
 * 
 * SERVIDOR JBOSS:
 * EJBConnectionProperties p = new EJBConnectionProperties(
 * 		"PENDENTE",
 * 		EJBConnectionProperties.JBOSS_INITIAL_CTX_FAC);
 * 
 * </pre>
 * @author lossurdo
 * @since 21/04/2009
 */
public final class EJBConnector<T> {

	private Hashtable<String, String> prop;
	
	/**
	 * Construtor
	 */
	public EJBConnector() {
		prop = new Hashtable<String, String>();
	}
	
	/**
	 * Construtor
	 * @param properties Propriedades para conexão com EJB
	 */
	public EJBConnector(EJBConnectionProperties properties) {
		this();
		prop.put(Context.PROVIDER_URL, properties.getProviderURL());
		prop.put(Context.INITIAL_CONTEXT_FACTORY, properties.getInitialContextFactory());
		prop.put(Context.SECURITY_CREDENTIALS, properties.getSecurityCredentials());
		prop.put(Context.SECURITY_AUTHENTICATION, properties.getSecurityAuthentication());		
	}

	/**
	 * Conecta ao JNDI
	 * @param JNDIname Nome do JNDI
	 * @return Objeto de conexão
	 */
	@SuppressWarnings("unchecked")
	public T connect(String JNDIname) {
		try {
			Context ctx = new InitialContext(prop);
			T obj = (T) ctx.lookup(JNDIname);
			return obj;
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
