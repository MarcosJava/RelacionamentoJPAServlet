<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Departamentos</title>

<script type="text/javascript">

function excluir(id){
	
	if(confirm('Deseja excluir este departamento ?')){
		
		location.href = 'RemoveDepartment?idDepartment=' + id;
	}
}

</script>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<h2>Departamento</h2>

	<jsp:include page="systemMenu.jsp"/>

<br />
	<fieldset style="width: 400px">
		<legend>Cadastro ou Editor de Departamentos</legend>
			<form action="CreateUpdateDepartment" method="post">
			Nome<input type="text" name="name" value="${name}" /><br />
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="cmd" value="createDepartment" />
			<input type="submit" value="Cadastrar/Editar"/>
			</form>
	</fieldset>
	
	<fieldset style="width: 400px">
		<legend>Buscando Departamentos</legend>
			
				<table border="1">
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Editar</th>
						<th>Excluir</th>
					</tr>
					<c:forEach items="${departments}" var="department">
					<tr>
						<td><c:out value="${department.id}" /></td>
						<td><c:out value="${department.name}" /></td> 
						<td> <a href="CreateUpdateDepartment?cmd=updateDepartment&idDepartment=<c:out value="${department.id}" />"> Editar </a> </td>
						<td> <a href="#" onclick="excluir('<c:out value="${department.id}" />')">Excluir</a> </td>
					</tr>
					</c:forEach>
				</table>
				
	</fieldset>
	

</body>
</html>