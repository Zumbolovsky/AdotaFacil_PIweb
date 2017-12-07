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
import br.com.siquieri.utils.Carrinho;

@WebServlet("/logins")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    //metodo para realizar o login na sessao (usuario ou gerente) 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            //recebe os dados digitados no formulario de login
            String email = request.getParameter("email");
            String senha1 = request.getParameter("pass1");

            GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
            Usuario usuario = dao.buscarUsuario(email, senha1);

            //verifica se o usuario e o gerente
            if ((usuario.getEmail().equalsIgnoreCase("gerente@adotafacil.com"))) {
                //inicia a sessao do gerente
                HttpSession session = request.getSession(true);
                session.setAttribute("user", usuario.getEmail());

                //redireciona para as paginas que podem ser acessadas pelo gerente
                request.setAttribute("mensagem", "Bem-vindo gerente");
                request.getRequestDispatcher("usuario/cadastroProduto.jsp").forward(request, response);
            }
            //tratamento para saber se existe um usuario com o email e senha especificados
            if (usuario != null) {
                //inicia a sessao do usuario e atribui um carrinho a essa sessao
                HttpSession session = request.getSession(true);
                session.setAttribute("user", usuario.getEmail());
                Carrinho carrinho = new Carrinho();
                session.setAttribute("carrinho", carrinho);

                //redireciona para as paginas que podem ser acessadas pelo usuario
                request.setAttribute("mensagem", "Login realizado com sucesso!");
                request.getRequestDispatcher("usuario/indexU.jsp").forward(request, response);
            } else {
                //redireciona devolta ao login caso
                request.setAttribute("mensagem", "Email e/ou senha inválido(s)!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            //redireciona para a pagina especificada relacionando atributos para o tratamento do erro 
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
