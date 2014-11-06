<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/css/theme.css"/>" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"/>"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
	<div class="jumbotron">
		<h1>Sparky's Bank</h1>

	</div>
	<div style="width: 60%;">
		<div class="panel panel-default">
			<div class="panel-body">

				<fieldset>
					<legend>Forgot Password</legend>

					<div class="form-group">
						<label for="inputEmail" class="col-lg-2 control-label">Your
							Email Id:</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputEmail"
								placeholder="Email">
						</div>
					</div>
					<div class="col-lg-10 col-lg-offset-2">
						<a href="/Sparkys-Bank/" class="btn btn-primary">Next</a>
					</div>
					<c:if test="">
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">Your
								Email Id:</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="inputEmail"
									placeholder="Email">
							</div>
						</div>
					</c:if>
					<c:if test="">
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">Your
								Email Id:</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="inputEmail"
									placeholder="Email">
							</div>
						</div>
					</c:if>

				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>