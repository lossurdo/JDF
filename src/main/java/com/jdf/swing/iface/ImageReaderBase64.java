package com.jdf.swing.iface;

import javax.swing.ImageIcon;

import com.jdf.util.Image2Base64;

/**
 * Classe responsável pela leitura de imagens em Base64 e
 * arquivos ZIP no classpath da aplicação
 * @author lossurdo
 * @since 16/04/2009
 */
public final class ImageReaderBase64 {

	private String image;
	private IconPackBase64 imageBase64;

	/**
	 * Construtor
	 * @param image Referência ao arquivo de imagem (ex. /icons/print.gif). Estes
	 * arquivos devem estar zipados e associados ao classpath da aplicação.
	 */
	public ImageReaderBase64(String image) {
		this.image = image;
	}

	/**
	 * Construtor
	 * @param image Referência a imagem
	 */
	public ImageReaderBase64(IconPackBase64 image) {
		this.imageBase64 = image;
	}

	/**
	 * Retorna a imagem em si
	 * @return Imagem
	 */
	public ImageIcon toImage() {
		if (image != null) {
			return new ImageIcon(getClass().getResource(image));
		} else {
			try {
				byte[] img = Image2Base64.toImage(imageBase64.toString());
				return new ImageIcon(img);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}
