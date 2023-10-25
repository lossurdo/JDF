package com.jdf.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Utilitário para tratar de reflexão em classes
 *
 * @author lossurdo
 * @since 15/03/2009
 */
public final class UtilMethod {

    /**
     * Executa a ação sem passagem de parâmetros
     *
     * @param object instância do objeto que contém o método a ser executado
     * @param method método a ser executado
     * @return
     */
    public static synchronized Object executeMethod(Object object, String method) {
        try {
            Class<?> clazz = object.getClass();
            Method m = clazz.getDeclaredMethod(method, (Class<?>) null);
            m.setAccessible(true);
            return m.invoke(object, (Object) null);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
