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

		<form name="doacao" action="doacoes" method="post">
			<div class="form-group row">
				<h3>Ajude-nos a fazer vidas mais felizes</h3>
			</div>
			<div class="form-group row">
				<h5 style="color: grey;">Os campos com (*) s�o obrigat�rios</h5>
			</div>
			<div class="form-group row">
				<label for="nome" class="col-sm-2 col-form-label">Nome:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="nome"
						placeholder="Nome completo" name="nome">
				</div>
			</div>
			<div class="form-group row">
				<label for="rg" class="col-sm-2 col-form-label">RG:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="rg" placeholder="RG"
						name="rg">
				</div>
			</div>
			<div class="form-group row">
				<label for="cpf" class="col-sm-2 col-form-label">CPF/CNPJ*:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cpf" required="required"
						placeholder="CPF/CNPJ" name="cpf" maxlength="18"> <small
						id="passwordHelpBlock" class="form-text text-muted"> Insira
						 11 d�gitos para o CPF ou 18 para o CNPJ. </small>
				</div>
			</div>
			<div class="form-group row">
				<label for="end" class="col-sm-2 col-form-label">Endere�o*:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="end"
						placeholder="Endere�o" required="required" name="end">
				</div>
			</div>
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-10">
					<input class="form-control" type="email" id="email"
						placeholder="fulano@mail.com" name="email">
				</div>
			</div>
			<div class="form-group row">
				<label for="valor" class="col-sm-2 col-form-label">Valor
					da doa��o*:</label>
				<div class="col-sm-10">
					<input class="form-control" type="number" id="valor" min="0.01"
						step="0.01" placeholder="0,00" required="required" name="valor">
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