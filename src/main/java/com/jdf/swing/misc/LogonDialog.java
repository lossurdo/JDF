package com.jdf.swing.misc;

import com.jdf.swing.helper.JDialogHelper;
import com.jdf.swing.helper.JOptionPaneHelper;
import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.iface.JDFDefaultImages;
import com.jdf.swing.iface.JDFMessageException;
import com.jdf.util.Propriedades;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JPanel;

/**
 * Tela padrão para logon no sistema
 *
 * @author lossurdo
 * @since 20/04/2009
 */
public class LogonDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private Object object;
    private String action;

    /**
     * Construtor
     *
     * @param object Objeto que contém a ação a ser executada
     * @param action Ação a ser executada
     */
    public LogonDialog(Object object, String action) {
        super();
        this.object = object;
        this.action = action;

        // inicializa componentes
        initComponents();

        // configura janela
        JDialogHelper jdh = new JDialogHelper(this);
        jdh.setIcon(IconPackBase64.SHIELD);
        jdh.setTitle(Propriedades.getInstance().get("sistema.titulo.login"));
        jdh.centerFrame();

        // adiciona painel de login
        JPanel painelBG = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(JDFDefaultImages.getLoginBackground().getImage(), 0, 0, this);
            }
        };
        painelBG.setLayout(new BorderLayout());
        painelBG.add(painelLogin, BorderLayout.CENTER);
        add(painelBG, BorderLayout.CENTER);

        // adiciona listener de janela
        addWindowListener(new LogonWindowListener());
    }

    /**
     * Chama método que efetua logon
     */
    private void doLogon() {
        if (username.getText().equals("") || new String(password.getPassword()).equals("")) {
            JOptionPaneHelper.error("Usuário e/ou senha inválidos");
            username.requestFocus();
        } else {
            try {
                Class<?> clazz = object.getClass();
                Method m = clazz.getDeclaredMethod(action, String.class, String.class);
                m.invoke(object, username.getText(), new String(password.getPassword()));
            } catch (InvocationTargetException e) {
                JOptionPaneHelper.error(e.getTargetException());
                username.requestFocus();
                username.setSelectionStart(0);
                username.setSelectionEnd(username.getText().length());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPaneHelper.error(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        painelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        btnLogon = new javax.swing.JButton();

        painelLogin.setOpaque(false);
        painelLogin.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Usuário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        painelLogin.add(jLabel1, gridBagConstraints);

        username.setMinimumSize(new java.awt.Dimension(20, 20));
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        painelLogin.add(username, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel2.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        painelLogin.add(jLabel2, gridBagConstraints);

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        painelLogin.add(password, gridBagConstraints);

        btnLogon.setText("Logon");
        btnLogon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogonActionPerformed(evt);
            }
        });
        btnLogon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnLogonKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        painelLogin.add(btnLogon, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(300, 224));
        setResizable(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogonActionPerformed
        doLogon();
    }//GEN-LAST:event_btnLogonActionPerformed

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        if (evt.getKeyChar() == '\n') {
            password.requestFocus();
            password.setSelectionStart(0);
            password.setSelectionEnd(new String(password.getPassword()).length());
        }
    }//GEN-LAST:event_usernameKeyTyped

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        if (evt.getKeyChar() == '\n') {
            doLogon();
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void btnLogonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLogonKeyTyped
        if (evt.getKeyChar() == '\n') {
            doLogon();
        }
    }//GEN-LAST:event_btnLogonKeyTyped

    public static void main(String args[]) {
        new LogonDialog(new LogonDialog(null, null), "teste").setVisible(true);
    }

    /**
     * Exemplo de autenticação
     *
     * @param u
     * @param p
     */
    private void teste(String u, String p) {
        if ("admin".equals(u) && "admin".equals(p)) {
            JOptionPaneHelper.simpleMessage("Senha correta!");
            System.exit(0);
        } else {
            throw new JDFMessageException("Erro na validação do usuário e senha");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}

/**
 * Listener de janela para controlar quando a mesma for encerrada/fechada
 *
 * @author lossurdo
 * @since 20/04/2009
 */
class LogonWindowListener implements WindowListener {

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

}
