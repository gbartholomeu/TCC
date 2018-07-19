/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import Utils.Utilities;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author gbartholomeu
 */
public class CHashMap extends HashMap {

    public int getValorAsInt(Object o) {
        return Utilities.validaInt(get(o));
    }

    public String getValorAsString(Object o) {
        return Utilities.validaString(get(o));
    }

    public Float getValorAsFloat(Object o) {
        return Utilities.validaFloat(get(o));
    }

    public Double getValorAsDouble(Object o) {
        return Utilities.validaDouble(get(o));
    }

    public static ArrayList<HashMap> converteCHashMap(ArrayList<CHashMap> lista) {
        ArrayList<HashMap> retorno = new ArrayList<HashMap>();
        for(int x = 0; x<lista.size();x++){            
            retorno.add(lista.get(x));
        }
        return retorno;
    }
}
