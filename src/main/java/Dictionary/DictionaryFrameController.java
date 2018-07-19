/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

import Components.CHashMap;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author gbartholomeu
 */
public class DictionaryFrameController {

    public static String getProcedureFunctionTriggerTemplate(String nameObject, boolean isProcedure, boolean isFunction, boolean isTrigger) {

        String procFuncTrig = nameObject.equals("") ? "new_procedure" : nameObject;
        String type = (isProcedure) ? "PROCEDURE" : (isFunction) ? "FUNCTION" : (isTrigger) ? "TRIGGER" : "";
        //"DROP " + type + " IF EXISTS " + procFuncTrig + ";\n"

        return "CREATE " + type + " `" + procFuncTrig + "` ()\n"
                + "BEGIN\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "END;";
    }

    public static String getProcedureOrFunctionTemplateWithVariables(String nameProcedure, ArrayList<CHashMap> variables, boolean isProcedure, boolean isFunction, String tipoRetorno, boolean isTrigger) {
        String procFuncTrig = nameProcedure.equals("") ? "new_procedure" : nameProcedure;
        String type = (isProcedure) ? "PROCEDURE" : (isFunction) ? "FUNCTION" : (isTrigger) ? "TRIGGER" : "";

        //String sql = "DROP " + type + " IF EXISTS " + procFuncTrig + ";\n";
        String sql = "";
        if (isProcedure && !isFunction && !isTrigger) {
            sql += "CREATE PROCEDURE `" + procFuncTrig + "` (" + getVariablesAsString(variables) + ")"
                    + "\nBEGIN\n"
                    + getDeclareVariablesAsString(variables) //Caso queira colocar as variaveis declaraveis para ele criar as declarações automáticas
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "END;";
        } else if (!isProcedure && isFunction && !isTrigger) {
            sql += "CREATE FUNCTION `" + procFuncTrig + "` (" + getVariablesAsString(variables) + ")"
                    + "\nRETURNS " + tipoRetorno
                    + "\nBEGIN\n"
                    //+ getDeclareVariablesAsString(variables) Caso queira colocar as variaveis declaraveis para ele criar as declarações automáticas
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\nRETURN *retorno*;"
                    + "\nEND;";
        }
        System.out.println(sql);
        return sql;
    }

    public static String getDropClause(String nameObject, boolean isProcedure, boolean isFunction, boolean isTrigger) {
      String procFuncTrig = nameObject.equals("") ? "new_procedure" : nameObject;
        String type = (isProcedure) ? "PROCEDURE" : (isFunction) ? "FUNCTION" : (isTrigger) ? "TRIGGER" : "";

        return "DROP " + type + " IF EXISTS " + procFuncTrig + ";\n";
    }

    private static String getVariablesAsString(ArrayList<CHashMap> variables) {
        String variablesAsString = "";

        for (int x = 0; x < variables.size(); x++) {
            variablesAsString += " " + variables.get(x).getValorAsString("NM_VARIABLE");
            //variablesAsString += (variables.get(x).getValorAsString("IN").equalsIgnoreCase("S")) ? " IN" : " OUT";
            variablesAsString += " " + variables.get(x).getValorAsString("TYPE_VARIABLE");
            if (x + 1 < variables.size()) {
                variablesAsString += ",";
            }
        }

        return variablesAsString;

    }

    private static String getDeclareVariablesAsString(ArrayList<CHashMap> variables) {
        String variablesAsString = "";
        String separador = ";";

        for (int x = 0; x < variables.size(); x++) {
            variablesAsString += "\n"
                    + "DECLARE ";
            variablesAsString += variables.get(x).getValorAsString("NM_VARIABLE");
            variablesAsString += " " + variables.get(x).getValorAsString("TYPE_VARIABLE");
            variablesAsString += separador;
        }
        return variablesAsString;

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
