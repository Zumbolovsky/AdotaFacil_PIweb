<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<title>Adota Fácil</title>
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
		<form name="login" action="logins" method="post">
			<div class="form-group row">
				<h3>Login</h3>
			</div>
			<div class="form-group row">
				<h5 style="color: grey;">Forneça seu email e senha</h5>
			</div>
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-10">
					<input class="form-control" type="email" id="email" required="required"
						placeholder="fulano@mail.com" name="email">
				</div>
			</div>
			<div class="form-group row">
				<label for="pass1" class="col-sm-2 col-form-label">Senha:</label>
				<div class="col-sm-10">
					<input class="form-control" type="password" id="pass1"
						placeholder="Senha" required="required" name="pass1">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-2"></div>
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-2"></div>
				<label class="col-sm-10 col-form-label">${mensagem}</label>		
			</div>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

</body>

</html>