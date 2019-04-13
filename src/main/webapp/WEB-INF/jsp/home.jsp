<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index page</h1>
	Hello user<br />
	<a href="/home">Home</a><br />
	<a href="/home/mypets">My Pets</a><br />
	<a href="/home/myappointments">My Appointments</a><br />
	<a href="/home/myappointments/new">Get New Appointment</a><br />
	<form action="logout" method="post">
		<input type="submit" value="Logout"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</body>
</html>