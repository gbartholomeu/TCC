/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Constantes.Const;
import Constantes.Expressions;
import Database.DAO;
import Utils.Cryptography;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author gbartholomeu
 */
public class NewUserFrame extends javax.swing.JFrame {

    private final JFrame parentFrame;
    private static NewUserFrame loginInstance = null;
    private final static Logger LOGGER = Logger.getLogger(NewUserFrame.class.getName());

    /**
     * Creates new form LoginFrame
     */
    public NewUserFrame(JFrame parentFrame) {
        initComponents();
        this.parentFrame = parentFrame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEdit = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        txtPassw = new javax.swing.JPasswordField();
        lblPassw = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        checkBoxAdmin = new javax.swing.JCheckBox();
        pnlButtons = new javax.swing.JPanel();
        btnCreateNewUser = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frmLogin"); // NOI18N

        txtUser.setToolTipText("Insira o usuário de login");
        txtUser.setName("txtUser"); // NOI18N

        lblUser.setText("Usuário:");
        lblUser.setName("lblUser"); // NOI18N

        txtPassw.setToolTipText("Insira a senha do usuário para login");
        txtPassw.setName("txtPassw"); // NOI18N

        lblPassw.setText("Senha:");
        lblPassw.setName("lblPassw"); // NOI18N

        jLabel1.setText("Nome completo:");

        checkBoxAdmin.setText("Administrador");

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditLayout.createSequentialGroup()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEditLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFullname))
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlEditLayout.createSequentialGroup()
                                .addComponent(lblUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlEditLayout.createSequentialGroup()
                                .addComponent(lblPassw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxAdmin)
                                    .addComponent(txtPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(33, 33, 33))
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxAdmin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlEdit, java.awt.BorderLayout.CENTER);

        pnlButtons.setLayout(new java.awt.GridLayout(1, 0));

        btnCreateNewUser.setMnemonic('C');
        btnCreateNewUser.setText("Criar");
        btnCreateNewUser.setName("btnCreateNewUser"); // NOI18N
        btnCreateNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewUserActionPerformed(evt);
            }
        });
        pnlButtons.add(btnCreateNewUser);

        btnCancel.setMnemonic('a');
        btnCancel.setText("Cancelar");
        btnCancel.setMaximumSize(new java.awt.Dimension(63, 23));
        btnCancel.setMinimumSize(new java.awt.Dimension(63, 23));
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.setPreferredSize(new java.awt.Dimension(63, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlButtons.add(btnCancel);

        getContentPane().add(pnlButtons, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewUserActionPerformed
        if (!"".equalsIgnoreCase(getTxtUser().getText().trim()) && !"".equalsIgnoreCase(new String(getTxtPassw().getPassword()).trim()) && !"".equalsIgnoreCase(getTxtFullname().getText().trim())) {
            String retorno = "";
            byte[] salt = null;
            int interations = 1;
            int key = 1;
            Object rs = DAO.selectFromDatabase(Const.SQL.SELECT_USER.getSqlCode(), getTxtUser().getText());
            if (rs instanceof ResultSet) {
                try {
                    while (((ResultSet) rs).next()) {
                        retorno = ((ResultSet) rs).getString("QTD");
                        salt = ((ResultSet) rs).getBytes("SALT");
                        interations = ((ResultSet) rs).getInt("INTERA");
                        key = ((ResultSet) rs).getInt("KEYL");
                    }
                } catch (SQLException ex) {
                    LOGGER.info(new StringBuilder().append(Expressions.USER.USER_SELECT_RETURN_FAIL.getExpression()).append(ex).toString());
                }

                if ("1".equalsIgnoreCase(retorno)) {
                    JOptionPane.showMessageDialog(this, Expressions.USER.EXISTING_USER.getExpression());
                } else {
                    Random r = new Random();
                    salt = Cryptography.getSecuredByte();
                    interations = r.nextInt(10) + 1;
                    key = r.nextInt(10) + 1;
                    byte[] senhaCriptografia = Cryptography.getSenhaEncriptografada(salt, interations, key, new String(getTxtPassw().getPassword()));
                    int retornoInsert = DAO.insertIntoDatabase(Const.SQL.INSERT_USER.getSqlCode(), getTxtUser().getText(), getTxtFullname().getText(), salt, interations, key, senhaCriptografia, getCheckBoxAdmin().isSelected() ? 1 : 0);
                    if (retornoInsert == 0) {
                        JOptionPane.showMessageDialog(this, Expressions.USER.NEW_USER_FAIL.getExpression());
                    } else {
                        JOptionPane.showMessageDialog(this, Expressions.USER.NEW_USER_SUCESS.getExpression());
                        this.dispose();
                        ((UserFrame) getParentFrame()).fillObjectsTable();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, Expressions.COMPONENTS.MISSING_FIELDS.getExpression());
        }
    }//GEN-LAST:event_btnCreateNewUserActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        getNewUserFrame().dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreateNewUser;
    private javax.swing.JCheckBox checkBoxAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPassw;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JPasswordField txtPassw;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    public void setConfiguration() {
        getNewUserFrame().setLocationRelativeTo(null);
        getNewUserFrame().setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getNewUserFrame().setResizable(false);
        getNewUserFrame().addListeners();
        getNewUserFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                getParentFrame().setVisible(true);
            }
        });
    }

    private void addListeners() {
        KeyListener enterListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCreateNewUserActionPerformed(null);
                }
            }
        };
        getTxtUser().addKeyListener(enterListener);
        getTxtPassw().addKeyListener(enterListener);
        getBtnLogin().addKeyListener(enterListener);

        KeyListener escListener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    getNewUserFrame().dispatchEvent(new WindowEvent(getNewUserFrame(), WindowEvent.WINDOW_CLOSING));
                }
            }
        };
        getTxtUser().addKeyListener(escListener);
        getTxtPassw().addKeyListener(escListener);
        getBtnLogin().addKeyListener(escListener);
        getBtnExit().addKeyListener(escListener);
    }

    public NewUserFrame getNewUserFrame() {
        return this;
    }

    public static void setLoginInstance(NewUserFrame loginInstance) {
        NewUserFrame.loginInstance = loginInstance;
    }

    public JButton getBtnExit() {
        return btnCancel;
    }

    public JButton getBtnLogin() {
        return btnCreateNewUser;
    }

    public JPasswordField getTxtPassw() {
        return txtPassw;
    }

    public JTextField getTxtUser() {
        return txtUser;
    }

    public JTextField getTxtFullname() {
        return txtFullname;
    }

    public JCheckBox getCheckBoxAdmin() {
        return checkBoxAdmin;
    }

    public JFrame getParentFrame() {
        return parentFrame;
    }

}
