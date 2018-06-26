/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

import Database.DAO;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gbartholomeu
 */
public class DictionaryFrame extends javax.swing.JFrame {

    private final JFrame parentFrame;
    private final static Logger LOGGER = Logger.getLogger(DictionaryFrame.class.getName());

    private String selectedCard = "cardGrid";
    private CardLayout cardLayout = null;

    /**
     * Creates new form DictionaryFrame
     *
     * @param parentFrame
     */
    public DictionaryFrame(JFrame parentFrame) {
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

        pnlMain = new javax.swing.JPanel();
        pnlGrid = new javax.swing.JPanel();
        pnlGridView = new javax.swing.JPanel();
        scrpnlGrid = new javax.swing.JScrollPane();
        tblObjects = new javax.swing.JTable();
        pnlDetailView = new javax.swing.JPanel();
        pnlInformation = new javax.swing.JPanel();
        pnlSQLInformation = new javax.swing.JPanel();
        lblObjectName = new javax.swing.JLabel();
        txtObjectName = new javax.swing.JTextField();
        lblObjectType = new javax.swing.JLabel();
        txtObjectType = new javax.swing.JTextField();
        lblObjectDate = new javax.swing.JLabel();
        txtObjectDate = new javax.swing.JTextField();
        lblObjectUser = new javax.swing.JLabel();
        txtObjectUser = new javax.swing.JTextField();
        pnlSQL = new javax.swing.JPanel();
        scrpnlDetail = new javax.swing.JScrollPane();
        txtareaSQL = new javax.swing.JTextArea();
        pnlButtons = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frmDictionary"); // NOI18N

        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlGrid.setLayout(new java.awt.CardLayout());

        pnlGridView.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 5, 1));
        pnlGridView.setName(""); // NOI18N
        pnlGridView.setLayout(new java.awt.BorderLayout());

        tblObjects.setModel(new javax.swing.table.DefaultTableModel(
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
        scrpnlGrid.setViewportView(tblObjects);

        pnlGridView.add(scrpnlGrid, java.awt.BorderLayout.CENTER);

        pnlGrid.add(pnlGridView, "cardGrid");

        pnlDetailView.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 5, 1));
        pnlDetailView.setLayout(new java.awt.BorderLayout());

        pnlInformation.setLayout(new java.awt.BorderLayout());

        lblObjectName.setText("Nome objeto: ");
        lblObjectName.setToolTipText("");
        pnlSQLInformation.add(lblObjectName);

        txtObjectName.setEnabled(false);
        txtObjectName.setPreferredSize(new java.awt.Dimension(170, 20));
        pnlSQLInformation.add(txtObjectName);

        lblObjectType.setText("Tipo objeto: ");
        pnlSQLInformation.add(lblObjectType);

        txtObjectType.setEnabled(false);
        txtObjectType.setPreferredSize(new java.awt.Dimension(100, 20));
        pnlSQLInformation.add(txtObjectType);

        lblObjectDate.setText("Data inserção: ");
        pnlSQLInformation.add(lblObjectDate);

        txtObjectDate.setEnabled(false);
        txtObjectDate.setPreferredSize(new java.awt.Dimension(90, 20));
        pnlSQLInformation.add(txtObjectDate);

        lblObjectUser.setText("Usuário: ");
        pnlSQLInformation.add(lblObjectUser);

        txtObjectUser.setEnabled(false);
        txtObjectUser.setPreferredSize(new java.awt.Dimension(80, 20));
        pnlSQLInformation.add(txtObjectUser);

        pnlInformation.add(pnlSQLInformation, java.awt.BorderLayout.WEST);

        pnlDetailView.add(pnlInformation, java.awt.BorderLayout.NORTH);

        pnlSQL.setLayout(new java.awt.BorderLayout());

        txtareaSQL.setColumns(20);
        txtareaSQL.setRows(5);
        scrpnlDetail.setViewportView(txtareaSQL);

        pnlSQL.add(scrpnlDetail, java.awt.BorderLayout.CENTER);

        pnlDetailView.add(pnlSQL, java.awt.BorderLayout.CENTER);

        pnlGrid.add(pnlDetailView, "cardDetail");

        pnlMain.add(pnlGrid, java.awt.BorderLayout.CENTER);

        btnNew.setMnemonic('N');
        btnNew.setText("Novo");
        btnNew.setToolTipText("");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setMnemonic('S');
        btnSave.setText("Salvar");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUndo.setMnemonic('D');
        btnUndo.setText("Desfazer");
        btnUndo.setEnabled(false);
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        btnDetail.setMnemonic('h');
        btnDetail.setText("Detalhe");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnDelete.setMnemonic('E');
        btnDelete.setText("Excluir");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUndo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(17, 17, 17))
        );

        pnlMain.add(pnlButtons, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        getBtnNew().setEnabled(false);
        getBtnSave().setEnabled(true);
        getBtnUndo().setEnabled(true);
        getBtnDetail().setEnabled(false);
        getBtnDelete().setEnabled(false);
        fillFieldsEmptyText();
        enabledAllFields(true);
        if ("cardGrid".equalsIgnoreCase(selectedCard)) {
            changeCard();
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int insertDatabase = DAO.insertIntoDatabase(Constantes.Const.SQL.INSERT_OBJECT.getSqlCode(), getTxtObjectName().getText(), getTxtObjectType().getText(), getTxtAreaSQL().getText(), "gabriel"/*getUsuarioAtivo()*/);
        if (insertDatabase == 0) {
            JOptionPane.showMessageDialog(this, "Falha ao adicionar objeto");
        } else {
            getBtnNew().setEnabled(true);
            getBtnSave().setEnabled(false);
            getBtnUndo().setEnabled(false);
            getBtnDetail().setEnabled(true);
            getBtnDelete().setEnabled(true);
            fillTable(false);
            enabledAllFields(false);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        getBtnNew().setEnabled(true);
        getBtnSave().setEnabled(false);
        getBtnUndo().setEnabled(false);
        getBtnDetail().setEnabled(getTblObjects().getRowCount() > 0);
        getBtnDelete().setEnabled(getTblObjects().getRowCount() > 0);
        changeCard();
        enabledAllFields(false);
    }//GEN-LAST:event_btnUndoActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        if ("cardDetail".equalsIgnoreCase(selectedCard)) {
            getBtnDetail().setText("Detalhe");
        } else {
            getBtnDetail().setText("Grid");
        }
        changeCard();
        fillFieldsFromObject();
        enabledAllFields(false);
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int deleteFromDatabase = DAO.deleteFromDatabase(Constantes.Const.SQL.DELETE_OBJECT.getSqlCode(), getTblObjects().getValueAt(getTblObjects().getSelectedRow(), 0));
        if (deleteFromDatabase == 0) {
            JOptionPane.showMessageDialog(this, "Falha ao apagar o objeto do banco");
        } else {
            if ("cardDetail".equalsIgnoreCase(selectedCard)) {
                changeCard();
            }
            fillTable();
            getBtnDetail().setEnabled(getTblObjects().getRowCount() > 0);
            getBtnDelete().setEnabled(getTblObjects().getRowCount() > 0);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUndo;
    private javax.swing.JLabel lblObjectDate;
    private javax.swing.JLabel lblObjectName;
    private javax.swing.JLabel lblObjectType;
    private javax.swing.JLabel lblObjectUser;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlDetailView;
    private javax.swing.JPanel pnlGrid;
    private javax.swing.JPanel pnlGridView;
    private javax.swing.JPanel pnlInformation;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSQL;
    private javax.swing.JPanel pnlSQLInformation;
    private javax.swing.JScrollPane scrpnlDetail;
    private javax.swing.JScrollPane scrpnlGrid;
    private javax.swing.JTable tblObjects;
    private javax.swing.JTextField txtObjectDate;
    private javax.swing.JTextField txtObjectName;
    private javax.swing.JTextField txtObjectType;
    private javax.swing.JTextField txtObjectUser;
    private javax.swing.JTextArea txtareaSQL;
    // End of variables declaration//GEN-END:variables

    public void setConfiguration() {
        getDicFrame().setLocationRelativeTo(null);
        getDicFrame().setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getDicFrame().setResizable(false);
        getDicFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        getDicFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parentFrame.setVisible(true);
                parentFrame.dispose();
            }
        });
        fillTable();
        getBtnDetail().setEnabled(getTblObjects().getRowCount() > 0);
        getBtnDelete().setEnabled(getTblObjects().getRowCount() > 0);
        setCardLayout((CardLayout) getPnlGrid().getLayout());
    }

    private void fillTable() {
        fillTable(true);
    }

    private void fillTable(boolean selectFirstRow) {
        ResultSet rs = DAO.selectFromDatabase(Constantes.Const.SQL.SELECT_ALL_DICTIONARY.getSqlCode());

        while (getTblObjects().getRowCount() > 0) {
            ((DefaultTableModel) getTblObjects().getModel()).removeRow(0);
        }
        ((DefaultTableModel) getTblObjects().getModel()).setColumnCount(0);

        ResultSetMetaData rsMd = null;
        int columns = 0;
        try {
            rsMd = (ResultSetMetaData) rs.getMetaData();
            columns = rsMd.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                ((DefaultTableModel) getTblObjects().getModel()).addColumn(getColumnName(rsMd.getColumnName(i)));
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

                ((DefaultTableModel) getTblObjects().getModel()).insertRow(rs.getRow() - 1, row);
            }
        } catch (SQLException ex) {
            LOGGER.info(new StringBuilder("Falha na adição das linhas ao objeto de tabela: ").append(ex).toString());
        }
        getTblObjects().removeColumn(getTblObjects().getColumnModel().getColumn(3));
        if (selectFirstRow) {
            getTblObjects().getSelectionModel().setSelectionInterval(0, 0);
        }
    }

    private String getColumnName(String nmColunaCampo) {
        switch (nmColunaCampo) {
            case "nr_sequence": {
                return "Sequência";
            }
            case "ds_name": {
                return "Nome Objeto";
            }
            case "ie_type": {
                return "Tipo Objeto";
            }
            case "dt_insertion": {
                return "Data Inserção";
            }
            case "nm_user": {
                return "Usuário";
            }
        }
        return "Error";
    }

    private void changeCard() {
        if ("cardDetail".equalsIgnoreCase(selectedCard)) {
            selectedCard = "cardGrid";
        } else {
            selectedCard = "cardDetail";
        }
        getCardLayout().show(getPnlGrid(), selectedCard);
    }

    private void fillFieldsEmptyText() {
        String str = "";
        getTxtObjectName().setText(str);
        getTxtObjectType().setText(str);
        getTxtObjectDate().setText(str);
        getTxtObjectUser().setText(str);
        getTxtAreaSQL().setText(str);
    }

    private void fillFieldsFromObject() {
        String str = "";
        str = String.valueOf(getTblObjects().getModel().getValueAt(getTblObjects().getSelectedRow(), 1));
        getTxtObjectName().setText(str);
        str = String.valueOf(getTblObjects().getModel().getValueAt(getTblObjects().getSelectedRow(), 2));
        getTxtObjectType().setText(str);
        str = String.valueOf(getTblObjects().getModel().getValueAt(getTblObjects().getSelectedRow(), 3));
        getTxtAreaSQL().setText(str);
        str = String.valueOf(getTblObjects().getModel().getValueAt(getTblObjects().getSelectedRow(), 4));
        getTxtObjectDate().setText(str);
        str = String.valueOf(getTblObjects().getModel().getValueAt(getTblObjects().getSelectedRow(), 5));
        getTxtObjectUser().setText(str);
    }

    private void enabledAllFields(boolean enabled) {
        getTxtObjectName().setEnabled(enabled);
        getTxtObjectType().setEnabled(enabled);
        getTxtAreaSQL().setEnabled(enabled);
    }

    public DictionaryFrame getDicFrame() {
        return this;
    }

    public JTable getTblObjects() {
        return tblObjects;
    }

    public String getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(String selectedCard) {
        this.selectedCard = selectedCard;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getPnlGrid() {
        return pnlGrid;
    }

    public JButton getBtnDetail() {
        return btnDetail;
    }

    public JButton getBtnNew() {
        return btnNew;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnUndo() {
        return btnUndo;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JTextField getTxtObjectDate() {
        return txtObjectDate;
    }

    public JTextField getTxtObjectName() {
        return txtObjectName;
    }

    public JTextField getTxtObjectType() {
        return txtObjectType;
    }

    public JTextField getTxtObjectUser() {
        return txtObjectUser;
    }

    public JTextArea getTxtAreaSQL() {
        return txtareaSQL;
    }

}
