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

            <div class="list-group">
                <c:forEach var="produto" items="${produtos}">
                    <div class="ld-flex w-100 justify-content-between">
                        <h5 class="mb-1">${produto.nome}</h5> 
                    </div>
                    <p class="mb-1">
                        ${produto.descricao}
                    </p>
                    <small class="text-muted">Pre�o Unit�rio: R$${produto.preco}</small>    
                </c:forEach>
            </div>

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

</body>

</html>