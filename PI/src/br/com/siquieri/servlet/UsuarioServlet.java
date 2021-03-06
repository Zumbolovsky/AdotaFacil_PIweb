/*
Andrew Siquieri - RA: 20872955 
Hadil Karim - RA: 20745273
Guilherme Lins - RA: 20699690
Jos� Netto - RA: 20163147
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
import br.com.siquieri.entity.Usuario;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String nome = request.getParameter("nome");
			String senha1 = request.getParameter("pass1");
			String email = request.getParameter("email");
			String cpf = request.getParameter("cpf");

			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);

			Usuario usuario = new Usuario();
		
			if (dao.buscarUsuario(email) != null) {

				request.setAttribute("mensagem", "Endere�o de email em uso!");
				request.getRequestDispatcher("cadastroSucesso.jsp").forward(request, response);

			} else {

				usuario.setNome(nome);
				usuario.setSenha(senha1);
				usuario.setEmail(email);
				usuario.setCpf(cpf);

				dao.adicionar(usuario);

				request.setAttribute("mensagem", "Usu�rio adicionado com sucesso!");
				request.getRequestDispatcher("cadastroSucesso.jsp").forward(request, response);

			}

		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.getRequestDispatcher("cadastroSucesso.jsp").forward(request, response);
		}
	}

}
