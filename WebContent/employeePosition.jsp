<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dando Cargo</title>
</head>
<body>

<h2>Dar Cargo ao Empregado</h2>
<jsp:include page="systemMenu.jsp"/>
<br /><br />

${msg}

<fieldset>
	<legend>ATENÇÃO: Empregado pode ter mais cargos</legend>
	<form action="CreateEmployeePosition">
		Escolha um Empregado :
		<select name="idEmployee">
			<c:forEach items="${employees }" var="employee">
			<option value="${employee.id}"> ${employee.name}</option>
			</c:forEach>
		</select>
		<br /><br />
		
		Escolha um Cargo:
		<select name="idPosition">
			<c:forEach items="${positions }" var="position">
			<option value="${position.id}"> ${position.name}</option>
			</c:forEach>
		</select>
		<br /><br />
		
		A data de Admissão ao Cargo (dd/mm/aaaa):
		<input type="text" name="admissionPosition"/><br /><br />
		
		<input type="submit" value="Confirmar" />		
	</form>
</fieldset>

</body>
</html>