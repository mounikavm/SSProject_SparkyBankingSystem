<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/css/theme.css"/>"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>	
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>

<title>Home</title>
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
</body>
</html>
