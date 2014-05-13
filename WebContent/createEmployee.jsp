<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro Empregado</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Cadastrar Empregado</h2>

<jsp:include page="systemMenu.jsp"/>

<br /><br />
<form action="CreateEmployee" method="post">
<fieldset>
	<legend>Dados Empregados</legend>
	Nome : <input type="text" name="name" /> <br />
	Departamento  : 
	<select name="idDepartment">
		<c:forEach items="${departments }" var="department">
			<option value="${department.id}">${department.name }</option>
		</c:forEach>
	</select>
</fieldset>
<br/> <br />
<fieldset>
	<legend>Dados Endereço</legend>
	Rua : <input type="text" name="street" /> <br />
	Nº  : <input type="text" name="number" /> <br />
	Cidade : <input type="text" name="city" /> <br />
</fieldset>
<br /><br />
<input type="submit" value="Cadastrar"/>

</form>
</body>
</html>