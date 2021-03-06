<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/vet">Home</a><br />
	<a href="/vet/allappointments">All Appointments</a><br />
	<form action="logout" method="post">
		<input type="submit" value="Logout"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}">
	</form><br />
	<table>
		<thead>
			<tr style="font-weight: bold;" bgcolor="lightblue">
				<td>ID</td>
				<td>Date</td>
				<td>Pet ID</td>
				<td>User Email</td>
			</tr>
		</thead>
		<c:forEach items="${allappointments}" var="appointment" varStatus="status">
			<tr bgcolor=${status.index % 2 == 0?'white':'lightgray'}>
				<td>${appointment.id}</td>
				<td>${appointment.date}</td>
				<td>${appointment.petId}</td>
				<td>${appointment.userEmail}</td>
			</tr>
		</c:forEach>
	</table>
		<c:if test="${not empty message}">
			<div style="color: blue;">
			${message}
			</div>
		</c:if>
</body>
</html>