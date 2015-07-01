package net.sf.jpacriteria.argument;

/**
 * @author Maxim Butov
 * @version $Id: Arguments.java,v 1.5 2007/08/02 14:16:02 maxim_butov Exp $
 */
public class Arguments {

    public static final Argument EMPTY = new UnmodifiableArgument(new ArgumentImpl());

    public static Argument add(String name, Object value) {
        return new ArgumentImpl().add(name, value);
    }

    public static Argument union(Argument... args) {
        switch (args.length) {
            case 0:
                return EMPTY;
            case 1:
                return args[0];
            default:
                Argument argument = new ArgumentImpl();
                for (Argument arg : args) {
                    argument = argument.add(arg);
                }
                return argument;
        }
    }

    private Arguments() {
    }
}
