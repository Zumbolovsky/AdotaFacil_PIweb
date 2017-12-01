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

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProdutoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			double preco = Double.parseDouble(request.getParameter("preco"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));

			GenericDao<Produto> dao = new GenericDao<Produto>(Produto.class);

			Produto produto = new Produto();
		
			if (dao.buscarProduto(nome) != null) {

				request.setAttribute("mensagem", "Produto já cadastrado!");
				request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);

			} else {

				produto.setNome(nome);
				produto.setDescricao(descricao);
				produto.setPreco(preco);
				produto.setQuantidade(quantidade);

				dao.adicionar(produto);

				request.setAttribute("mensagem", "Produto adicionado com sucesso!");
				request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);

			}

		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);
		}
	}

}
