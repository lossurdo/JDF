package net.sf.jpacriteria.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Maxim Butov
 * @version $Id: Configurations.java,v 1.4 2007/08/02 14:16:02 maxim_butov Exp $
 */
public class Configurations {

    private static Configuration configuration;

    public static Configuration getConfiguration() {
        if (configuration == null) {
            Properties properties = new Properties(System.getProperties());
            if (properties.getProperty(Configuration.CONFIGURATION_KEY) == null) {
                InputStream inputStream =
                        Thread.currentThread().getContextClassLoader().getResourceAsStream("jpacriteria.properties");
                if (inputStream != null) {
                    try {
                        properties.load(inputStream);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } finally {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            // nothing, close silently
                        }
                    }
                }
            }
            String className =
                    properties.getProperty(Configuration.CONFIGURATION_KEY, JpaCriteriaConfiguration.class.getName());
            try {
                configuration = (Configuration) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        Configurations.configuration = configuration;
    }

    private Configurations() {
    }
}
