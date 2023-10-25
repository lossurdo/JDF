package com.jdf.swing.helper;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.JLabel;

import com.jdf.swing.iface.JDFColor;

/**
 * Classe auxiliar para objetos JLabel
 *
 * @author lossurdo
 * @since 20/04/2009
 */
public final class JLabelHelper {

    private JLabel label;
    private URI uri;
    private String tooltip;

    /**
     * Texto: Cique para acessar
     */
    public static final String DEFAULT_TOOLTIP = "Cique para acessar";

    /**
     * Construtor
     *
     * @param label
     */
    public JLabelHelper(JLabel label) {
        this.label = label;
    }

    /**
     * Transforma objeto JLabel em um link para o browser/navegador
     *
     * @param uri Endereço para acesso no momento do clique (ex.
     * http://lossurdojava.blogspot.com)
     * @param tooltip Texto mostrado quando o mouse estiver em cima do link
     */
    public void transformToURLLink(URI uri, String tooltip) {
        this.uri = uri;
        this.tooltip = tooltip;

        format();
        addListeners();
    }

    /**
     * Transforma objeto JLabel em um link para o browser/navegador
     *
     * @param uri Endereço para acesso no momento do clique (ex.
     * http://lossurdojava.blogspot.com)
     */
    public void transformToURLLink(URI uri) {
        transformToURLLink(uri, null);
    }

    protected JLabel getLabel() {
        return this.label;
    }

    private void format() {
        this.label.setForeground(JDFColor.LABEL_LINK);
        this.label.setText("<html><u>" + this.label.getText() + "</u></html>");
        if (tooltip != null) {
            this.label.setToolTipText(tooltip);
        }
    }

    private void addListeners() {
        this.label.addMouseListener(new URLLabelMouseListener(this, uri));
    }
}

/**
 * Controle de movimento do mouse
 *
 * @author lossurdo
 * @since 20/04/2009
 */
class URLLabelMouseListener implements MouseListener {

    private URI uri;
    private JLabelHelper link;

    public URLLabelMouseListener(JLabelHelper link, URI uri) {
        this.uri = uri;
        this.link = link;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Desktop.getDesktop().browse(uri);
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.link.getLabel().setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.link.getLabel().setCursor(
                Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
