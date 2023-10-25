package com.jdf.swing.helper;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JSeparator;

/**
 * Classe abstrata auxiliar aos objetos JMenuBar ou JPopupMenu
 *
 * @author lossurdo
 * @since 20/04/2009
 */
abstract class MenuAbstract {

    private JComponent component;

    /**
     * Construror
     *
     * @param component Componente do tipo JMenuBar ou JPopupMenu
     */
    public MenuAbstract(JComponent component) {
        this.component = component;
        if (component != null) {
            this.component.removeAll();
        }
    }

    /**
     * Adiciona um separador à barra de menus
     */
    public void addSeparator() {
        component.add(new JSeparator());
    }

    /**
     * Adiciona um menu à barra de menus
     *
     * @param text Texto a ser mostrado no menu
     * @return Objeto que permitirá adicionar itens a este menu
     */
    public JMenuHelper addMenu(String text) {
        return addMenu(text, ' ');
    }

    /**
     * Adiciona um menu à barra de menus
     *
     * @param text Texto a ser mostrado no menu
     * @param mneumonic Tecla de atalho para acesso ao menu
     * @return Objeto que permitirá adicionar itens a este menu
     */
    public JMenuHelper addMenu(String text, Character mneumonic) {
        JMenu m = new JMenu(text);
        m.setMnemonic(mneumonic);
        component.add(m);
        return new JMenuHelper(m);
    }
}
