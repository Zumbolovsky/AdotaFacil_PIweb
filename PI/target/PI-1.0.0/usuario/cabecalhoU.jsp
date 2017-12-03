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

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#nav-content" aria-controls="nav-content"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Brand -->
    <a class="navbar-brand" href="/PI/usuario/indexU.jsp"> <img
            src="/PI/imagens/logobaby.png" title="AdotaFacil" width="60">Adota
        Fácil
    </a>

    <!-- Links -->
    <div class="collapse navbar-collapse" id="nav-content">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="/PI/usuario/infoU.jsp">Como
                    funciona</a></li>
            <li class="nav-item"><a class="nav-link" href="/PI/usuario/doacaoU.jsp">Ajude-nos</a></li>
            <li class="nav-item"><a class="nav-link" href="/PI/usuario/produtosU.jsp">Produtos</a></li>
            <li class="nav-item"><a class="nav-link" href="/PI/usuario/contatoU.jsp">Contato</a></li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="/PI/usuario/logout.jsp">Logout</a></li>
            <li class="nav-item"><a class="nav-link" href="/PI/usuario/carrinho"><img src="/PI/imagens/cart-4x.png"></a></li>
        </ul>
    </div>
</nav>