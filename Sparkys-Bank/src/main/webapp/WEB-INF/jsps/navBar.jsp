<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="navbar navbar-inverse" style="margin:0px">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-inverse-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Welcome <sec:authentication property="name"/></a>
		</div>
		<div class="navbar-collapse collapse navbar-inverse-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/Sparkys-Bank/home">Home</a></li>
				<sec:authorize ifAnyGranted="ROLE_ADMIN"><li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Admin Specific Account Management<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<sec:authorize ifAnyGranted="ROLE_ADMIN"><li><a href="/Sparkys-Bank/register">Add a new account</a></li></sec:authorize>
						<sec:authorize ifAnyGranted="ROLE_ADMIN"><li><a href="/Sparkys-Bank/ViewEmpProfile">View Emp</a></li></sec:authorize>
                        <sec:authorize ifAnyGranted="ROLE_ADMIN"><li><a href="/Sparkys-Bank/EditEmpProfile">Edit Emp</a></li></sec:authorize>
						
					</ul></li></sec:authorize>
								<sec:authorize ifAnyGranted="ROLE_ADMIN"><li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Admin Specific Transaction Management<b class="caret"></b></a>
					<ul class="dropdown-menu">
						    <sec:authorize ifAnyGranted="ROLE_ADMIN"><li><a href="/Sparkys-Bank/ReviewPIIChange">PII Change Req</a></li></sec:authorize>
					</ul></li></sec:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
	</div>
</body>
</html>