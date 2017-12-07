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

@WebServlet("/usuario/carrinho")
public class CarrinhoServlet extends HttpServlet {

    //metodo para tratar de requisicoes get para a pagina carrinho.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try {
            //apos receber a sessao atribuida a requisicao, recebe tambem o carrinho da sessao
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");

            //trata do caso do carrinho estar vazio
            if (carrinho.getProdutos().isEmpty()) {
                //redireciona para a pagina de carrinho alertando a situacao
                request.setAttribute("mensagem", "Seu carrinho está vazio!");
                request.getRequestDispatcher("carrinho.jsp").forward(request, response);
            }

            //calcula o total do carrinho para que seja exibido na pagina
            double total = carrinho.calcularTotal(carrinho);

            //atribui os atributos necessarios para a pagina de requisicao
            request.setAttribute("preco", "Valor Total: R$" + total);
            request.setAttribute("botaoquantidade", "<button type=\"submit\" class=\"btn btn-primary\">Atualizar quantidade(s)</button>");
            request.setAttribute("botaocheckout", "<button type=\"submit\" class=\"btn btn-primary\">Checkout</button>");
            request.setAttribute("produtos", carrinho.getProdutos());
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("produtosU.jsp").forward(request, response);
        }
    }

    //metodo para tratar do acesso a partir do metodo post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try {
            //pega a sessao e instancia os elementos necessarios para a manipulacao dos dados do carrinho
            String msgResposta;
            GenericDao<Produto> daoP = new GenericDao<>(Produto.class);
            Produto produto = daoP.buscarProduto(request.getParameter("produto"));
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");

            //procura se o produto que deve ser adicionado ja consta no carrinho
            int i = 0;
            boolean temProdutoNoCarrinho = false;
            for (Produto prod : carrinho.getProdutos()) {
                if (prod.getNome().equalsIgnoreCase(produto.getNome())) {
                    temProdutoNoCarrinho = true;
                    break;
                }
                i++;
            }

            //caso o produto esteja no carrinho o mesmo sera incrementado de 1 na quantidade no carrinho
            //caso nao tenha produtos o suficiente em estoque (BD somente) o alerta e definido
            if (temProdutoNoCarrinho) {
                Produto p = (Produto) carrinho.getProdutos().toArray()[i];
                if (daoP.buscarProduto(p.getNome()).getQuantidade() - p.getQuantidade() > 0) {
                    p.setQuantidade(p.getQuantidade() + 1);
                    msgResposta = "Produto adicionado ao carrinho!";
                } else {
                    msgResposta = "Produto em quantidade indisponível!";
                }
                //caso o produto nao esteja no carrinho e adicionado tenha suficiente no estoque
            } else {
                if (daoP.buscarProduto(produto.getNome()).getQuantidade() > 0) {
                    produto.setQuantidade(1);
                    carrinho.getProdutos().add(produto);
                    msgResposta = "Produto adicionado ao carrinho!";
                } else {
                    msgResposta = "Produto em quantidade indisponível!";
                }
            }

            //verifica se, apos toda a verificacao acima, o carrinho continua vazio
            if (carrinho.getProdutos().isEmpty()) {
                request.setAttribute("mensagem", "Produto em quantidade indisponivel!<br/><br/>Seu carrinho está vazio!");
                request.getRequestDispatcher("carrinho.jsp").forward(request, response);
            }
            double total = carrinho.calcularTotal(carrinho);

            //atribui os valores necessarios para a pagina de redirecionamento
            request.setAttribute("preco", "Valor Total: R$" + total);
            request.setAttribute("botaocheckout", "<button type=\"submit\" class=\"btn btn-primary\">Checkout</button>");
            request.setAttribute("botaoquantidade", "<button type=\"submit\" class=\"btn btn-primary\">Atualizar quantidade(s)</button>");
            request.setAttribute("produtos", carrinho.getProdutos());
            request.setAttribute("mensagem", msgResposta);
            request.getRequestDispatcher("carrinho.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("produtosU.jsp").forward(request, response);
        }
    }

}
