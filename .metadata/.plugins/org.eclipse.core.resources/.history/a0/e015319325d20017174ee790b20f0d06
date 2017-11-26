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
import br.com.siquieri.entity.Usuario;

@WebServlet("/logins")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String email = request.getParameter("email");
			String senha1 = request.getParameter("pass1");

			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);
			
			Usuario usuario = dao.buscarUsuario(email, senha1);
			
			if(usuario != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", usuario.getEmail());
				
				request.setAttribute("mensagem", "Login realizado com sucesso!");
				request.getRequestDispatcher("usuario/indexU.jsp").forward(request, response);
			} else {
				request.setAttribute("mensagem", "Email e/ou senha inválido(s)!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("mensagem", "ERRO: " + e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
