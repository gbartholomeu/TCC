/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Constantes.Expressions;
import Database.DAO;
import Dictionary.DictionaryFrame;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Component;
import java.awt.EventQueue;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import sun.java2d.SunGraphicsEnvironment;

/**
 *
 * @author gbartholomeu
 */
public class UserFrame extends javax.swing.JFrame {

    private final JFrame parentFrame;
    private final static Logger LOGGER = Logger.getLogger(UserFrame.class.getName());

    private final TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) {
                JCheckBox isActive = new JCheckBox();
                isActive.setSelected((Boolean) value);
                return isActive;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    };

    /**
     * Creates new form UserFrame
     *
     * @param parentFrame
     */
    public UserFrame(JFrame parentFrame) {
        initComponents();
        turnOffTableEditable();
        this.parentFrame = parentFrame;
    }

    private void turnOffTableEditable() {
        getTblUser().setDefaultEditor(Object.class, null);
    }

    public void setConfiguration() {
        setUserFrameConfiguration();
        fillObjectsTable();
                String dsUsuario = "";
        Object usuarioLogado = DAO.selectFromDatabase(Constantes.Const.SQL.SELECT_USER_USERNAME.getSqlCode(), UserInstance.getUsuarioAtivo());
        if (usuarioLogado instanceof ResultSet) {
            try {
                if (((ResultSet) usuarioLogado).next()) {
                    dsUsuario = ((ResultSet) usuarioLogado).getString("USERNAME");
                }
            } catch (SQLException ex) {
                Logger.getLogger(DictionaryFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        getUserFrame().setTitle("Lista de usuários || Usuário conectado: " + dsUsuario);
    }

    private void setUserFrameConfiguration() {
        getUserFrame().setLocationRelativeTo(null);
        getUserFrame().setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getUserFrame().setResizable(false);
        Rectangle usableBounds = SunGraphicsEnvironment.getUsableBounds(getUserFrame().getGraphicsConfiguration().getDevice());
        setMaximizedBounds(usableBounds);
        setExtendedState(MAXIMIZED_BOTH);
        getUserFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                getParentFrame().setVisible(true);
            }
        });
    }

    public void fillObjectsTable() {
        fillObjectsTable(true);
    }

    private void fillObjectsTable(boolean selectFirstRow) {
        Object rs = DAO.selectFromDatabase(Constantes.Const.SQL.SELECT_ALL_USERS.getSqlCode());
        if (rs instanceof ResultSet) {

            while (getTblUser().getRowCount() > 0) {
                ((DefaultTableModel) getTblUser().getModel()).removeRow(0);
            }
            ((DefaultTableModel) getTblUser().getModel()).setColumnCount(0);

            ResultSetMetaData rsMd = null;
            int columns = 0;
            try {
                rsMd = (ResultSetMetaData) ((ResultSet) rs).getMetaData();
                columns = rsMd.getColumnCount();

                for (int i = 1; i <= columns; i++) {
                    ((DefaultTableModel) getTblUser().getModel()).addColumn(getColumnName(rsMd.getColumnLabel(i)));
                }
            } catch (SQLException ex) {
                LOGGER.info(new StringBuilder(Expressions.COMPONENTS.COLUMNN_ADD_FAIL.getExpression()).append(ex).toString());
            }

            try {
                while (((ResultSet) rs).next()) {
                    Object[] row = new Object[columns];
                    for (int i = 1; i <= columns; i++) {
                        row[i - 1] = ((ResultSet) rs).getObject(i);
                    }

                    ((DefaultTableModel) getTblUser().getModel()).insertRow(((ResultSet) rs).getRow() - 1, row);
                }
            } catch (SQLException ex) {
                LOGGER.info(new StringBuilder(Expressions.COMPONENTS.ROW_ADD_FAIL.getExpression()).append(ex).toString());
            }
            getTblUser().getColumnModel().getColumn(2).setCellRenderer(tableCellRenderer);
            adjustTableColumns(getTblUser().getColumnModel());
            if (selectFirstRow) {
                getTblUser().getSelectionModel().setSelectionInterval(0, 0);
            }
        }
    }

    private String getColumnName(String nmColunaCampo) {
        switch (nmColunaCampo) {
            case "USERNAME": {
                return Expressions.TABLE_COLUMNS.USERNAME.getExpression();
            }
            case "FULL_NAME": {
                return Expressions.TABLE_COLUMNS.FULL_NAME.getExpression();
            }
            case "IS_ADMIN": {
                return Expressions.TABLE_COLUMNS.IS_ADMIN.getExpression();
            }
        }
        return Expressions.TABLE_COLUMNS.NOT_A_COLUMN.getExpression();
    }

    private void adjustTableColumns(TableColumnModel columnModel) {
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            int width = String.valueOf(columnModel.getColumn(i).getHeaderValue()).length();
            columnModel.getColumn(i).setPreferredWidth(width * 10);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpUser = new javax.swing.JPopupMenu();
        popUpItemNewUser = new javax.swing.JMenuItem();
        pnlMain = new javax.swing.JPanel();
        scrpnlUser = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();

        popUpItemNewUser.setText("Criar usuário");
        popUpItemNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popUpItemNewUserActionPerformed(evt);
            }
        });
        popUpUser.add(popUpItemNewUser);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuários cadastrados");

        pnlMain.setLayout(new java.awt.BorderLayout());

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUser.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblUserMouseReleased(evt);
            }
        });
        scrpnlUser.setViewportView(tblUser);

        pnlMain.add(scrpnlUser, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void popUpItemNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popUpItemNewUserActionPerformed
        NewUserFrame newUser = new NewUserFrame(getUserFrame());
        EventQueue.invokeLater(() -> {
            newUser.setConfiguration();
        });
        newUser.setVisible(true);
    }//GEN-LAST:event_popUpItemNewUserActionPerformed

    private void tblUserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseReleased
        if (UserInstance.isAdmin()) {
            if (evt.getButton() == MouseEvent.BUTTON3) {
                getPopUpUser().show(this, evt.getX() + 20, evt.getY() + 20);
            }
        }
    }//GEN-LAST:event_tblUserMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlMain;
    private javax.swing.JMenuItem popUpItemNewUser;
    private javax.swing.JPopupMenu popUpUser;
    private javax.swing.JScrollPane scrpnlUser;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables

    public JFrame getUserFrame() {
        return this;
    }

    public JTable getTblUser() {
        return tblUser;
    }

    public JFrame getParentFrame() {
        return parentFrame;
    }

    public JPopupMenu getPopUpUser() {
        return popUpUser;
    }

}
