package com.jdf.swing.helper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.iface.ImageReaderBase64;
import com.jdf.swing.iface.Shortcut;
import com.jdf.util.UtilMethod;

/**
 * Classe auxiliar para criação do objeto JMenu
 *
 * @author lossurdo
 * @since 24/03/2009
 */
public class JMenuHelper {

    private JMenu menu;

    /**
     * Construtor
     *
     * @param m
     */
    public JMenuHelper(JMenu m) {
        this.menu = m;
    }

    /**
     *
     * @param actionObject
     * @param action
     * @param item
     * @return
     */
    public JMenuHelper addCheckbox(final Object actionObject, final String action, String item) {
        return addCheckbox(actionObject, action, item, null);
    }

    /**
     *
     * @param actionObject
     * @param action
     * @param item
     * @param icon
     * @return
     */
    public JMenuHelper addCheckbox(final Object actionObject, final String action, String item, IconPackBase64 icon) {
        JCheckBoxMenuItem i = new JCheckBoxMenuItem(item);

        if (icon != null) {
            i.setIcon(new ImageReaderBase64(icon).toImage());
        }

        if (actionObject != null && action != null) {
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UtilMethod.executeMethod(actionObject, action);
                }
            });
        }

        menu.add(i);
        return this;
    }

    /**
     * Adiciona um item ao menu
     *
     * @param actionObject Objeto que contém a ação a ser executada no momento
     * do clique
     * @param action Ação a ser executada no momento do clique
     * @param item Texto a ser apresentado na tela
     * @param icon Ícone
     * @param shortcut Atalho ao item
     * @return Este objeto que permitirá adicionar mais itens
     */
    public JMenuHelper addItem(Object actionObject, String action, String item,
            IconPackBase64 icon, Shortcut shortcut) {
        return addItem(actionObject, action, item, icon, shortcut, null);
    }

    /**
     * Adiciona um item ao menu
     *
     * @param actionObject Objeto que contém a ação a ser executada no momento
     * do clique
     * @param action Ação a ser executada no momento do clique
     * @param item Texto a ser apresentado na tela
     * @param icon Ícone
     * @return Este objeto que permitirá adicionar mais itens
     */
    public JMenuHelper addItem(Object actionObject, String action, String item,
            IconPackBase64 icon) {
        return addItem(actionObject, action, item, icon, Shortcut.DEFAULT,
                null);
    }

    /**
     * Adiciona um item ao menu
     *
     * @param actionObject Objeto que contém a ação a ser executada no momento
     * do clique
     * @param action Ação a ser executada no momento do clique
     * @param item Texto a ser apresentado na tela
     * @return Este objeto que permitirá adicionar mais itens
     */
    public JMenuHelper addItem(Object actionObject, String action, String item) {
        return addItem(actionObject, action, item, null, Shortcut.DEFAULT,
                null);
    }

    /**
     * Adiciona um item ao menu
     *
     * @param actionObject Objeto que contém a ação a ser executada no momento
     * do clique
     * @param action Ação a ser executada no momento do clique
     * @param item Texto a ser apresentado na tela
     * @param icon Ícone
     * @param shortcut Atalho ao item
     * @param mneumonic Tecla de atalho ao item
     * @return Este objeto que permitirá adicionar mais itens
     */
    public JMenuHelper addItem(final Object actionObject, final String action,
            String item, IconPackBase64 icon, Shortcut shortcut,
            Character mneumonic) {

        JMenuItem i = new JMenuItem(item);

        if (mneumonic != null) {
            i.setMnemonic(mneumonic);
        }

        if (icon != null) {
            i.setIcon(new ImageReaderBase64(icon).toImage());
        }

        i.setAccelerator(KeyStroke.getKeyStroke(shortcut.toString()));

        if (actionObject != null && action != null) {
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UtilMethod.executeMethod(actionObject, action);
                }
            });
        }

        menu.add(i);
        return this;
    }

    /**
     * Adiciona um separador entre os itens do menu
     *
     * @return Este objeto que permitirá adicionar mais itens
     */
    public JMenuHelper addSeparator() {
        menu.addSeparator();
        return this;
    }
}
