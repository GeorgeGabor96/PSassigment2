<html>
<body>
<h2>Cine esti?</h2>

<form action="pickAdmin">
	<input type = "submit" value = "Admin">
</form>

<form action="pickUser">
	<input type = "submit" value = "User">
</form>

<% for (int i=1; i<4; i++) { %>
    <p>This number is <%= i %>.</p>
	<input type = "text" name = <%= i%>>
<% } %>

</body>
</html>
