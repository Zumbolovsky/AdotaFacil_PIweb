/*
Andrew Siquieri - RA: 20872955 
Hadil Karim - RA: 20745273
Guilherme Lins - RA: 20699690
José Netto - RA: 20163147
Selma Masuzawa - RA: 20680327
 */
package br.com.siquieri.servlet;

import br.com.siquieri.dao.GenericDao;
import br.com.siquieri.entity.Produto;
import br.com.siquieri.entity.Usuario;
import br.com.siquieri.entity.Venda;
import br.com.siquieri.utils.Carrinho;
import java.io.IOException;
import java.util.LinkedHashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/usuario/checkout")
public class CheckoutServlet extends HttpServlet {

    //metodo que executa o relacionamento da venda com o produto 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        //pega a sessao
        HttpSession session = request.getSession();
        try {
            //pega o carrinho e instancia a venda e o Dao referente a mesma
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            Venda venda = new Venda();
            GenericDao<Usuario> daoU = new GenericDao<>(Usuario.class);

            //define a o usuario e os produtos relacionados a venda realizada
            venda.setUsuario(daoU.buscarUsuario((String) session.getAttribute("user")));
            venda.setProdutos((LinkedHashSet<Produto>) carrinho.getProdutos());

            //instancia os elementos necessarios para relacionar os produtos a venda
            GenericDao<Venda> daoV = new GenericDao<>(Venda.class);
            GenericDao<Produto> daoP = new GenericDao<>(Produto.class);
            Produto[] produtos = new Produto[carrinho.getProdutos().toArray().length];
            produtos = carrinho.getProdutos().toArray(produtos);

            //adiciona a venda ao banco de dados (venda e venda_produto sao atualizados)
            daoV.adicionar(venda);

            //repeticao para dinamicamente alterar a quantidade de cada produto restante no estoque (BD)
            for (int i = 0; i < produtos.length; i++) {
                Produto prod = daoP.buscarProduto(produtos[i].getNome());
                prod.getVendas().add(venda);
                prod.setQuantidade(prod.getQuantidade() - produtos[i].getQuantidade());
                daoP.update(prod);
            }
            //instancia um novo carrinho para a sessao
            Carrinho novoCarrinho = new Carrinho();
            session.setAttribute("carrinho", novoCarrinho);

            //redireciona para uma pagina de checkout que indica o sucesso do processo
            request.setAttribute("mensagem", "Checkout realizado com sucesso!");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        }
    }

}
