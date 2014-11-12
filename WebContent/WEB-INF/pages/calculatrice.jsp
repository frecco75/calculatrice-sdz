<%@page import="com.openclassrooms.entity.Operator"%>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
</head>

<body>

<%@include file="resultat.jsp" %>


<form method="post">
<input name="${number1_label}" type="text" value="" />

<% Operator[] operators = (Operator[]) request.getAttribute("operators"); %>
<select name="${operator_label}">
    <% for(Operator operator : operators) { %>
    <option value="<%= operator.getMark() %>"><%= operator.getMark() %></option>
    <% } %>
</select>

<input name="${number2_label}" type="text" value="" />
<input type="submit" value="envoyer" />
</form>

</body>


</html>