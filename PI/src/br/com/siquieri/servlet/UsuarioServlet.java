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
import br.com.siquieri.entity.Usuario;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UsuarioServlet() {
        super();
    }

    //para requisicoes do tipo "post" e action "usuarios"
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            
            //pega valores dos inputs do formulario 
            String nome = request.getParameter("nome");
            String senha1 = request.getParameter("pass1");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");

            GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);

            Usuario usuario = new Usuario();
            
            //busca se já existem usuarios com esse email
            if (dao.buscarUsuario(email) != null) {
                request.setAttribute("mensagem", "Endereço de email em uso!");
                request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            } else {
                //define campos na entidade usuario referente a tabela no banco de dados para inclusao
                usuario.setNome(nome);
                usuario.setSenha(senha1);
                usuario.setEmail(email);
                usuario.setCpf(cpf);
                
                dao.adicionar(usuario);

                //define mensagens para a resposta do formulario
                request.setAttribute("mensagem", "Usuário adicionado com sucesso!");
                request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            }
        } catch (Exception e) {
            //trata excessoes para a inclusao de usuario
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        }
    }

}
