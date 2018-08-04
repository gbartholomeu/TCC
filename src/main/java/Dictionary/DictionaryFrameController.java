/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

import javax.swing.JTextArea;

/**
 *
 * @author gbartholomeu
 */
public class DictionaryFrameController {

    //SET GLOBAL log_bin_trust_function_creators = 1;
    public static String getProcedureFunctionTriggerTemplate(String nameObject, boolean isProcedure, boolean isFunction, boolean isTrigger) {

        String procFuncTrig = nameObject.equals("") ? "new_procedure" : nameObject;
        String type = (isProcedure) ? "PROCEDURE" : (isFunction) ? "FUNCTION" : (isTrigger) ? "TRIGGER" : "";
        //"DROP " + type + " IF EXISTS " + procFuncTrig + ";\n"

        return "CREATE " + type + " `" + procFuncTrig + "`"
                + (isFunction || isProcedure ? " ()\n" : "\n")
                + (isFunction ? " RETURNS INT(255)\n" : (isTrigger ? " :CONDICAO ON :TABELA_ALVO \n" : "\n"))
                + (isTrigger ? "FOR EACH ROW \n" : "\n")
                + "BEGIN\n"
                + (isFunction ? "DECLARE OBJECT_RETURN INT(255);\n" : "\n")
                + "\n"
                + (isFunction ? "RETURN OBJECT_RETURN;\n" : "\n")
                + "\n"
                + "END;";
    }

    public static String getDropClause(String nameObject, boolean isProcedure, boolean isFunction, boolean isTrigger) {
        String procFuncTrig = nameObject.equals("") ? "new_procedure" : nameObject;
        String type = (isProcedure) ? "PROCEDURE" : (isFunction) ? "FUNCTION" : (isTrigger) ? "TRIGGER" : "";

        return "DROP " + type + " IF EXISTS " + procFuncTrig + ";\n";
    }

    public static void addIf(JTextArea jTextArea) {
        addTextOnCursor(jTextArea, "\nIF *condition1*=*condition2* THEN \n\nEND IF;");
    }

    public static void addIfElse(JTextArea jTextArea) {
        addTextOnCursor(jTextArea, "\nIF *condition1*=*condition2* THEN \n\nELSE\n\nEND IF;");
    }

    private static void addTextOnCursor(JTextArea jTextArea, String text) {
        String oldText = jTextArea.getText();
        int pos = jTextArea.getCaretPosition();
        if (pos == 0 || pos == jTextArea.getText().length()) {
            jTextArea.append(text);
        } else {
            String startText = oldText.substring(0, pos + 1);
            String endText = oldText.substring(pos);
            jTextArea.setText(startText + text + endText);
            jTextArea.setCaretPosition(pos);
        }
    }

}
