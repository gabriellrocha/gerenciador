<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.ArrayList, br.com.faculdade.models.Tarefa, java.time.format.DateTimeFormatter"%>
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
	width: 15%; /* Define a largura para status e ações */
}

.larguraSelect {
	padding: 5px;
}

.options-button {
	position: fixed;
	top: 20px;
	right: 30px;
	background-color: #0099ff;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	width: 65px;
	padding: 5px;
}

.options-dropdown {
	position: fixed;
	top: 50px;
	right: 20px;
	display: none;
	background-color: #fff;
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
}

#validationMessage{
	text-align: center;

}
@import
url('https://fonts.googleapis.com/css2?family=Anta&display=swap')
</style>

<title>Dashboard</title>
</head>
<body>

	<button class="options-button" id="optionsButton">Opções</button>

	<div class="options-dropdown" id="optionsDropdown">
		<button onclick="logout()">
			<span class="material-symbols-outlined"> logout </span>
		</button>
		<button onclick="excluirConta()">Excluir Conta</button>
	</div>

	<main>

		<form class="add-form" id="addForm"
			action="home?path=tarefa&actionTask=create" method="post"
			onsubmit="return validateForm()">

			<input type="text" name="descricao" placeholder="Nova Tarefa"
				class="input-task" id="inputTask"></input> <input type="date"
				name="data" class="input-date" id="inputDate"
				min="<%=java.time.LocalDate.now()%>"></input>


			<button type="submit">+</button>

			

		</form>
		<div id="validationMessage" style="display: none; color: red;">Por favor, preencha todos os campos.</div>
		
		
		<!-- Ícone ou texto de suporte -->
		<span class="material-symbols-outlined"> support_agent </span>

		<!-- Tabela para exibir as tarefas -->
		<table id="task-table">
			<thead>
				<tr>
					<th>TAREFAS</th>
					<th>DATA</th>
					<th>STATUS</th>
					<th>OPÇÕES</th>
				</tr>
			</thead>
			<tbody>
				<!-- Linhas da tabela -->
				<%
				for (Tarefa tarefa : tarefas) {
				%>

				<tr>
					<td><%=tarefa.getDescricao()%></td>
					<td><%=tarefa.getData().toLocalDate().format(formatter)%></td>
					<td></td>
					<td></td>
				</tr>

				<%
				}
				%>

			</tbody>
		</table>
	</main>

	<script>
		// função do botão opções.
		document.addEventListener("DOMContentLoaded", function() {
			var optionsButton = document.getElementById("optionsButton");
			var optionsDropdown = document.getElementById("optionsDropdown");

			optionsButton.addEventListener("click", function(event) {
				if (optionsDropdown.style.display === "block") {
					optionsDropdown.style.display = "none";
				} else {
					optionsDropdown.style.display = "block";
				}
				event.stopPropagation();
			});

			document.addEventListener("click", function(event) {
				if (event.target !== optionsButton
						&& !optionsDropdown.contains(event.target)) {
					optionsDropdown.style.display = "none";
				}
			});
		});
		
		 function validateForm() {
		        var descricao = document.getElementById("inputTask").value.trim();
		        var data = document.getElementById("inputDate").value.trim();

		        // Verifica se os campos estão vazios
		        if (descricao === "" || data === "") {
		            // Exibe a mensagem de validação
		            document.getElementById("validationMessage").style.display = "block";
		            return false; // Impede o envio do formulário
		        }

		        // Se os campos não estiverem vazios, o formulário será enviado
		        return true;
		    }
		
		

		
		function logout() {
			// Lógica de logout aqui...
			console.log("Logout executado");
		}

		function excluirConta() {
			// Lógica de exclusão de conta aqui...
			console.log("Excluir conta executado");
		}
	</script>

</body>
</html>