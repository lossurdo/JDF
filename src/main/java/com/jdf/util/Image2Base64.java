package com.jdf.util;

import java.io.File;
import java.nio.ByteBuffer;

import javax.imageio.stream.FileImageInputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Converte imagens para String Base64 e vice-versa
 * <pre>
 * Exemplo de uso:
 * 
 * String s = Image2Base64.toString(new File("img/imagem.png"));
 * new JLabel(new ImageIcon(Image2Base64.toImage(s)));
 * </pre>
 * @author Rafael Lossurdo
 * @since 14/04/2009
 */
public final class Image2Base64 {

	/**
	 * Converte imagem para String Base64
	 * @param file Arquivo imagem a ser convertido
	 * @return String Base64 da conversão
	 * @throws Exception
	 */
	public static String toString(File file) throws Exception {
		BASE64Encoder encoder = new BASE64Encoder();
		FileImageInputStream in = new FileImageInputStream(file);
		int size = (int) in.length();
		byte[] b = new byte[size];
		in.read(b);
		in.close();
		ByteBuffer bb = ByteBuffer.wrap(b);
		return encoder.encodeBuffer(bb);
	}
	
	/**
	 * Converte String Base64 para imagem
	 * @param string String Base64 correspondente a imagem
	 * @return Bytes referentes a imagem
	 * @throws Exception
	 */
	public static byte[] toImage(String string) throws Exception {
		return new BASE64Decoder().decodeBuffer(string);
	}
	
}
