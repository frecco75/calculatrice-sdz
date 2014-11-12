package com.openclassrooms.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openclassrooms.entity.CalculatriceInput;
import com.openclassrooms.entity.Operator;
import com.openclassrooms.exceptions.NotSupportedOperationException;

/**
 * <strong>Calculatrice simple [MOOC OpenClassrooms]</strong>
 * <br>Cette implémentation gère les nombres décimaux.
 * 
 * <br> Pour ajouter une opération c'est très simple :
 * <ul>
 * <li>Ajouter l'opération dans l'énumération {@link Operator}</li>
 * <li>Définir ce que fait cette opération dans {@link CalculatriceServlet#computeResult(CalculatriceInput)}
 * </ul>
 * 
 * @author fabienrecco <fabien.recco@gmail.com>
 *
 */
@WebServlet("/")
public class CalculatriceServlet extends AbstractCommonServlet {
	
	private static final long serialVersionUID = 3635676995981432753L;

	
	// Action
	//--------------------------------------------------
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addLabelVariables(request);
		super.doGet(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addLabelVariables(request);

		CalculatriceInput input = new CalculatriceInput(request);
		request.setAttribute("input", input);
		
		computeResult(request, input);
		
		super.doPost(request, response);
	}

	
	// Private methods
	//--------------------------------------------------
	
	/**
	 * Rend disponible à la vue les variables de labels
	 * @param request
	 */
	private void addLabelVariables(HttpServletRequest request) {
		request.setAttribute("number1_label", CalculatriceInput.NUMBER1);
		request.setAttribute("number2_label", CalculatriceInput.NUMBER2);
		request.setAttribute("operator_label", CalculatriceInput.OPERATOR);
		request.setAttribute("operators", Operator.values());
	}
	
	/**
	 * Réalise le traitement de la calculatrice
	 * @param request
	 * @param input
	 */
	private void computeResult(HttpServletRequest request, CalculatriceInput input) {
		try {
			BigDecimal result = computeResult(input);
			request.setAttribute("result", result);
		}
		catch(NotSupportedOperationException e) {
			request.setAttribute("error", MessageFormat.format("L''opération \"{0}\" n''est pas supportée", input.getLitteralOperation()));
		}
	}
	
	/**
	 * Retourne le résultat de l'opération
	 * @param input
	 * @return
	 */
	private BigDecimal computeResult(CalculatriceInput input) throws NotSupportedOperationException {
		if(input != null) {
			BigDecimal number1 = input.getNumber1();
			BigDecimal number2 = input.getNumber2();
			
			switch(input.getOperator()) {
				case SUM            : return number1.add(number2);
				case SUBSTRACTION   : return number1.subtract(number2);
				case MULTIPLICATION : return number1.multiply(number2);
				case DIVISION       : if(number2.doubleValue() == 0) { throw new NotSupportedOperationException(); }
									  return number1.divide(number2);
				default             : ;
			}
		}
		return null;
	}

}
