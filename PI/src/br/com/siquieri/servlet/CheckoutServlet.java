package br.com.siquieri.servlet;

import br.com.siquieri.dao.GenericDao;
import br.com.siquieri.entity.Usuario;
import br.com.siquieri.entity.Venda;
import br.com.siquieri.utils.Carrinho;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            //TODO (ManyToMany Vendas-Produto/ possivel alteração do BD)
        } catch (Exception e) {
            
            
        }
    }

}
