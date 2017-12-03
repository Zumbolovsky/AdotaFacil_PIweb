<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>

        <title>Adota Fácil</title>
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

            <h1 class="display-3">Informações</h1>

            <hr/>

            <div class="row" style="margin-top: 25px;">
                <h5>Merch</h5>
            </div>
            <div class="row" style="margin-top: 25px;">
                <p>Já é cadastrado? Fique por dentro de nossos produtos em nossa 
                    <a href="produtosU.jsp">loja</a>. Estamos sempre atualizando o estoque
                    e os itens então não se esqueça de dar uma olhada no que temos a 
                    oferecer!</p>
            </div>
            <div class="row" style="margin-top: 25px;">
                <h5>Doações</h5>
            </div>
            <div class="row" style="margin-top: 25px;">
                <p>Caso deseje ajudar nossa causa, porém não queira criar um cadastro,
                    possuimos uma área para <a href="doacaoU.jsp">doações</a> que podem ser
                    feitas anonimamente (com os dados mínimos) ou com as informações de 
                    seu usuário cadastrado.</p>
            </div>
            <div class="row" style="margin-top: 25px;">
                <h5>Feedback</h5>
            </div>
            <div class="row" style="margin-top: 25px;">
                <p>Para aqueles que dejam enviar uma sugestão, crítica ou feedback a 
                    respeito de nosso site, é so acessar a seção de 
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