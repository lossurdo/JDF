package com.jdf.database;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import javax.persistence.Id;

/**
 * Utilitário para lidar com Anotações
 * 
 * @author lossurdo
 * @since 12/03/2009
 */
final class UtilAnnotation {
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static synchronized Object getPropIdContent(Object obj) {
		try {

			Class<?> c = obj.getClass();
			String nomePropId = getPropID(c);
			if (nomePropId == null) {
				throw new RuntimeException(
						"Propriedade com anotação @Id não foi encontrada no entity "
								+ obj.getClass());
			}
			PropertyDescriptor[] pds = null;
			pds = Introspector.getBeanInfo(obj.getClass())
					.getPropertyDescriptors();

			PropertyDescriptor pd = null;
			for (int i = 0; i < pds.length; i++) {
				if (pds[i].getName().equals(nomePropId)
						&& pds[i].getReadMethod() != null) {
					pd = pds[i];
					break;
				}
			}
			if (pd == null || pd.getReadMethod() == null) {
				throw new RuntimeException();
			}
			return pd.getReadMethod().invoke(obj, (Object[]) null);
		} catch (Exception e) {
			throw new RuntimeException(
					"Problema ao obter a propriedade com anotação Id da classe: "
							+ obj.getClass().getName(), e);
		}
	}

	/**
	 * Obtem o propriedade com anotação id da classe, se não encontra procura
	 * recursivamente nas super classes.
	 * 
	 * @param clazz
	 * @return
	 */
	private static synchronized String getPropID(Class<?> clazz) {
		Field[] f;
		f = clazz.getDeclaredFields();
		String nomePropId = null;
		for (int i = 0; i < f.length; i++) {
			if (f[i].getAnnotation(Id.class) != null) {
				nomePropId = f[i].getName();
				break;
			}
		}
		if (nomePropId == null) {
			if (clazz.getSuperclass() != null) {
				return getPropID(clazz.getSuperclass());
			}
		}
		return nomePropId;
	}

	/**
	 * Retorna a anotacao em uma classe. Se não encontrar procura na super
	 * classe. Se não encontrar procura nas interfaces. Tudo de forma recursiva.
	 * 
	 * @param clazz
	 * @param annotation
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static synchronized Object getAnnotation(Class clazz, Class annotation) {
		Object obj = clazz.getAnnotation(annotation);
		if (obj != null) {
			return obj;
		}
		Class superclasse = clazz.getSuperclass();
		if (superclasse != null) {
			obj = getAnnotation(superclasse, annotation);
			if (obj != null) {
				return obj;
			}
		}
		Class interfaces[] = clazz.getInterfaces();
		if (interfaces == null) {
			return null;
		}
		for (int i = 0; i < interfaces.length; i++) {
			obj = getAnnotation(interfaces[i], annotation);
			if (obj != null) {
				return obj;
			}
		}
		return null;
	}

	/**
	 * Retorna a classe com um determinada a anotacao. Se não encontrar procura
	 * na super classe. Se não encontrar procura nas interfaces. Tudo de forma
	 * recursiva.
	 * 
	 * @param clazz
	 * @param annotation
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static synchronized Class getClassWithAnnotation(Class clazz,
			Class annotation) {
		Object obj = clazz.getAnnotation(annotation);
		if (obj != null) {
			return clazz;
		}
		Class superclasse = clazz.getSuperclass();
		if (superclasse != null) {
			obj = getAnnotation(superclasse, annotation);
			if (obj != null) {
				return superclasse;
			}
		}
		Class interfaces[] = clazz.getInterfaces();
		if (interfaces == null) {
			return null;
		}
		for (int i = 0; i < interfaces.length; i++) {
			obj = getAnnotation(interfaces[i], annotation);
			if (obj != null) {
				return interfaces[i];
			}
		}
		return null;
	}

//	/**
//	 * Retorna a anotacao em uma classe. Se não encontrar procura na super
//	 * classe. Se não encontrar procura nas interfaces. Tudo de forma recursiva.
//	 * 
//	 * @param clazz
//	 * @param annotation
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static Object getAnnotation(Class clazz, Class annotation) {
//		Object obj = clazz.getAnnotation(annotation);
//		if (obj != null) {
//			return obj;
//		}
//		Class superclasse = clazz.getSuperclass();
//		if (superclasse != null) {
//			obj = getAnnotation(superclasse, annotation);
//			if (obj != null) {
//				return obj;
//			}
//		}
//		Class interfaces[] = clazz.getInterfaces();
//		if (interfaces == null) {
//			return null;
//		}
//		for (int i = 0; i < interfaces.length; i++) {
//			obj = getAnnotation(interfaces[i], annotation);
//			if (obj != null) {
//				return obj;
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * Retorna a classe com um determinada a anotacao. Se não encontrar procura
//	 * na super classe. Se não encontrar procura nas interfaces. Tudo de forma
//	 * recursiva.
//	 * 
//	 * @param clazz
//	 * @param annotation
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static Class getClassWithAnnotation(Class clazz, Class annotation) {
//		Object obj = clazz.getAnnotation(annotation);
//		if (obj != null) {
//			return clazz;
//		}
//		Class superclasse = clazz.getSuperclass();
//		if (superclasse != null) {
//			obj = getAnnotation(superclasse, annotation);
//			if (obj != null) {
//				return superclasse;
//			}
//		}
//		Class interfaces[] = clazz.getInterfaces();
//		if (interfaces == null) {
//			return null;
//		}
//		for (int i = 0; i < interfaces.length; i++) {
//			obj = getAnnotation(interfaces[i], annotation);
//			if (obj != null) {
//				return interfaces[i];
//			}
//		}
//		return null;
//	}
}
