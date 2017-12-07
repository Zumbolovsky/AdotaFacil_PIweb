/*
Andrew Siquieri - RA: 20872955 
Hadil Karim - RA: 20745273
Guilherme Lins - RA: 20699690
José Netto - RA: 20163147
Selma Masuzawa - RA: 20680327
 */
package br.com.siquieri.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siquieri.dao.GenericDao;
import br.com.siquieri.entity.Produto;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

//anotacao @MultipartConfig para poder adicionar imagens por formulario
@WebServlet("/usuario/produtos")
@MultipartConfig
public class ProdutoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ProdutoServlet() {
        super();
    }

    //metodo para adicionar produtos no banco de dados
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            //recebe os par?metros do formulario
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            double preco = Double.parseDouble(request.getParameter("preco"));
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));

            //codigo usado da internet para adicionar uma imagem no BD como mediumblob
            Part filePart = request.getPart("inputFile");
            InputStream inputStream = filePart.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] imagem = new byte[10240];
            for (int length = 0; (length = inputStream.read(imagem)) > 0;) {
                output.write(imagem, 0, length);
            }
            imagem = output.toByteArray();

            //instancia o objeto da classe GenericDao e novo produto
            GenericDao<Produto> dao = new GenericDao<>(Produto.class);
            Produto produto = new Produto();

            //valida caso ja tenha outro produto com o nome passado pelo formulario no BD
            if (dao.buscarProduto(nome) != null) {
                //redireciona a pagina especificada alertando que ja existe um produto com tal nome
                request.setAttribute("mensagem", "Produto já cadastrado!");
                request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);
            } else {
                //definicao dos valores dos atributos da entidade
                produto.setNome(nome);
                produto.setDescricao(descricao);
                produto.setPreco(preco);
                produto.setQuantidade(quantidade);
                produto.setImagem(imagem);

                //adiciona o produto no BD
                dao.adicionar(produto);

                // //redireciona para a pagina especificada relacionando atributos para o uso na pagina de resposta
                request.setAttribute("mensagem", "Produto adicionado com sucesso!");
                request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);
            }
        } catch (Exception e) {
            //redireciona para a pagina especificada relacionando atributos para o tratamento do erro 
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);
        }
    }

}
