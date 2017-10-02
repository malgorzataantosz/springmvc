<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form commandName="offer" action="${pageContext.request.contextPath}/docreate" method="post">
<table class="formtable">
<tr><td class="label">Name </td><td><sf:input cssClass="label" name="name" type="text" path="name"/><sf:errors cssClass="error" path="name"></sf:errors></td></tr>
<tr><td class="label">Email </td><td><sf:input cssClass="label" name="email" type="text" path="email"/><sf:errors cssClass="error" path="email"></sf:errors></td></tr>
<tr><td class="label">Text </td><td><sf:textarea path="text"></sf:textarea><sf:errors path="text"></sf:errors></td></tr>
<tr><td class="label"></td><td><input value="Create advert" type="submit"/></td></tr>
</table>
</sf:form>
</body>
</html>