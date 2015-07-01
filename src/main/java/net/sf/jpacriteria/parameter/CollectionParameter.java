package net.sf.jpacriteria.parameter;

import net.sf.jpacriteria.builder.CriteriaBuffer;
import net.sf.jpacriteria.builder.UniqueIdentifiers;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Maxim Butov
 * @version $Id: CollectionParameter.java,v 1.4 2007/09/21 08:26:17 maxim_butov Exp $
 */
public class CollectionParameter extends ParameterImpl<Collection> {

    private static final long serialVersionUID = -7898325771491498329L;

    public CollectionParameter(Collection value) {
        super(value);
    }

    public CollectionParameter(Object... values) {
        super(Arrays.asList(values));
    }

    public boolean isEmpty() {
        return getValue().isEmpty();
    }

    public void build(CriteriaBuffer buffer) {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        CriteriaBuffer b = buffer.newBuffer();
        int k = 0;
        for (Object value : getValue()) {
            if (!b.isEmpty()) {
                b.appendComma();
            }
            String param = UniqueIdentifiers.generate("p", this, ++k);
            b.append(':' + param);
            b.getArgument().add(param, value);
        }
        buffer.append(b.enclose());
    }
}
