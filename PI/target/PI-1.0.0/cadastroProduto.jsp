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
            <form name="cadastrarProdutos" action="produtos" method="post" enctype="multipart/form-data">
                <div class="form-group row">
                    <h3>Cadastre seus Produtos</h3>
                </div>
                <div class="form-group row">
                    <h5 style="color: grey;">Todos campos são obrigatórios</h5>
                </div>
                <div class="form-group row">
                    <label for="nome" class="col-sm-2 col-form-label">Nome:</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" id="nome"
                               placeholder="Nome do produto" name="nome" required="required">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="pass1" class="col-sm-2 col-form-label">Descrição:</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" id="descricao" required="required"
                               placeholder="Descricao" name="descricao" maxlength="20" min="3">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="cpf" class="col-sm-2 col-form-label">Preço:</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="number" step="0.01" min="0.01" id="preco" required="required"
                               placeholder="Preço do produto" name="preco" maxlength="18">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Quantidade:</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="number" step="1" min="1" id="quantidade" required="required"
                               placeholder="Quantidade" name="quantidade">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputFile" class="col-sm-2 col-form-label">Imagem do produto:</label>
                    <input type="file" class="form-control-file col-sm-2" name="inputFile" id="inputFile">
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