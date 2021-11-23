<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import br.com.jonathanferreira.servlets.entities.Company, java.util.List%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<ul>
       <%
       List<Company> list = (List<Company>)request.getAttribute("companies");
       for (Company company : companies) {
       %>
       <li>
        <%= company.getName() %>
        </li>
        <% } %>
</ul>
</body>
</html>