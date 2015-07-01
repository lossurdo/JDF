package net.sf.jpacriteria.configuration;

/**
 * @author Maxim Butov
 * @version $Id: Configuration.java,v 1.2 2007/03/30 22:36:26 maxim_butov Exp $
 */
public interface Configuration {

    String CONFIGURATION_KEY = "net.sf.jpacriteria.configuration";

    boolean useAsInFrom();

    boolean useAsInEarlierJoin();

    boolean useAsInLateJoin();

    boolean useInnerWithJoin();

    boolean useOuterWithLeftJoin();
}
