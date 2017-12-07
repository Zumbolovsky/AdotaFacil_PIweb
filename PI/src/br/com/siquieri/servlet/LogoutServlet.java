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

@WebServlet("/usuario/logout")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }

    //metodo para deslogar o usuario da sessao
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            //pega a sessao atribuida a requisicao e impede que crie uma sessao caso nao tenha uma criada
            //tambem limpa o carrinho e a sessao propriamente dita passada pelo email do usuario no LoginServlet
            HttpSession session = request.getSession(false);
            session.setAttribute("user", null);
            session.setAttribute("carrinho", null);

            //redireciona para as paginas de usuarios nao logados
            request.setAttribute("mensagem", "Logout realizado com sucesso!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            //redireciona para a pagina especificada relacionando atributos para o tratamento do erro 
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("logout.jsp").forward(request, response);
        }
    }
}
