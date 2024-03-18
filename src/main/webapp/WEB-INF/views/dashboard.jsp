<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.ArrayList, br.com.faculdade.models.Tarefa, java.time.format.DateTimeFormatter"%>	
<%
	ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) request.getAttribute("listaTarefas");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="sytlesheet" href="/style.css">
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
	
	<style>
	@import
	url('https://fonts.googleapis.com/css2?family=Anta&family=Homemade+Apple&family=Rampart+One&display=swap')
	 @charset "ISO-8859-1";
	
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
		font-family: "Rampart One", sans-serif;
	}
	
	body {
	
	}
	
	main {
		background-color: #fff;
		border-radius: 8px;
		padding: 20px;
		width: 90%;
		margin: 40px auto;
		box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	}
	
	.add-form {
		display: flex;
		margin-bottom: 50px;
		gap: 15px;
		width: 100%;
	}
	
	input {
		width: 100%;
		flex: 1;
		padding: 15px;
		border: 1px solid #ddd;
		border-radius: 5px;
		outline: none;
		font-size: 1rem;
		font-weight: 600;
	}
	
	button[type=submit] {
		background-color: #0099ff;
		height: 50px;
		width: 50px;
		border: none;
		border-radius: 5px;
		color: #fff;
		font-size: 1.7rem;
		display: flex;
		align-items: center;
		justify-content: center;
		font-weight: 400;
		cursor: pointer;
	}
	
	table {
		border-collapse: collapse;
		width: 100%;
	}
	
	td, th {
		padding: 10px 15px;
		border: 1px solid #ddd;
		text-align: center;
	}
	
	td {
		color: #333;
		font-weight: 600;
	}
	
	
	tr {
		background-color: #f5f5f5;
	}
	
	select {
		width: 100%;
		border: none;
		padding: 10px;
		border-radius: 8px;
		font-weight: 600;
		text-transform: capitalize;
		background-color: #F2E7DC;
		color: #40382B;
	}
	
	select:hover {
		background-color: #ddd;
	}
	
	.btn-action {
		border: none;
		border-radius: 5px;
		padding: 5px;
		color: #fff;
		display: inline-flex;
		align-items: center;
		justify-content: center;
		cursor: pointer;
	}
	
	.btn-action:nth-child(1) {
		background-color: orange;
		margin-right: 5px;
	}
	
	.btn-action:nth-child(2) {
		background-color: #F30317;
	}
	
	td:nth-child(3), td:nth-child(4) {
	    width: 15%; /* Define a largura para status e a��es */
	}
	
	.larguraSelect{
		padding:5px;
	}
	
	@import
	url('https://fonts.googleapis.com/css2?family=Anta&display=swap')
	</style>
	
	<title>Dashboard</title>
</head>
<body>

	<main>

		<form class="add-form" id="addForm" action="home?path=tarefa&actionTask=create" method="post">
		
			<input type="text" name="descricao" placeholder="Nova Tarefa" class="input-task" id="inputTask"></input>
			
			<input type="date" name="data" class="input-date" id="inputDate" min="<%=java.time.LocalDate.now() %>"></input>
			
			<button type="submit">+</button>
		</form>

		<!-- �cone ou texto de suporte -->
		<span class="material-symbols-outlined"> support_agent </span>

		<!-- Tabela para exibir as tarefas -->
		<table id="task-table">
			<thead>
				<tr>
					<th>TAREFAS</th>
					<th>DATA</th>
					<th>STATUS</th>
					<th>OP��ES</th>
				</tr>
			</thead>
			<tbody>
				<!-- Linhas da tabela -->				
					<%
						for(Tarefa tarefa : tarefas) {		
					%>
					
					<tr>
						<td><%= tarefa.getDescricao() %></td>
						<td><%= tarefa.getData().toLocalDate().format(formatter) %></td>
						<td></td>
						<td></td>		
					</tr>
					
					<%
						}
					%>
								
			</tbody>
		</table>
	</main>
	
</body>
</html>