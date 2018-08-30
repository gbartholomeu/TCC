/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Constantes.Expressions;
import Login.LoginFrame;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 *
 * @author gbartholomeu
 */
public class Utilities {

    private final static Logger LOGGER = Logger.getLogger(Utilities.class.getName());

    public static String validaString(Object o) {
        try {
            return String.valueOf(o);
        } catch (Exception e) {
            return "";
        }
    }

    public static String converteInt(Object o) {
        int numero = validaInt(o);
        return String.valueOf(numero);
    }

    public static Float validaFloat(Object o) {
        try {
            return Float.parseFloat(o.toString());
        } catch (Exception e) {
            return 0f;
        }

    }

    public static int validaInt(Object o) {
        try {
            return Integer.parseInt(o.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static long validaLong(Object o) {
        try {
            return Long.parseLong(o.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static double validaDouble(Object o) {
        try {
            return Double.valueOf(o.toString());
        } catch (Exception e) {

        }
        return 0;
    }

    public static boolean validaBoolean(Object o) {
        try {
            return Boolean.parseBoolean(o.toString());
        } catch (Exception e) {

        }
        return false;
    }

    public static boolean inEqualsIgnoreCase(String palava, String... contextos) {
        return palava.toUpperCase().contains(contextos.toString().toUpperCase());
    }

    public static Date getData(String d) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = format.parse(d);
        } catch (ParseException e) {
            System.out.println("Data em formato inválido.");
        }
        return data;
    }

    public static void objectEnabledControl(boolean enabled, Object... args) {
        if (args != null && args.length > 0) {
            for (Object obj : args) {
                if (obj instanceof Component) {
                    ((Component) obj).setEnabled(enabled);
                }
            }
        }
    }

    public static void objectVisibilityControl(boolean visible, Object... args) {
        if (args != null && args.length > 0) {
            for (Object obj : args) {
                if (obj instanceof Component) {
                    ((Component) obj).setVisible(visible);
                }
            }
        }
    }

    public static void objectEditableControl(boolean editable, Object... args) {
        if (args != null && args.length > 0) {
            for (Object obj : args) {
                if (obj instanceof JTextComponent) {
                    ((JTextComponent) obj).setEditable(editable);
                    try {
                        ((JTextComponent) obj).setBackground(new java.awt.Color(255, 255, 255));
                    } catch (Exception ex) {
                        LOGGER.info(ex.getMessage());
                    }
                } else if (obj instanceof JComboBox) {
                    ((JComboBox) obj).setEditable(editable);
                }
            }
        }
    }

}
