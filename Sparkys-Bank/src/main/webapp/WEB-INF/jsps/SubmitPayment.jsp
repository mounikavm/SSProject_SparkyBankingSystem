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

<title>Submit Payment</title>
</head>
<body>


<form class="form-horizontal">
  <fieldset>
   
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">Card Holder's Name</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="inputEmail" placeholder="Name">
      </div>
    </div>
    <div class="form-group">
      <label for="inputPassword" class="col-lg-2 control-label">Card Number</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="inputPassword" placeholder="Number">
        
      </div>
    </div>
    
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">Enter Amount</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="inputEmail" placeholder="Amount">
      </div>
    </div>
    
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">Enter Service</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="inputEmail" placeholder="Service">
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <button class="btn btn-default">Cancel</button>
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
  </fieldset>
</form>


</body>
</html>