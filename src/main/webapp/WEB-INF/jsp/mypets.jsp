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
	<a href="/home">Home</a><br />
	<a href="/home/mypets">My Pets</a><br />
	<a href="/home/myappointments">My Appointments</a><br />
	<a href="/home/myappointments/new">Get New Appointment</a><br />
	<form action="logout" method="post">
		<input type="submit" value="Logout"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}">
	</form><br />
	<a href="/home/mypets/new">Add New Pet</a><br />
	<a href="/home/mypets/updatepet">Update Pet</a><br />
	<a href="/home/mypets/deletepet">Delete Pet</a><br />
	<table>
		<thead>
			<tr style="font-weight: bold;" bgcolor="lightblue">
				<td>ID</td>
				<td>Name</td>
				<td>Birth Date</td>
			</tr>
		</thead>
		<c:forEach items="${mypets}" var="pet" varStatus="status">
			<tr bgcolor=${status.index % 2 == 0?'white':'lightgray'}>
				<td>${pet.id}</td>
				<td>${pet.name}</td>
				<td>${pet.birthDate}</td>
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