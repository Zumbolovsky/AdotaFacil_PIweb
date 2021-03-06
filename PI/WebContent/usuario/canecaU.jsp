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
		<c:import url="cabecalhoU.jsp" />
	</section>


	<div id="conteudo" style="margin: 50px;">

		<div class="row" style="min-height: 160px">
			<div class="col-sm-5" style="margin-top: 30px">
				<img id="imagem" src="/PI/imagens/caneca.jpg" alt="Caneca" style="width: inherit; height: inherit;">
			</div>

			<div class="col-sm-6" id="descricao">
				<h3 class="col-sm-12">Caneca</h3>
				<p class="col-sm-12">Caneca Adota F�cil</p>
				<hr style="min-height: 2px;"/>
				
				<label class="col-sm-12">Pre�o:</label>
				<h4 class="col-sm-12" style="min-height: 20px;">R$ 49,00</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-5"></div>
			<button class="btn btn-primary col-sm-6" style="margin: 10px; margin-left: 20px; width: 100%; position: relative; bottom: 0;">Adicionar ao carrinho</button>
		</div>
		
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

</body>

</html>