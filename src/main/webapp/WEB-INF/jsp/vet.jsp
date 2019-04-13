<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello vet<br />
	<a href="/vet">Home</a><br />
	<a href="/vet/allappointments">All Appointments</a><br />
	<form action="logout" method="post">
		<input type="submit" value="Logout"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}">
	</form><br />
	
</body>
</html>