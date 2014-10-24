<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<title>Sparky</title>  
</head>  
<body>  
 <center>  
    
  
  <div style="border: 1px solid black; width: 300px; padding-top: 10px;">  
     
 Please enter your username and password to login !   
 <span  
    style="color: red"></span>   
  
   <form:form method="post" action="userLogin" commandName="users" modelAttribute="users">  
    <table>  
     <tr>  
      <td>Username:</td>  
      <td><form:input path="userId" /></td>  
     </tr>  
     <tr>  
      <td>Password:</td>  
      <td><form:input path="password" /></td>  
     </tr>  
     <tr>  
      <td> </td>  
      <td><input type="submit" /></td>  
     </tr>  
    </table>  
   </form:form>  
  </div>  
 </center>  
  
</body>  
</html>  