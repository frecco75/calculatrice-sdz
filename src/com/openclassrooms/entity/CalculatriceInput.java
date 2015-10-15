package com.openclassrooms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

import javax.servlet.http.HttpServletRequest;

import com.openclassrooms.utilities.RequestUtils;

public class CalculatriceInput implements Serializable {

    private static final long serialVersionUID = 359877416308161895L;
    
    private final static String SEPARATOR = " ";
    
    // Constants
    //--------------------------------------------------
        
    public static final String NUMBER1 = "number1";
    public static final String NUMBER2 = "number2";
    public static final String OPERATOR = "operator";
    
    
    // Constructor
    //--------------------------------------------------
    
    public CalculatriceInput(HttpServletRequest request) {
        setNumber1(computeBigDecimal(request, NUMBER1));
        setNumber2(computeBigDecimal(request, NUMBER2));
        setOperator(computeOperator(request));
    }
    
    
    // Request parameters parsing
    //--------------------------------------------------

    private Operator computeOperator(HttpServletRequest request) {
        String operatorName = RequestUtils.getString(request, OPERATOR);
        Operator operator = Operator.getOperator(operatorName);
        return operator;
    }
    
    private BigDecimal computeBigDecimal(HttpServletRequest request, String param) {
        Double doubleValue = RequestUtils.getDouble(request, param);
        return new BigDecimal(doubleValue, MathContext.DECIMAL32);
    }
    
    
    // Attributes
    //--------------------------------------------------
    
    private BigDecimal number1;
    private BigDecimal number2;
    private Operator operator;
    
    
    // Getters
    //--------------------------------------------------
    
    public BigDecimal getNumber1()  { return number1;  }
    public BigDecimal getNumber2()  { return number2;  }
    public Operator getOperator()   { return operator; }
    
    
    // Setters
    //--------------------------------------------------

    public void setNumber1(BigDecimal number1)   { this.number1 = number1;   }
    public void setNumber2(BigDecimal number2)   { this.number2 = number2;   }
    public void setOperator(Operator operator)   { this.operator = operator; }
    
    
    public String getLitteralOperation() {
        return number1 + SEPARATOR + operator.getMark() + SEPARATOR + number2;
    }

}
