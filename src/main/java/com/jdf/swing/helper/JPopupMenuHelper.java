package com.jdf.swing.helper;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

/**
 * Classe auxiliar para criação do objeto JPopupMenu
 *
 * @author lossurdo
 * @since 20/04/2009
 */
public final class JPopupMenuHelper extends MenuAbstract {

    public JPopupMenuHelper(final JPopupMenu popupMenu, Container parentContainer) {
        super(popupMenu);

        parentContainer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                if (me.isPopupTrigger()) {
                    popupMenu.show(me.getComponent(), me.getX(), me.getY());
                }
            }
        });
    }

}
