/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Database.DAO;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.EventQueue;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import sun.java2d.SunGraphicsEnvironment;

/**
 *
 * @author gbartholomeu
 */
public class UserFrame extends javax.swing.JFrame {

    private final JFrame parentFrame;
    private final static Logger LOGGER = Logger.getLogger(UserFrame.class.getName());

    /**
     * Creates new form UserFrame
     *
     * @param parentFrame
     */
    public UserFrame(JFrame parentFrame) {
        initComponents();
        this.parentFrame = parentFrame;
    }

    public void setConfiguration() {
        setUserFrameConfiguration();
        fillObjectsTable();
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
        ResultSet rs = DAO.selectFromDatabase(Constantes.Const.SQL.SELECT_ALL_USERS.getSqlCode());

        while (getTblUser().getRowCount() > 0) {
            ((DefaultTableModel) getTblUser().getModel()).removeRow(0);
        }
        ((DefaultTableModel) getTblUser().getModel()).setColumnCount(0);

        ResultSetMetaData rsMd = null;
        int columns = 0;
        try {
            rsMd = (ResultSetMetaData) rs.getMetaData();
            columns = rsMd.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                ((DefaultTableModel) getTblUser().getModel()).addColumn(getColumnName(rsMd.getColumnName(i)));
            }
        } catch (SQLException ex) {
            LOGGER.info(new StringBuilder("Falha na adição das colunas ao objeto de tabela: ").append(ex).toString());
        }

        try {
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }

                ((DefaultTableModel) getTblUser().getModel()).insertRow(rs.getRow() - 1, row);
            }
        } catch (SQLException ex) {
            LOGGER.info(new StringBuilder("Falha na adição das linhas ao objeto de tabela: ").append(ex).toString());
        }
        adjustTableColumns(getTblUser().getColumnModel());
        if (selectFirstRow) {
            getTblUser().getSelectionModel().setSelectionInterval(0, 0);
        }
    }

    private String getColumnName(String nmColunaCampo) {
        switch (nmColunaCampo) {
            case "username": {
                return "Usuário";
            }
            case "fullname": {
                return "Nome Completo";
            }
            case "isAdmin": {
                return "Administrador";
            }
        }
        return "Error";
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
        if (evt.getButton() == MouseEvent.BUTTON3) {
            getPopUpUser().show(this, evt.getX() + 20, evt.getY() + 20);
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
