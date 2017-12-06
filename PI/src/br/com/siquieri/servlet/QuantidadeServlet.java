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

@WebServlet("/usuario/quantidades")
public class QuantidadeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html");
        HttpSession session = request.getSession();
        try {
            String msgResposta = "";
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            GenericDao<Produto> daoP = new GenericDao<>(Produto.class);
            int[] quantidades = new int[carrinho.getProdutos().size()];
            boolean mudouQuantidadeProduto = false;
            boolean temProdutosDeMenos = false;
            
            for (int i = 0; i < quantidades.length; i++) {
                Produto p = (Produto) carrinho.getProdutos().toArray()[i];
                quantidades[i] = Integer.parseInt(request.getParameter(p.getNome()));
                if (quantidades[i] != p.getQuantidade()) {
                    if (quantidades[i] > 0 && daoP.buscarProduto(p.getNome()).getQuantidade() - quantidades[i] >= 0) {
                        ((Produto) carrinho.getProdutos().toArray()[i]).setQuantidade(quantidades[i]);
                        mudouQuantidadeProduto = true;
                    } else {
                        temProdutosDeMenos = true;
                    }
                }
            }
            
            System.out.println(mudouQuantidadeProduto);
            System.out.println(temProdutosDeMenos);
            
            if (mudouQuantidadeProduto) {
                if (temProdutosDeMenos) {
                    msgResposta = "Quantidade do(s) produto(s) atualizada!<br/><br/>"
                            + "H� produto(s) em quantidade indispon�vel!";
                } else {
                    msgResposta = "Quantidade do(s) produto(s) atualizada!";
                }
            } else {
                if (temProdutosDeMenos) {
                    msgResposta = "H� produto(s) em quantidade indispon�vel!";
                } 
            }
            
            double total = carrinho.calcularTotal(carrinho);
            
            if (!mudouQuantidadeProduto && !temProdutosDeMenos) {
                request.setAttribute("preco", "Valor Total: R$" + total);
                request.setAttribute("botaoquantidade", "<button type=\"submit\" class=\"btn btn-primary\">Atualizar quantidade(s)</button>");
                request.setAttribute("botaocheckout", "<button type=\"submit\" class=\"btn btn-primary\">Checkout</button>");
                request.setAttribute("produtos", carrinho.getProdutos());
                request.getRequestDispatcher("carrinho.jsp").forward(request, response);
            }
            
            request.setAttribute("preco", "Valor Total: R$" + total);
            request.setAttribute("botaoquantidade", "<button type=\"submit\" class=\"btn btn-primary\">Atualizar quantidade(s)</button>");
            request.setAttribute("botaocheckout", "<button type=\"submit\" class=\"btn btn-primary\">Checkout</button>");
            request.setAttribute("produtos", carrinho.getProdutos());
            request.setAttribute("mensagem", msgResposta);
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        }
    }

}
