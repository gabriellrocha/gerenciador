<%@page import="br.com.faculdade.models.dto.TarefaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.ArrayList, br.com.faculdade.models.Tarefa, java.time.format.DateTimeFormatter"%>
<%
ArrayList<TarefaDTO> tarefas = (ArrayList<TarefaDTO>) request.getAttribute("listaTarefas");
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String nome = (String) request.getSession().getAttribute("nome");
%>

<html lang="pt-BR">
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
			background-color: rgb(254, 253, 252);
		}
		
		main {
			background-color: rgb(255, 239, 229);
			border-radius: 8px;
			margin: 80px auto auto auto;
			padding: 20px;
			width: 90%;
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
			background-color: rgb(227, 68, 50);
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
			color: rgb(227, 68, 50);
			padding: 10px 15px;
			border: 1px solid #ddd;
			text-align: center;
		}
		
		td {
			color: #333;
			font-weight: 600;
		}
		
		tr {
			background-color: rgb(255, 255, 255);
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
			width: 15%; /* Define a largura para status e ações */
		}
		
		.larguraSelect {
			padding: 5px;
		}
		
		.options-button {
			position: fixed;
			top: 20px;
			right: 30px;
			background-color: rgb(255, 239, 229);
			color: rgb(227, 68, 50);
			padding: 10px 20px;
			border: none;
			border-radius: 10px;
			cursor: pointer;
			width: 120px;
			display: inline-flex;
		}
		
		.options-button:hover {
			background-color: rgb(227, 68, 50);
			color: rgb(255, 239, 229);
		}
		
		.options-dropdown {
			position: fixed;
			top: 50px;
			right: 20px;
			display: none;
			background-color: rgb(255, 239, 229);
			border: 1px solid #ddd;
			border-radius: 5px;
			box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
		}
		
		.options-dropdown button {
			display: block;
			width: 100%;
			padding: 10px 20px;
			border: none;
			background-color: transparent;
			cursor: pointer;
			text-align: left;
			height: 50px;
		}
		
		.options-dropdown button:hover {
			background-color: rgb(227, 68, 50);
			color: rgb(255, 239, 229);
		}
		
		.imagemDoBotao {
			text-align: left;
		}
		
		.user-info {
			margin: 5px;
			padding-left: 6px;
		}
		
		.editar {
			background-color: rgb(227, 68, 50);
			color: rgb(255, 239, 229);
			display: inline-block;
		    width: 30px; 
		    height: 30px; 
		    text-decoration: none; 
		    border-radius: 5px; 
		    border: none; 
		    text-align: center; 
		    line-height: 30px; 
		}
		
		.editar:hover {
		    background-color:rgb(255, 239, 229); ; /* Cor de fundo ao passar o mouse */
		    color:rgb(227, 68, 50); ; /* Cor do texto ao passar o mouse */
		}
		
		.editar .material-symbols-outlined {
		    
		   padding-top: 2px;
		}	
	</style>

	<title>Dashboard</title>
</head>
<body>

	<button class="options-button" id="optionsButton"
		title="Clique para ver as opções">

		<div class="imagemDoBotao">
			<span class="material-symbols-outlined"> account_circle </span>
		</div>
		<p class="user-info"><%=nome%></p>
	</button>

	<div class="options-dropdown" id="optionsDropdown">

		<a href="home?path=logout" title="Logout">
			<button>
				<span class="material-symbols-outlined"> logout </span>
			</button>
		</a>
		<a href="home?path=deletarConta" title="Deletar Conta" onclick="return confirmarExclusao();">
			<button>
				<span class="material-symbols-outlined"> delete_forever </span>
			</button>
		</a>

	</div>

	<main>

		<form class="add-form" id="addForm" action="home?path=tarefa&actionTask=create" method="post" onsubmit= "return validarForm()">

			<input type="text" maxlength="50" name="descricao" placeholder="Nova Tarefa" class="input-task" id="inputTask"/>

			<input type="date" name="data" id="inputDate" min="<%=java.time.LocalDate.now()%>"/>

			<button type="submit">+</button>
			
		</form>

		<!-- Tabela para exibir as tarefas -->
		<table id="task-table">
			<thead>
				<tr>
					<th>DESCRIÇÃO</th>
					<th>DATA</th>
					<th>STATUS</th>
					<th>OPÇÕES</th>
				</tr>
			</thead>
			
			<tbody>
				<!-- Linhas da tabela -->
				<%
				for (TarefaDTO tarefa : tarefas) {				
				%>
				
				<tr>
					<td><%=tarefa.getDescricao()%></td>
					<td><%=tarefa.getData().toLocalDate().format(formatter)%></td>
					<td><%=tarefa.getStatus().toString()%></td>
					<td>
						<a href="home?path=tarefa&actionTask=read&id=<%=tarefa.getId()%>" class="editar" title="Editar">
							 <span class="material-symbols-outlined">edit</span>
						</a>
						
						<a href="home?path=tarefa&actionTask=delete&id=<%=tarefa.getId()%>" class="editar" title="Deletar">
							<span class="material-symbols-outlined">delete</span>
						</a>
					</td>
				</tr>

				<%
				}
				%>

			</tbody>
		</table>
	</main>

	<script type="text/javascript">
	
		function validarForm() {
			var descricao = document.getElementById("inputTask").value;
			var data = document.getElementById("inputDate").value;

			if (descricao.trim() === "" || data === "") {
				alert("Por favor, preencha todos os campos.");
				return false;
			}
			return true;
		}
		
		function confirmarExclusao() {
            var confirmacao = confirm("Tem certeza de que deseja excluir sua conta permanentemente? Esta ação não pode ser desfeita!");
           
            if (confirmacao) {
                window.location.href = "home?path=deletarConta";
            }
            
            return false;
        }

		document.addEventListener("DOMContentLoaded", function() {
			var optionsButton = document.getElementById("optionsButton");
			var optionsDropdown = document.getElementById("optionsDropdown");

			optionsButton.addEventListener("click", function() {
				optionsDropdown.style.display = "block";
			});

			optionsDropdown.addEventListener("mouseover", function() {
				optionsDropdown.style.display = "block";
			});

			optionsButton.addEventListener("mouseouver", function() {
				optionsDropdown.style.display = "none";
			});

			optionsDropdown.addEventListener("mouseout", function() {
				optionsDropdown.style.display = "none";
			});
		});
	</script>

</body>
</html>