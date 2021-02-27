package br.com.justa;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ConvertUnits {

    public static String convertUnits(String units) {     
        
        JSONObject response = new JSONObject();

        Map<String, Double> multiplicationFactors = new HashMap<String, Double>();
            multiplicationFactors.put("minute", 60.0);
            multiplicationFactors.put("min", 60.0);
            multiplicationFactors.put("hour", 3600.0);
            multiplicationFactors.put("h", 3600.0);
            multiplicationFactors.put("day", 86400.0);
            multiplicationFactors.put("d", 86400.0);
            multiplicationFactors.put("s", 1.0);
            multiplicationFactors.put("degree", Math.PI / 180);
            multiplicationFactors.put("grau", Math.PI / 180);
            multiplicationFactors.put("arcminute", Math.PI / 10800);
            multiplicationFactors.put("minuto", Math.PI / 10800);
            multiplicationFactors.put("arcsecond", Math.PI / 648000);
            multiplicationFactors.put("segundo", Math.PI / 648000);
            multiplicationFactors.put("rad", 1.0);
            multiplicationFactors.put("hectare", 10000.0);
            multiplicationFactors.put("ha", 10000.0);
            multiplicationFactors.put("mm", 1.0);
            multiplicationFactors.put("litre", 0.001);
            multiplicationFactors.put("L", 0.001);
            multiplicationFactors.put("mmm", 1.0);
            multiplicationFactors.put("tonne", 1000.0);
            multiplicationFactors.put("t", 1000.0);
            multiplicationFactors.put("kg", 1.0);

        try {

            String unitsToEvaluate = units.replaceAll("\u00B0", "grau");
                unitsToEvaluate = unitsToEvaluate.replaceAll("\u0027", "minuto");
                unitsToEvaluate = unitsToEvaluate.replaceAll("\\u0022", "segundo");
                unitsToEvaluate = unitsToEvaluate.replaceAll("m\u00B2", "mm");
                unitsToEvaluate = unitsToEvaluate.replaceAll("m\u00B3", "mmm");
            
            double result = (new ExpressionBuilder(unitsToEvaluate).implicitMultiplication(false).variables(multiplicationFactors.keySet()).build().setVariables(multiplicationFactors).evaluate());

            String unit_name = units.replaceAll("\\bminute\\b|\\bmin\\b|\\bhour\\b|\\bh\\b|\\bday\\b|\\bd\\b|\\bs\\b", "s");
                unit_name = unit_name.replaceAll("\\bdegree\\b|\u00B0|\\barcminute\\b|\u0027|\\barcsecond\\b|\\u0022|\\brad\\b", "rad");
                unit_name = unit_name.replaceAll("\\bhectare\\b|\\bha\\b", "m²");
                unit_name = unit_name.replaceAll("\\blitre\\b|\\bL\\b", "m³");
                unit_name = unit_name.replaceAll("\\btonne\\b|\\bt\\b", "kg");

            response.put("unit_name", unit_name);
            response.put("multiplication_factor", result);            

        } catch(Exception ex) {            
            response.put("erro_message", ex.getMessage());
            return response.toString(4);
        }
        
        return response.toString(4);
    }

}