<%@page import="java.math.BigDecimal"%>
<%
BigDecimal result = (BigDecimal) request.getAttribute("result");
if( result != null) {
%>

R�sultat de l'op�ration
${input.number1} ${input.operator.mark} ${input.number2} = ${result}
<% } %>

${!empty error ? error : ''}