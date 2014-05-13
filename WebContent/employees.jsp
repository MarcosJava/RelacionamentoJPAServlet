<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Empregado</title>
<script type="text/javascript">

function excluir(id){
	
	if(confirm('Deseja excluir este empregado ?')){
		
		location.href = 'RemoveEmployee?idEmployee=' + id;
	}
}

</script>

<link rel="stylesheet" type="text/css" href="css/style.css">


</head>
<body>

<h2>Empregados</h2>
	<jsp:include page="systemMenu.jsp"/>
	
	<br /><br />

|| <a href="MenuController?cmd=createEmployee">Criar um empregado</a> ||<br />	<br />	
|| <a href="MenuController?cmd=employeePosition">Dar um cargo a um empregado</a> ||<br /><br />	


${msg} <br/><br />
<fieldset style="width: auto">
	<legend>Buscando Empregados</legend>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Departamento</th>
			<th>Rua</th>
			<th>Número</th>
			<th>Cidade</th>
			<th>Cargos</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.department.name }</td>
			<td>${employee.address.street }</td>
			<td>${employee.address.number }</td>
			<td>${employee.address.city }</td>
			<td><a href="FindEmployeePosition?idEmployee=${employee.id }">Cargos</a> </td>
			<td> <a href="UpdateEmployee?update=1&idEmployee=<c:out value="${employee.id}" />"> Editar </a> </td>
			<td> <a href="#" onclick="excluir('<c:out value="${employee.id}" />')">Excluir</a> </td>
		</tr>
		</c:forEach>	
	</table>
</fieldset>
</body>
</html>