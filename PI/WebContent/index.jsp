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
<style type="text/css">

.carousel-item img {
	vertical-align: middle;
	display: inline-block;
	max-height: 100%; /* <-- Set maximum height to 100% of its parent */
	max-width: 100%; /* <-- Set maximum width to 100% of its parent */
}

.carousel-item .centerer {
	display: inline-block;
	vertical-align: middle;
	height: 100%;
}
</style>

</head>

<body>
	<section class="cabecalho">
		<c:import url="http://localhost:8080/PI/cabecalho.jsp" />
	</section>

	<h3 style="padding-top: 10px; text-align: center; margin: 20px; font-weight: bold;">${mensagem}</h3>

	<div id="conteudo" style="margin: 50px;">
		<div class="row">
			<div id="carouselExampleControls" class="carousel slide col-sm-12"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="centerer"></div>
						<img class="d-block w-100" src="/PI/imagens/mao.jpg" alt="First slide">
					</div>
					<div class="carousel-item">
						<div class="centerer"></div>
						<img class="d-block w-100" src="/PI/imagens/best.jpg"
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleControls"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleControls"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

			<div class="col-sm-12" style="margin-top: 25px;">
				<div class="jumbotron">
					<h1 class="display-3">Bem vindo!</h1>
					<p class="lead">O nosso site procura promover, compartilhar e
						disseminar a participa��o em processos adotivos, e ajudar a
						crian�as das mais diversas maneiras.</p>
					<hr class="my-4">
					<p>Contamos com uma �rea dedicada a nossos produtos, para os
						cadastrados e doa��es (com a op��o do anonimato) para
						contribui��es financeiras. Tamb�m contamos com uma �rea para
						contato, para que os nossos usu�rios possam nos fornecer feedback!</p>
					<p class="lead">
						<a class="btn btn-primary btn-lg" href="/PI/info.jsp" role="button">Conhe�a mais!</a>
					</p>
				</div>
			</div>
		</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>


</body>

</html>