<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Users Management</title>
	    <style>
	    .error 
	    {
	        color: #ff0000;
	        font-weight: bold;
	    }
	    #listOfUsers tr:first-child{
	        font-weight: bold;
	    }
	    </style>
	</head>
	 
	<body>
	    <h7>sfsdfsdd ${info}</h7>
	    <%-- <table id="listOfUsers" border="1">
	    <tr>
	        <td>ID</td>
	        <td>First Name</td>
	        <td>Last Name</td>
	        <td>Email</td>
	        <td>Login</td>
	      </tr>
	    <c:forEach items="${allUsers}" var="user">    
	      <tr>
	        <td>${user.us_id}</td>
	        <td>${user.usfirstname}</td>
	        <td>${user.uslastname}</td>
	        <td>${user.usemail}</td>
	        <td>${user.uslogin}</td>
	      </tr>
	    </c:forEach>
	    </table> --%>
	</body>
</html>