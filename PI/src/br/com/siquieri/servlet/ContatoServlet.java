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
import br.com.siquieri.entity.Contato;
import br.com.siquieri.entity.Usuario;

@WebServlet("/contatos")
public class ContatoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public ContatoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String nome = request.getParameter("nome");
			String fone = request.getParameter("fone");
			String email = request.getParameter("email");
			String mensagem = request.getParameter("mensagem");
			
			GenericDao<Contato> daoC = new GenericDao<Contato>(Contato.class);
			GenericDao<Usuario> daoU = new GenericDao<Usuario>(Usuario.class);
			
			Usuario usuario = daoU.buscarUsuario(email);
			Contato contato = new Contato();
			
			if(nome.trim() == "")
				contato.setNome(null);
			else
				contato.setNome(nome);
			
			if(email.trim() == "") 
				contato.setEmail(null);
			else 
				contato.setEmail(email);
			
			contato.setFone(fone);
			contato.setMensagem(mensagem);
			
			if (usuario != null) { 
				daoU.adicionarContato(usuario.getId(), contato);
			} else {
				contato.setUsuario(null);
				daoC.adicionar(contato);
			}
			
			request.setAttribute("mensagem", "Agradeçemos pelo feedback!");
			request.getRequestDispatcher("contato.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.getRequestDispatcher("contato.jsp").forward(request, response);
		}
	}

}
