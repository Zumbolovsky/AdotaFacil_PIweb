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
            <c:import url="cabecalhoU.jsp" />
        </section>

        <div id="conteudo" style="margin: 50px;">

            <h1 class="display-3">Carrinho</h1>

            <h3 style="padding-top: 10px; text-align: center; margin: 20px; font-weight: bold; margin-top: 5%">${mensagem}</h3>

            <form action="quantidades" method="get">
                <div class="list-group">
                    <c:forEach var="produto" items="${produtos}">
                        <div class="list-group-item row">
                            <div class="col-sm-4">
                                <div class="ld-flex w-100 justify-content-between">
                                    <h5 class="mb-1">${produto.nome}</h5> 
                                </div>
                                <p class="mb-1">
                                    ${produto.descricao}
                                </p>
                                <small class="text-muted">Preço Unitário: R$${produto.preco}</small>
                            </div>
                            <hr/>
                            <div style="margin-left: 10px;">
                                <label>Quantidade:</label>
                                <input type="number" name="${produto.nome}" step="1" min="1" value="${produto.quantidade}">
                            </div>
                        </div>
                    </c:forEach>
                </div> 
                <div class="row">
                    <div class="col-sm-8"></div>
                    <div class="col-sm-4" style="padding-left: 30px; padding-right: 30px; padding-top: 30px;">
                        ${botaoquantidade}
                    </div>
                </div>
            </form>

            <div class="row">
                <h5 id="preco" class="mb-1 col-sm-4" style="padding-left: 30px; padding-top: 30px">${preco}</h5>
                <div class="col-sm-5"></div>
                <form action="checkout" method="post" style="padding-left: 30px; padding-right: 30px; padding-top: 30px"> 
                    ${botaocheckout}
                </form>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

    </body>

</html>