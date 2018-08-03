
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gbartholomeu
 */
public class JTableWithCheckBox {

    private JFrame mainFrame;
    private JTable studentTable;
    private JScrollPane scrollPaneTable;

    private DefaultTableModel model = new DefaultTableModel(new Object[][]{
        {"Ramesh", "Male"}, {"Sheela", "Female"},
        {"Amithabh", "Male"}, {"Katrina", "Female"}}, new Object[]{
        "Name", "Gender"});

    public static void main(String[] args) {
        final JTableWithCheckBox ui = new JTableWithCheckBox();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ui.initGUI();
            }
        });
    }

    private void initGUI() {
        mainFrame = new JFrame("View");
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 200);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        studentTable = new JTable(model);
        studentTable.getColumnModel().getColumn(1)
                .setCellRenderer(new MFCheckBox());
        scrollPaneTable = new JScrollPane(studentTable);
        mainFrame.add(scrollPaneTable, BorderLayout.NORTH);

    }

    private class MFCheckBox implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            JPanel cbPanel = new JPanel();
            JCheckBox maleBox = new JCheckBox("Male");
            JCheckBox femaleBox = new JCheckBox("Female");

            cbPanel.setLayout(new BorderLayout());
            cbPanel.add(maleBox, BorderLayout.WEST);
            cbPanel.add(femaleBox, BorderLayout.EAST);

            if (value != null) {
                if (value instanceof String) {
                    String valStr = (String) value;
                    switch (valStr) {
                        case "Male":
                            maleBox.setSelected(true);
                            femaleBox.setSelected(false);
                            break;
                        case "Female":
                            maleBox.setSelected(false);
                            femaleBox.setSelected(true);
                            break;
                        default:
                            maleBox.setSelected(false);
                            femaleBox.setSelected(false);
                            break;
                    }
                }
            }
            return cbPanel;
        }
    }
}
