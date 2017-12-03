<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>

        <title>Adota F�cil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="imagens/icon.ico">
        <link rel="stylesheet" type="text/css" href="/PI/estilos.css">
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

            <h1 class="display-3">Informa��es</h1>

            <hr/>

            <div class="row" style="margin-top: 25px;">
                <h5>Merch</h5>
            </div>
            <div class="row" style="margin-top: 25px;">
                <p>J� � cadastrado? Fique por dentro de nossos produtos em nossa 
                    <a href="produtosU.jsp">loja</a>. Estamos sempre atualizando o estoque
                    e os itens ent�o n�o se esque�a de dar uma olhada no que temos a 
                    oferecer!</p>
            </div>
            <div class="row" style="margin-top: 25px;">
                <h5>Doa��es</h5>
            </div>
            <div class="row" style="margin-top: 25px;">
                <p>Caso deseje ajudar nossa causa, por�m n�o queira criar um cadastro,
                    possuimos uma �rea para <a href="doacaoU.jsp">doa��es</a> que podem ser
                    feitas anonimamente (com os dados m�nimos) ou com as informa��es de 
                    seu usu�rio cadastrado.</p>
            </div>
            <div class="row" style="margin-top: 25px;">
                <h5>Feedback</h5>
            </div>
            <div class="row" style="margin-top: 25px;">
                <p>Para aqueles que dejam enviar uma sugest�o, cr�tica ou feedback a 
                    respeito de nosso site, � so acessar a se��o de 
                    <a href="contatoU.jsp">contato</a>. Estaremos revisando as mensagens
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