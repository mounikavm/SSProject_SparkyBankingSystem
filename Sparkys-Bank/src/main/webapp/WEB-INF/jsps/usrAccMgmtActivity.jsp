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
   <jsp:include page="internalHome.jsp"></jsp:include>
   <div class="btn-group btn-group-justified">
   	<a href="/Sparkys-Bank/UserAccountManagement" class="btn btn-primary">View</a>
  	<a href="/Sparkys-Bank/UserAccountManagementEdit" class="btn btn-primary">Edit</a>
	<a href="/Sparkys-Bank/UserAccountManagementDelete" class="btn btn-primary">Delete</a>
	<a href="/Sparkys-Bank/UserAccountManagementActivity" class="btn btn-primary">Activity</a>
   </div>
      <form:form class="form-horizontal" commandName="accessInfo" method="post" action="/Sparkys-Bank/UserAccountManagementActivity">
    <fieldset>
    <legend>Enter User Credentials to Edit Account Details</legend>
    <div>
      <div class="col-lg-10">
           <form:input path="username" class="form-control" id="usernameid" placeholder="User Name" />
           <form:input path="identificationid" class="form-control" id="ididentificationid" placeholder="Identification ID(SSN/PassportNo)" />
      </div>
    </div>
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <button class="btn btn-default">Cancel</button>
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
  </fieldset>
   </form:form>
   <div>
		<table class="table table-striped table-hover ">
			<thead>
				<tr>
					<th>#</th>
					<th>Amount Involved</th>
					<th>Transaction Type</th>
					<th>To Account</th>
					<th>Approved</th>
				</tr>
			</thead>
			<c:if test="${not empty transList}">
			<tbody>
			<c:forEach items="${transList}" var="i">
				<tr>
					<td>1</td>
					<td><c:out value="${i.amtInvolved}"/></td>
					<td><c:out value="${i.toAccountno}"/></td>
					<td><c:out value="${i.status}"/></td>
					<td><c:out value="${i.transactionTypes}"/></td>
				</tr>
			</c:forEach>
			</tbody>
			</c:if>
		</table>
	</div>
   
</body>
</html>