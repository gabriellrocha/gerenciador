<%
	String campoDuplicado = (String) request.getAttribute("campoDuplicado");

	String mensagem = "";
	if(campoDuplicado != null){
		
		if(campoDuplicado.equals("username")){
			mensagem = "Este usuário já está cadastrado. Por favor, escolha outro";
		} else{
			mensagem = "O email já está cadastrado. Por favor, escolha outro";
		}	
	}
%>

<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cadastro</title>
	<style>
	    body {
	        font-family: Arial, sans-serif;
	        margin: 0;
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
	    
	    .div-error h4 {
	    	color:  rgb(227, 68, 50);
	    }
	    
	    
	</style>
</head>
<body>
     <div class="container">
       <h2>Cadastro</h2>
       
       <%if (campoDuplicado != null) { %>
		<div class="div-error">
        	<h4>Houve um problema</h4>
        	<p><%=mensagem%></p>
    	</div>  	
	<%
		}
	%>
       <form id="registerForm" action="home?path=cadastrar" method="post">
           <input type="text" name="name" placeholder="Nome" required><br>
           <input type="text" name="surname" placeholder="Sobrenome" required><br>
           <input type="email" name="email" placeholder="E-mail" required><br>
           <input type="text" name="username" placeholder="Usuário" required><br>
           <input type="password" name="password" placeholder="Senha" required><br>
           <button type="submit">Cadastrar</button>
           <p>Já tem uma conta? <a href="home?path=signIn" style="cursor: pointer; text-decoration: none">Faça login</a></p>
       </form>
    </div>
    
</body>