package com.jdf.swing.helper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.jdf.util.UtilMethod;

/**
 * Classe auxiliar para o objeto JTree
 *
 * @author lossurdo
 * @since 06/05/2009
 */
public final class JTreeHelper<T> {

    private JTree tree;
    private DefaultMutableTreeNode objectSel;
    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode last;
    private boolean controlDoubleClick;
    private Object object;
    private String action;

    /**
     * Construtor
     *
     * @param tree
     */
    public JTreeHelper(final JTree tree) {
        this(tree, null);
    }

    /**
     * Construtor
     *
     * @param tree
     * @param rootName Nome da raíz
     */
    public JTreeHelper(final JTree tree, String rootName) {
        this.tree = tree;
        tree.setAutoscrolls(true);
        mouseListener(tree);
        if (rootName != null) {
            root = new DefaultMutableTreeNode(rootName);
        } else {
            root = new DefaultMutableTreeNode("");
            tree.setRootVisible(false);
        }
    }

    /**
     * Adiciona um nó principal a um nó já existente
     *
     * @param object
     * @param mod
     * @return
     */
    public JTreeHelper<T> addNode(T object, boolean mod) {
        if (mod) {
            DefaultMutableTreeNode dmt = new DefaultMutableTreeNode(object);
            last.add(dmt);
            last = dmt;

            tree.setModel(new DefaultTreeModel(last));
            return this;
        } else {
            return addNode(object);
        }
    }

    /**
     * Adiciona um nó principal
     *
     * @param object
     * @return
     */
    public JTreeHelper<T> addNode(T object) {
        DefaultMutableTreeNode dmt = new DefaultMutableTreeNode(object);
        last = dmt;
        root.add(dmt);

        tree.setModel(new DefaultTreeModel(root));
        return this;
    }

    /**
     * Adiciona um sub-nó ao nó principal
     *
     * @param object
     * @return
     */
    public JTreeHelper<T> addSubnode(T object) {
        DefaultMutableTreeNode dmt = new DefaultMutableTreeNode(object);
        last.add(dmt);

        tree.setModel(new DefaultTreeModel(root));
        return this;
    }

    private void mouseListener(final JTree tree) {
        tree.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                objectSel = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();
                if (controlDoubleClick && evt.getClickCount() >= 2) {
                    UtilMethod.executeMethod(object, action);
                }
            }
        });
    }

    /**
     * Atribui a ação a ser executada no momento do duplo clique no nó
     *
     * @param object Objeto que contém a ação a ser executada
     * @param action Método a ser executado
     */
    public void setDoubleClickAction(Object object, String action) {
        this.object = object;
        this.action = action;
        controlDoubleClick = true;
    }

    /**
     * Devolve o objeto selecionado
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getSelected() {
        return (T) objectSel.getUserObject();
    }

    /**
     * Inicia a árvore com todos os nós abertos
     */
    public void setAllOpened() {
        expandAll(tree, true);
    }

    private void expandAll(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        expandAll(tree, new TreePath(root), expand);
    }

    @SuppressWarnings("unchecked")
    private void expandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            for (Enumeration e = node.children(); e.hasMoreElements();) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandAll(tree, path, expand);
            }
        }

        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }
}
