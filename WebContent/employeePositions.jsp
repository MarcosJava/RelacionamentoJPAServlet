<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cargos</title>

<script type="text/javascript">
function excluir(idEmployee,idPosition){
	if(confirm('Você realmente quer excluir o cargo do empregado ?')){
		location.href="RemoveEmployeePosition?idEmployee="+idEmployee+"&idPosition="+idPosition;	
	}
}

</script>
</head>
<body>
<h3>Buscando Cargo</h3>	
	
	<jsp:include page="systemMenu.jsp"/>
	
<br />
<br />
<fieldset style="width: 400px">
	<legend>Cargos do Empregado  ${employee}</legend>
	<table>
		<tr>
			<th>Cargo</th>
			<th>Admissão do Cargo </th>
			<th>Excluir</th>
		</tr>
		<c:forEach items="${employeePositions}" var="employeePosition">
		<tr>
			<td>${employeePosition.position.name} </td>
			<td>
				<fmt:formatDate value="${employeePosition.admissionPosition}" pattern="dd-MM-yyyy"/>
			</td>
			<td><a href="#" onclick="excluir('${employeePosition.employee.id}','${employeePosition.position.id }')">
					Excluir
				</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</fieldset>
</body>
</html>