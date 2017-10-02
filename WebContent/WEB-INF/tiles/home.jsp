<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="home">
	<p>
		<a href="${pageContext.request.contextPath}/offers">Show current
			offers</a>
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/">Create an
			offer</a>
	</p>

	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p>
			<a href="<c:url value='/admin'></c:url>">Admin Panel</a>
		</p>
	</sec:authorize>

</div>
