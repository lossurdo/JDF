package net.sf.jpacriteria;

import javax.persistence.*;

/**
 * @author Maxim Butov
 * @version $Id: Criterion.java,v 1.11 2007/09/13 14:44:12 maxim_butov Exp $
 */
public class Criterion {

    public static Criteria from(Class entityClass) {
        return from(entityName(entityClass));
    }

    public static Criteria from(Class entityClass, String alias) {
        return from(entityName(entityClass), alias);
    }

    public static Criteria from(String entity) {
        return new CriteriaImpl(entity);
    }

    public static Criteria from(String entity, String alias) {
        return new CriteriaImpl(entity, alias);
    }

    private static String entityName(Class<?> aClass) {
        Entity entity = aClass.getAnnotation(Entity.class);
        if (entity != null) {
            String name = entity.name();
            return name != null && name.length() > 0 ? name : aClass.getSimpleName();
        } else {
            throw new IllegalArgumentException("Class " + aClass.getName() +
                    " must be annotated with @" + Entity.class.getName());
        }
    }

    private Criterion() {
    }
}
