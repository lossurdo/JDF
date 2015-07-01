package com.jdf.swing.lixo;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Classe utilizada para leitura de imagens a partir de um
 * arquivo compactado associado ao classpath
 * @author lossurdo
 * @since 15/03/2009
 */
@Deprecated
final class ImageReader {

	private String image;

	/**
	 * Construtor
	 * @param image
	 */
	public ImageReader(String image) {
		this.image = image;
	}

	/**
	 * Retorna magem
	 * @return
	 */
	public Image getImage() {
		return getImageIcon().getImage();
	}
	
	/**
	 * Retorna imagem
	 * @return
	 */
	public ImageIcon getImageIcon() {
		return new ImageIcon(getClass().getResource(image));
	}
}
