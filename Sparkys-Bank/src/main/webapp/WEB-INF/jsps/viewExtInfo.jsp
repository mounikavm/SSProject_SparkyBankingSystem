<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View My Profile</title>
</head>
<body>
   <jsp:include page="hello.jsp"></jsp:include>
   <h3>This is your profile!</h3>
   <div>
		<div class="panel panel-default">
			<div class="panel-heading">First Name</div>
			<div class="panel-body">${accessInfo.firstname}</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">Middle Name</div>
			<div class="panel-body">${accessInfo.middlename}</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">Last Name</div>
			<div class="panel-body">${accessInfo.lastname}</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">User Name</div>
			<div class="panel-body">${accessInfo.username}</div>
		</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">Email ID</div>
			<div class="panel-body">${accessInfo.email}</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">Address</div>
			<div class="panel-body">${accessInfo.address}</div>
	   </div>
   </div>
</body>
</html>