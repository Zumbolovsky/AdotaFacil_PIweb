package br.com.siquieri.servlet;

import br.com.siquieri.dao.GenericDao;
import br.com.siquieri.entity.Produto;
import br.com.siquieri.utils.Carrinho;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/usuario/carrinho")
public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try {
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            
            request.setAttribute("produtos", carrinho.getProdutos());
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("produtosU.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try {
            GenericDao<Produto> daoP = new GenericDao<>(Produto.class);
            Produto produto = daoP.buscarProduto(request.getParameter("produto"));
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            
            carrinho.getProdutos().add(produto);
            
            request.setAttribute("produtos", carrinho.getProdutos());
            request.setAttribute("mensagem", "Produto adicionado ao carrinho!");
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("produtosU.jsp").forward(request, response);
        }
    }

}
