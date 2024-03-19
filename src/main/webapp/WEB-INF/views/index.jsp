<%
	String mensagem = (String) request.getAttribute("errorMensagem");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Página Inicial</title>
	<style>
	    body {
	        margin: 0;
	        font-family: Arial, sans-serif;
	        padding: 0;
	        display: flex;
	        justify-content: center;
	        align-items: center;
	        height: 100vh;
	        background-color: rgb(254, 253, 252);
	        
	    }
	
	    .container {
	        background-color: rgb(255, 239, 229);
	        padding: 20px;
	        border-radius: 8px;
	        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	        text-align: center;
	    }
	
	    .hidden {
	        display: none;
	    }
	
	    h2 {
	        color: rgb(227, 68, 50);
	    }
	
	    input[type="text"],
	    input[type="password"],
	    input[type="email"],
	    button {
	        width: 100%;
	        padding: 10px;
	        margin: 8px 0;
	        border: 1px solid #ccc;
	        border-radius: 4px;
	        box-sizing: border-box;
	    }
	
	    button {
	        background-color: rgb(227, 68, 50);
	        color: white;
	        cursor: pointer;
	    }
	
	    button:hover {
	        background-color: rgb(207, 53, 32, 1);
	    }
	
	    p {
	        margin: 10px 0;
	        color: #555;
	    }
	    
	    .div-error {
	    	border: 2px solid black;
	    	padding: 20px;
	    	padding-top: 15px;
	    	padding-left: 20px;
	    	padding-right: 20px;
	    	padding-bottom: 15px;
	    }
	    
	    .div-error p {
	    	text-decoration: none;
	    	font-size: 13px;
	    }    
	</style>
</head>
<body>
	
    <div class="container">
    
        <h2>Login</h2>
        <%if (mensagem != null) { %>
		<div class="div-error">
        	<h4 style="color: red;">Houve um problema</h4>
        	<p><%=mensagem%></p>
    	</div>	
		<% } %>
		
        <form id="loginForm" action="home?path=login" method="post">
            <input type="text" name="username" placeholder="Usuário" required><br>
            <input type="password" name="password" placeholder="Senha" required><br>
            <button type="submit">Entrar</button>
            <p>Não tem uma conta? <a href="home?path=signUp" style="cursor: pointer; text-decoration: none">Cadastre-se</a></p>
        </form>
    </div>

</body>
</html>
