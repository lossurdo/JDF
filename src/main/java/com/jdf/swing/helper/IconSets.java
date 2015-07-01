package com.jdf.swing.helper;

import javax.swing.ImageIcon;

import com.jdf.swing.iface.IconPackBase64;

/**
 * Interface padr�o para componentes que contenham �cones
 * @author lossurdo
 * @since 16/04/2009
 */
interface IconSets {

	/**
	 * Atribui icone ao objeto 
	 * @param icon Enum contendo a refer�ncia Base64 do icone
	 */
	public abstract void setIcon(IconPackBase64 icon);

	/**
	 * Atribui icone ao objeto 
	 * @param icon Path para o icone
	 */
	public abstract void setIcon(String icon);

	/**
	 * Atribui icone ao objeto 
	 * @param icon Imagem
	 */
	public abstract void setIcon(ImageIcon icon);

}