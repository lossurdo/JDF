package com.jdf.ejb;

/**
 * Classe utilizada para passagem dos parâmetros de conexão com o EJB
 * @author lossurdo
 * @since 21/04/2009
 */
public final class EJBConnectionProperties {

	private String providerURL;
	private String initialContextFactory;
	private String securityCredentials;
	private String securityAuthentication;

	/**
	 * 
	 */
	public static final String WEBLOGIC_INITIAL_CTX_FAC = "";
	
	/**
	 * org.jnp.interfaces.NamingContextFactory
	 */
	public static final String JBOSS_INITIAL_CTX_FAC = "org.jnp.interfaces.NamingContextFactory";
	
	/**
	 * org.apache.openejb.client.RemoteInitialContextFactory
	 */
	public static final String OPENEJB_INITIAL_CTX_FAC = "org.apache.openejb.client.RemoteInitialContextFactory";

	/**
	 * Construtor
	 * @param providerURL
	 * @param initialContextFactory
	 */
	public EJBConnectionProperties(String providerURL,
			String initialContextFactory) {
		this(providerURL, initialContextFactory, null, null);
	}

	/**
	 * Construtor
	 * @param providerURL
	 * @param initialContextFactory
	 * @param securityCredentials
	 * @param securityAuthentication
	 */
	public EJBConnectionProperties(String providerURL,
			String initialContextFactory, String securityCredentials,
			String securityAuthentication) {
		this.providerURL = providerURL;
		this.initialContextFactory = initialContextFactory;
		this.securityCredentials = securityCredentials==null?"":securityCredentials;
		this.securityAuthentication = securityAuthentication==null?"":securityCredentials;
	}

	protected String getProviderURL() {
		return providerURL;
	}

	protected void setProviderURL(String providerURL) {
		this.providerURL = providerURL;
	}

	protected String getInitialContextFactory() {
		return initialContextFactory;
	}

	protected void setInitialContextFactory(String initialContextFactory) {
		this.initialContextFactory = initialContextFactory;
	}

	protected String getSecurityCredentials() {
		return securityCredentials;
	}

	protected void setSecurityCredentials(String securityCredentials) {
		this.securityCredentials = securityCredentials;
	}

	protected String getSecurityAuthentication() {
		return securityAuthentication;
	}

	protected void setSecurityAuthentication(String securityAuthentication) {
		this.securityAuthentication = securityAuthentication;
	}
}
