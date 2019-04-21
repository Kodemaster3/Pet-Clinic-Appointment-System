<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/home">Home</a><br />
	<a href="/home/mypets">My Pets</a><br />
	<a href="/home/myappointments">My Appointments</a><br />
	<a href="/home/myappointments/new">Get New Appointment</a><br />
	<form action="logout" method="post">
		<input type="submit" value="Logout"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}">
	</form><br />
	<form:form modelAttribute="pet" method="post">
		Name:<form:input path="name"/>
		<form:errors path="name" cssStyle="color:red"/>
		<br/>
		Birth Date:<form:input path="birthDate"/>
		<form:errors path="birthDate" cssStyle="color:red"/>
		<br/>
		<form:button name="submit">Create</form:button>
	</form:form>
</body>
</html>