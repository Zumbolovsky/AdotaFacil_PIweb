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
        <style>

            .nav-item img {
                vertical-align: middle;
                display: inline-block;
                max-height: 100%; /* <-- Set maximum height to 100% of its parent */
                max-width: 100%; /* <-- Set maximum width to 100% of its parent */
            }

            .nav-item .centerer {
                display: inline-block;
                vertical-align: middle;
                height: 100%;
            }
        </style>
    </head>

    <body>
        <section class="cabecalho">
            <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#nav-content" aria-controls="nav-content"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <!-- Brand -->
                <a class="navbar-brand"> <img
                        src="/PI/imagens/logobaby.png" title="AdotaFacil" width="60">Adota
                    Fácil
                </a>

                <!-- Links -->
                <div class="collapse navbar-collapse" id="nav-content">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item"><a class="nav-link" href="/PI/usuario/cadastroProduto.jsp">Cadastro de Produtos</a></li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="/PI/usuario/logoutG.jsp">Logout</a></li>
                    </ul>
                </div>
            </nav>
        </section>

        <div id="conteudo" style="margin: 50px; margin-top: 5%;">


            <div class="form-group row">
                <div class="col-sm-4"></div>
                <h3 class="col-sm-5">Deseja fazer logout?</h3>
            </div>
            <form name="logout" action="logout">
                <div class="form-group row" style="padding-top: 30px;">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-2">
                        <button formmethod="post" style="width: 100%;" type="submit"
                                class="btn btn-primary">Sim</button>
                    </div>
                    <div class="col-sm-1"></div>
                    <div class="col-sm-2">
                        <button formaction="/PI/usuario/cadastroProduto.jsp" style="width: 100%;"
                                type="submit" class="btn btn-primary">Não</button>
                    </div>
                    <div class="col-sm-3"></div>
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