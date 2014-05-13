<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cargos</title>

<script type="text/javascript">

function excluir(id){
	if(confirm('Deseja excluir este Cargo ?')){
			location.href='RemovePosition?idPosition='+id;
		}
}

</script>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

<h2>Cargos</h2>

<jsp:include page="systemMenu.jsp"/>

<br/><br/> ${msg}

<br />
<fieldset>
	<legend>Criando/Editando Cargo</legend>
	<form action="CreateUpdatePosition" method="post">
		Nome: <input type="text" name="name" value="${name}" /><br />
		<input type="hidden" name="cmd" value="createPosition" />
		<input	type="hidden" name="id" value="${id}"/>
		<input type="submit" value="Confirmar" />
	</form>
</fieldset>
<br /><br />
<form action=""></form>
<fieldset>
	<legend>Buscando Cargo</legend>
	<table>
		<tr>
			<th>ID </th>
			<th>Nome </th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		<c:forEach items="${positions}" var="position">
		<tr>
			<td><c:out value="${position.id}" /> </td>
			<td><c:out value="${position.name}" /></td>
			<td>
				<a href="CreateUpdatePosition?cmd=updatePosition&idPosition=<c:out value="${position.id}"/>">
				 	Editar 
				</a> 
			</td> 
			<td>
				<a href="#" onclick="excluir('<c:out value="${position.id}"/>')">
					Excluir
				</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</fieldset>



</body>
</html>