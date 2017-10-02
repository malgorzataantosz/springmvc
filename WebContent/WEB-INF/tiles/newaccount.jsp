<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<h2> Create new account</h2>
<sf:form id="details" commandName="user"
	action="${pageContext.request.contextPath}/createaccount" method="post">
	<table class="formtable">
		<tr>
			<td class="label">Username</td>
			<td><sf:input cssClass="label" name="username" type="text"
					path="username" /> <sf:errors path="username"></sf:errors></td>
		</tr>
		<tr>
			<td class="label">Email</td>
			<td><sf:input cssClass="label" name="email" type="text"
					path="email" /> <sf:errors path="email"></sf:errors></td>
		</tr>
		<tr>
			<td class="label">Password</td>
			<td><sf:input cssClass="label" name="password" id="password"
					type="password" path="password" /> <sf:errors path="email"></sf:errors></td>
		</tr>
		<tr>
			<td class="label">Confirm password</td>
			<td><input class="label" id="confirmpass" name="confirmpass"
				type="password" />
				<div id="matchpass"></div></td>
		</tr>
		<tr>
			<td class="label"></td>
			<td><input value="Create account" type="submit" /></td>
		</tr>
	</table>
</sf:form>
