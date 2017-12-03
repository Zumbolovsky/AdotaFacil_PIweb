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

        </style>

    </head>

    <body>
        <section class="cabecalho">
            <c:import url="cabecalho.jsp" />
        </section>

       	<div id="conteudo" style="margin: 50px;">

            <h1 class="display-3">Produtos</h1>

            <hr/>

            <div class="form-group row">
                <label for="filtro" class="col-form-label col-sm-4">Filtre
                    sua pesquisa:</label> <select id="filtro" class="form-control col-sm-8"
                                              onchange="filtrar()">
                    <option>Nenhum</option>
                    <option id="alfaCres">Ordem Alfab�tica, crescente</option>
                    <option id="alfaDecres">Ordem Alfab�tica, decrescente</option>
                    <option id="precoCres">Pre�o, crescente</option>
                    <option id="precoDecres">Pre�o, decrescente</option>
                </select>
            </div>

            <div id="produtos">
                <div class="row">
                    <div class="card col-sm-4" style="width: 20rem;" id="bone"
                         title="20.00">
                        <img class="card-img-top" src="imagens/bone2.jpg"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Bon�</h4>
                            <p class="card-text">Bon� Adota F�cil - R$20,00.</p>
                            <a href="bone.jsp" class="btn btn-primary">Detalhe</a>
                        </div>
                    </div>
                    <div class="card col-sm-4" style="width: 20rem;" id="caneta"
                         title="10.00">
                        <img class="card-img-top" src="imagens/caneta.jpg"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Caneta</h4>
                            <p class="card-text">Caneta Adota F�cil - R$10,00.</p>
                            <a href="caneta.jsp" class="btn btn-primary">Detalhe</a>
                        </div>
                    </div>
                    <div class="card col-md-4" style="width: 20rem;" id="camiseta"
                         title="49.99">
                        <img class="card-img-top" src="imagens/camiseta.jpg"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Camiseta</h4>
                            <p class="card-text">Camiseta Adota F�cil - R$49,99.</p>
                            <a href="camiseta.jsp" class="btn btn-primary">Detalhe</a>
                        </div>
                    </div>
                    <div class="card col-md-4" style="width: 20rem;" id="caneca"
                         title="49.90">
                        <img class="card-img-top" src="imagens/caneca.jpg"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Caneca</h4>
                            <p class="card-text">Caneca Adota F�cil - R$49,90.</p>
                            <a href="caneca.jsp" class="btn btn-primary">Detalhe</a>
                        </div>
                    </div>
                    <div class="card col-md-4" style="width: 20rem;" id="copo"
                         title="15.00">
                        <img class="card-img-top" src="imagens/copo.jpg"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Copo</h4>
                            <p class="card-text">Copo Adota F�cil - R$15,00.</p>
                            <a href="copoU.jsp" class="btn btn-primary">Detalhe</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

        <script>
                                    function getSelectTxt(elementId) {

                                        var val = document.getElementById(elementId);

                                        if (val.selectedIndex === -1)
                                            return null;

                                        return val.selectedIndex;
                                    }
                                    function filtrar() {
                                        if (getSelectTxt("filtro") === 1) {
                                            $(".row .card").sort(function (a, b) {
                                                return a.id >= b.id;
                                            }).each(function () {
                                                var elem = $(this);
                                                elem.remove();
                                                $(elem).appendTo(".row");
                                                elem.remove();
                                            });
                                        } else if (getSelectTxt("filtro") === 2) {
                                            $(".row .card").sort(function (a, b) {
                                                return a.id <= b.id;
                                            }).each(function () {
                                                var elem = $(this);
                                                elem.remove();
                                                $(elem).appendTo(".row");
                                                elem.remove();
                                            });
                                        } else if (getSelectTxt("filtro") === 3) {
                                            $(".row .card").sort(function (a, b) {
                                                var x = Number(a.title.replace(/[^0-9\.-]+/g, ""));
                                                var y = Number(b.title.replace(/[^0-9\.-]+/g, ""));
                                                return x >= y;
                                            }).each(function () {
                                                var elem = $(this);
                                                elem.remove();
                                                $(elem).appendTo(".row");
                                                elem.remove();
                                            });
                                        } else if (getSelectTxt("filtro") === 4) {
                                            $(".row .card").sort(function (a, b) {
                                                var x = Number(a.title.replace(/[^0-9\.-]+/g, ""));
                                                var y = Number(b.title.replace(/[^0-9\.-]+/g, ""));
                                                return x <= y;
                                            }).each(function () {
                                                var elem = $(this);
                                                elem.remove();
                                                $(elem).appendTo(".row");
                                                elem.remove();
                                            });
                                        }
                                    }
        </script>

    </body>
</html>
