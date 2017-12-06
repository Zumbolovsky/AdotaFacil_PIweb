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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try {
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            Venda venda = new Venda();
            
            GenericDao<Usuario> daoU = new GenericDao<>(Usuario.class);
            
            venda.setUsuario(daoU.buscarUsuario((String) session.getAttribute("user")));
            venda.setProdutos((LinkedHashSet<Produto>) carrinho.getProdutos());
            
            GenericDao<Venda> daoV = new GenericDao<>(Venda.class);
            GenericDao<Produto> daoP = new GenericDao<>(Produto.class);
            Produto[] produtos = new Produto[carrinho.getProdutos().toArray().length];
            produtos = carrinho.getProdutos().toArray(produtos);
         
            daoV.adicionar(venda);
            
            for (int i = 0; i < produtos.length; i++) {
                Produto prod = daoP.buscarProduto(produtos[i].getNome());
                prod.getVendas().add(venda);
                prod.setQuantidade(prod.getQuantidade() - produtos[i].getQuantidade());
                daoP.update(prod);
            }
            Carrinho novoCarrinho = new Carrinho();
            session.setAttribute("carrinho", novoCarrinho);
                    
            request.setAttribute("mensagem", "Checkout realizado com sucesso!");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        }
    }

}
