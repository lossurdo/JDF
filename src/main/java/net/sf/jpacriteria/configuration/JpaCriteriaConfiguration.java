package net.sf.jpacriteria.configuration;

/**
 * @author Maxim Butov
 * @version $Id: JpaCriteriaConfiguration.java,v 1.1 2007/03/30 22:36:26 maxim_butov Exp $
 */
public class JpaCriteriaConfiguration implements Configuration {

    public boolean useAsInFrom() {
        return false;
    }

    public boolean useAsInEarlierJoin() {
        return false;
    }

    public boolean useAsInLateJoin() {
        return false;
    }

    public boolean useInnerWithJoin() {
        return false;
    }

    public boolean useOuterWithLeftJoin() {
        return false;
    }
}
