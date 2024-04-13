<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="br.com.faculdade.models.dto.TarefaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	TarefaDTO dto = (TarefaDTO) request.getAttribute("dto");
	
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Editar Tarefa</h1>
	<form action="home?path=tarefa&actionTask=update" method="post">

		<table>
			<thead>
				<tr>
					<th>TAREFAS</th>
					<th>DATA</th>
					<th>STATUS</th>
				</tr>
			</thead>
				<tbody>
				<%
					String status1 = dto.getStatus().toString();
								String status2 = "CONCLUIDO";
								if(status1.equalsIgnoreCase("CONCLUIDO")){
									status2 = "PENDENTE";		
								}
				%>	
					
					<tr>
						<td hidden=""><input name="id" value="<%= dto.getId() %>"></input></td>
						<td><input name="descricao" value="<%= dto.getDescricao() %>"></td>
						<td><input type="date" name="data" min="<%=java.time.LocalDate.now() %> value="<%= dto.getData().toLocalDate().format(formatter) %>"></td>
						<td>
							<select name="status">
								<option><%=status1%></option>
								<option><%=status2%></option>
							</select>
						</td>
					</tr>
				</tbody>		
		</table>
		<button type="submit" >Salvar</button>
	</form>
	
</body>
</html>