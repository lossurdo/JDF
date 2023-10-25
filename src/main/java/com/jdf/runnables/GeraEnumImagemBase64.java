package com.jdf.runnables;

import java.io.File;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

import com.jdf.util.Image2Base64;

/**
 * Classe geradora de enum para imagens base 64
 *
 * @author lossurdo
 * @since 14/04/2009
 */
final class GeraEnumImagemBase64 {

    private static StringBuffer sb = new StringBuffer();

    private static final String PATH_DIR_IMAGENS = "/diretorio/exemplo/imagens/";
    private static final String PATH_CLASSE_SAIDA = "/diretorio/exemplo/java/IconPackBase64.java";
    
    public static void main(String[] args) throws Exception {
        File f = new File(PATH_DIR_IMAGENS);
        File[] arqs = f.listFiles();
        for (File file : arqs) {
            sb.append(stripName(file.getName())).append("(\"");
            sb.append(Image2Base64.toString(new File(PATH_DIR_IMAGENS + file.getName())));
        }

        String novaString = null;
        novaString = "public enum IconPackBase64 {\r\n";
        novaString += sb.toString().replaceAll("\r\n", "\"+\r\n\"");
        novaString += "	private String value;\r\n";
        novaString += "private IconPackBase64(String x) {\r\n";
        novaString += "this.value = x;\r\n";
        novaString += "}\r\n";
        novaString += "@Override\r\n";
        novaString += "public String toString() {\r\n";
        novaString += "return value;\r\n";
        novaString += "}\r\n";
        novaString += "}\r\n";

        for (File file : arqs) {
            novaString = novaString.replaceFirst("\"" + stripName(file.getName()), "@@@" + stripName(file.getName()));
        }

        novaString = novaString.replaceAll("\\+\r\n@@@", "),\r\n");
        novaString = novaString.replaceFirst("\\+\r\n\"	private String value", ");\r\nprivate String value");

        FileOutputStream fos = new FileOutputStream(PATH_CLASSE_SAIDA);
        fos.write(novaString.getBytes());
        fos.close();
    }

    private static String stripName(String f) {
        StringTokenizer st = new StringTokenizer(f, ".");
        return st.nextToken().toUpperCase();
    }

}
