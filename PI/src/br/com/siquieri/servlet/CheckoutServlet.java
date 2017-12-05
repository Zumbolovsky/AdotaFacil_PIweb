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
            
            daoV.adicionar(venda);
            
            GenericDao<Produto> daoP = new GenericDao<>(Produto.class);
            Produto[] produtos = (Produto[]) carrinho.getProdutos().toArray();
            
            for (int i = 0; i < produtos.length; i++) {
                produtos[i].getVendas().add(venda);
                produtos[i].setQuantidade(daoP.buscarProduto(produtos[i].getNome()).getQuantidade() - produtos[i].getQuantidade());
                daoP.adicionar(produtos[i]);
            }
            
            request.setAttribute("mensagem", "Checkout realizado com sucesso!");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } catch (Exception e) {
            
            
        }
    }

}
