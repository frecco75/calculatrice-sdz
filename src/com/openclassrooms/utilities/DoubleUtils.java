package com.openclassrooms.utilities;


public class DoubleUtils {
    
    /**
     * Récupère un <code>double</code>
     * Renvoie 0 si le paramètre n'existe pas
     * @param request
     * @param key
     * @return
     */
    public static double getDoubleDefault0 (String s) {
        return getDoubleWithDefaultValue(s, 0);
    }
    
    /**
     * Renvoie un <code>double</code>
     * Renvoie la valeur par défaut si le paramètre n'existe pas
     * @param s
     * @param defaultValue
     * @return
     */
    public static double getDoubleWithDefaultValue(String s, double defaultValue) {
        Double doubleValue = getSafeDouble(s);
        return doubleValue != null ? doubleValue : defaultValue;
    }

    /**
     * Parse en {@link Double} en envoyant <code>NULL</code> en cas d'erreur
     * @param s
     * @return
     */
    public static Double getSafeDouble(String s) {
        try {
            return Double.parseDouble(s);
        }
        catch(NumberFormatException e) {
            return null;
        }
    }

}
