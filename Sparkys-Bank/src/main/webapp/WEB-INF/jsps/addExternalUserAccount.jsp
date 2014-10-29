<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/css/theme.css"/>" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"/>"></script>

<title>Register</title>
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
	<div style="width: 50%;">
	<div class="panel panel-default">
		<div class="panel-body">
			<form:form class="form-horizontal" action="/Sparkys-Bank/addExtUser"
				method="post" commandName="extUser" name="f">
				
				<fieldset>
					<legend>Add a new User</legend>


					<div class="form-group">
						<label class="col-lg-2 control-label">Firstname</label>
						<div class="col-lg-10">
							<form:input path="firstname" cssClass="form-control"/>
							<form:errors path="firstname" cssClass="alert alert-dismissable alert-danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Middlename</label>
						<div class="col-lg-10">
							<form:input path="middlename" cssClass="form-control"/>
							<form:errors path="middlename" cssClass="alert alert-dismissable alert-danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Lastname</label>
						<div class="col-lg-10">
							<form:input path="lastname" cssClass="form-control"/>
							<form:errors path="lastname" cssClass="alert alert-dismissable alert-danger"></form:errors>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-2 control-label">Username</label>
						<div class="col-lg-10">
							<form:input path="username" cssClass="form-control"/>
							<form:errors path="username" cssClass="alert alert-dismissable alert-danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Password</label>
						<div class="col-lg-10">
							<form:password path="password" cssClass="form-control"/>
							<form:errors path="password" cssClass="alert alert-dismissable alert-danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Date Of Birth</label>
						<div class="col-lg-10">
							<form:input path="dob" cssClass="form-control" />
							<form:errors path="dob" cssClass="alert alert-dismissable alert-danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Address</label>
						<div class="col-lg-10">
							<form:textarea path="address" cssClass="form-control"/>
							<form:errors path="address" cssClass="alert alert-dismissable alert-danger"></form:errors>
						</div>
					</div>
					
					
					<div class="form-group">
						<div class="col-lg-10 col-lg-offset-2">

							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-primary">Reset</button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>