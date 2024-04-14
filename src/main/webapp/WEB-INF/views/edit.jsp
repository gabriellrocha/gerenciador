<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="br.com.faculdade.models.dto.TarefaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<meta charset="ISO-8859-1">

<%
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	TarefaDTO dto = (TarefaDTO) request.getAttribute("dto");
	
%>

<html>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jersey+10&family=Oswald:wght@200..700&display=swap" rel="stylesheet">
<style>
 body {
        display: flex;
        justify-content: center; /* Centraliza horizontalmente */
        align-items: center; /* Centraliza verticalmente */
        height: 100vh; /* Altura total da viewport */
        margin: 0; /* Remove margens padrão */
        padding: 0; /* Remove preenchimentos padrão */
    }

    form {
        width: 50%; /* Largura do formulário */
        height: 50%;
        background-color: rgb(255, 239, 229); 
        display: flex; /* Faz com que os elementos dentro do form se comportem como um flex container */
    	justify-content: center; /* Centraliza os elementos horizontalmente */
    	border-radius: 40px;
    	box-shadow: 10px 10px 10px rgb(227, 68, 50) ;
        
    }

    table {
        width: 90%; /* Largura da tabela */
        height: 50%;
        background-color: white;
        border-radius: 8px;
        padding: 20px;
        margin-top: 10%;
        
    }

    th, td {
        padding: 25px; /* Preenchimento interno */
        text-align: center; /* Alinhamento do texto à esquerda */
        color:rgb(227, 68, 50);
        font-size: 30px;
        font-family: "Oswald", sans-serif;
        
       
    }

    button[type="submit"] {
        margin-top: 5px; /* Espaçamento superior para o botão */
    }
    
    input[name="descricao"],
	input[name="data"],
	select[name="status"] {
    width: 100%; /* Definir largura total */
    padding: 20px; /* Espaçamento interno */    
    margin: 5px  ; /* Espaçamento inferior */
    border: 1px solid grey; /* Borda */
    border-radius: 5px; /* Raio da borda */
     font-weight: bold; /* Adiciona negrito ao conteúdo dos campos */
}

.botaoSalvar{
	background-color: rgb(227, 68, 50);
    width: 60px; 
    height: 60px; 
    border: none; 
    border-radius: 10px; 
    display: flex; 
    align-items: center;
    justify-content: center; 
    cursor: pointer; 
    color: #fff; 
    font-weight: bold; 
    text-transform: uppercase; /* Transforme o texto em maiúsculas *

}

.botaoSalvar:hover{
	background-color: white;

}





    
</style>
<head>
<meta charset="ISO-8859-1">
<title>Editando a tarefa</title>
</head>
<body>
	

	<form action="home?path=tarefa&actionTask=update" method="post">

		<table>
			
		
			<thead>
			
				<tr>
					
					<th>TAREFA</th>
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
						<td><input type="date" name="data" min="<%=java.time.LocalDate.now().toString() %>" value="<%= dto.getData().toLocalDate().format(formatter) %>"></td>
						
						<td>
							<select name="status">
								<option><%=status1%></option>
								<option><%=status2%></option>
								
							</select>
							
							 <td> <!-- Célula vazia para separar o botão Salvar -->
							 <button type="submit" class="botaoSalvar" title="Salvar edição" >salvar</button>
                        
                    </td>
						</td>
					</tr>
				</tbody>		
		</table>
		
	
</body>
</html>