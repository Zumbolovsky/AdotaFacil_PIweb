<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<title>Adota F�cil</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="imagens/icon.ico">
<link rel="stylesheet" type="text/css" href="estilos.css">
<link href="https://fonts.googleapis.com/css?family=Muli"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Space+Mono"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">

</head>

<body>
	<section class="cabecalho">
		<c:import url="cabecalho.jsp" />
	</section>

	<div id="conteudo" style="margin: 50px;">

		<div class="row">
			<h3>Como funciona?</h3>
		</div>
		<div class="row" style="margin-top: 25px;">
			<h5>Informa��es</h5>	
			<p>Para informa��es sobre como ajudar na ado��o de crian�as e jovens
			orf�os, <a href="cadastrarUsuario.jsp">fa�a parte</a> de nossa causa!
			� um simples cadastro para que possamos melhor comunicar a todos as
			informa��es concernentes a processos adotivos e os mais diversos 
			eventos.</p>
		</div>
		<div class="row" style="margin-top: 25px;">
			<h5>Merch</h5>
			<p>J� � cadastrado? Fique por dentro de nossos produtos em nossa 
			<a href="produtos.jsp">loja</a>. Estamos sempre atualizando o estoque
			e os itens ent�o n�o se esque�a de dar uma olhada no que temos a 
			oferecer!</p>
		</div>
		<div class="row" style="margin-top: 25px;">
			<h5>Doa��es</h5>
			<p>Caso deseje ajudar nossa causa, por�m n�o queira criar um cadastro,
			possuimos uma �rea para <a href="doacao.jsp">doa��es</a> que podem ser
			feitas anonimamente (com os dados m�nimos) ou com as informa��es de 
			seu usu�rio cadastrado.</p>
		</div>
		<div class="row" style="margin-top: 25px;">
			<h5>Feedback</h5>
			<p>Para aqueles que dejam enviar uma sugest�o, cr�tica ou feedback a 
			respeito de nosso site, � so acessar a se��o de 
			<a href="contato.jsp">contato</a>. Estaremos revisando as mensagens
			frequentemente para melhorar nossa proposta e contribuir com nossa
			causa.</p>
		</div>
		
		

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

</body>

</html>