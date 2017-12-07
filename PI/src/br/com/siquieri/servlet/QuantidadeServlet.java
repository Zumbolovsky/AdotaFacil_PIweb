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

    //metodo pra tratar de alteracoes da quantidade de determinado produto enquanto dentro da propria pagina
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        //pega a sessao
        HttpSession session = request.getSession();
        try {
            //faz os instanciamentos necessarios para a manipulacao dos dado do carrinho
            String msgResposta = "";
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            GenericDao<Produto> daoP = new GenericDao<>(Produto.class);
            int[] quantidades = new int[carrinho.getProdutos().size()];
            boolean mudouQuantidadeProduto = false;
            boolean temProdutosDeMenos = false;

            //repeticao usada para verificar se e possivel alterar a quantidade do produto especificado
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

            //define as respostas para os casos de mudanca na quantidade de cada produto requisitado pelo formulario
            if (mudouQuantidadeProduto) {
                if (temProdutosDeMenos) {
                    msgResposta = "Quantidade do(s) produto(s) atualizada!<br/><br/>"
                            + "Há produto(s) em quantidade indisponível!";
                } else {
                    msgResposta = "Quantidade do(s) produto(s) atualizada!";
                }
            } else {
                if (temProdutosDeMenos) {
                    msgResposta = "Há produto(s) em quantidade indisponível!";
                }
            }

            //calcula o valor total a ser exibido no carrinho
            double total = carrinho.calcularTotal(carrinho);

            //executa os redirecionamentos e atribui valores para os atributos de acordo com os casos especificados
            if (!mudouQuantidadeProduto && !temProdutosDeMenos) {
                request.setAttribute("preco", "Valor Total: R$" + total);
                request.setAttribute("botaoquantidade", "<button type=\"submit\" class=\"btn btn-primary\">Atualizar quantidade(s)</button>");
                request.setAttribute("botaocheckout", "<button type=\"submit\" class=\"btn btn-primary\">Checkout</button>");
                request.setAttribute("produtos", carrinho.getProdutos());
                request.getRequestDispatcher("carrinho.jsp").forward(request, response);
            }

            //idem anterior
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
