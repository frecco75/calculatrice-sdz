package com.openclassrooms.entity;

public enum Operator {
	SUM("+"), MULTIPLICATION("x"), DIVISION(":"), SUBSTRACTION("-");
	
	private String mark;
	
	Operator(String mark) {
		setMark(mark);
	}
	
	public String getMark() { return mark; }
	public void setMark(String mark) { this.mark = mark; }
	
	public static Operator getOperator(String mark) {
		for(Operator o : Operator.values()) {
			if(o.getMark().equals(mark)) {
				return o;
			}
		}
		
		System.out.println("Not supported operator " + mark + " !");
		return null;
	}

}
