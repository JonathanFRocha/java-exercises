<%
String companyName = (String) request.getAttribute("company");
System.out.println(companyName);
%>
<html>
<body>
Company <%= companyName %> successfully registered!
</body>
</html>