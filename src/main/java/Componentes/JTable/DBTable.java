/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes.JTable;

import javax.swing.JTable;

/**
 *
 * @author gbartholomeu
 */
public class DBTable extends JTable {

    public DBTable() {
        super();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
                type = Integer.class;
                break;
            case 1:
                type = Boolean.class;
                break;
        }
        return type;
    }

}
