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
import javax.servlet.http.HttpSession;

import br.com.siquieri.dao.GenericDao;
import br.com.siquieri.entity.Contato;
import br.com.siquieri.entity.Usuario;

@WebServlet("/usuario/contatosU")
public class ContatoUServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public ContatoUServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		try {
			GenericDao<Usuario> daoU = new GenericDao<Usuario>(Usuario.class);
			Usuario usuario = daoU.buscarUsuario((String) session.getAttribute("user"));
			
			String nome = usuario.getNome();
			String email = usuario.getEmail();
			String fone = request.getParameter("fone");
			String mensagem = request.getParameter("mensagem");
			
			Contato contato = new Contato();
			
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setFone(fone);
			contato.setMensagem(mensagem);
			daoU.adicionarContato(usuario.getId(), contato);
			
			request.setAttribute("mensagem", "Agradeçemos pelo feedback!");
			request.getRequestDispatcher("contatoU.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.getRequestDispatcher("contatoU.jsp").forward(request, response);
		}
	}

}
