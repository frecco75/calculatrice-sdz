package com.openclassrooms.utilities;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

	/**
	 * Récupère une {@link String} pour le paramètre <i>key</i> de la requête
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getString(HttpServletRequest request, String key) {
		return request.getParameter(key);
	}
	
	/**
	 * Récupère un <code>double</code> pour le paramètre <i>key</i> de la requête
	 * Renvoie 0 si le paramètre n'existe pas
	 * @param request
	 * @param key
	 * @return
	 */
	public static double getDouble(HttpServletRequest request, String key) {
		String value = getString(request, key);
		return DoubleUtils.getDoubleDefault0(value);
	}
	
	
}
