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
public class ContatoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ContatoServlet() {
        super();
    }
    //metodo para receber dados para contato e depois inseri-los no banco de dados utilizando os metodos da classe GenericDao e persistir os dados do formulario de contato do site

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            //leitura dos parametros recebidos pelo formulario
            String nome = request.getParameter("nome");
            String fone = request.getParameter("fone");
            String email = request.getParameter("email");
            String mensagem = request.getParameter("mensagem");
            
            //instancia dos objetos da classe DAO
            GenericDao<Contato> daoC = new GenericDao<>(Contato.class);
            GenericDao<Usuario> daoU = new GenericDao<>(Usuario.class);

            //chama o metodo buscarUsuario que vai fazer uma busca no banco para achar o usuario
            Usuario usuario = daoU.buscarUsuario(email);
            Contato contato = new Contato();
            
            //tratamento de dados para casos de feedbacks anonimos ou nao e definicao dos valores dos atributos da entidade
            if (nome.trim() == "") {
                contato.setNome(null);
            } else {
                contato.setNome(nome);
            }

            if (email.trim() == "") {
                contato.setEmail(null);
            } else {
                contato.setEmail(email);
            }

            contato.setFone(fone);
            contato.setMensagem(mensagem);

            //relaciona o contato a um usuario caso ja esteja previamente cadastrado
            if (usuario != null) {
                daoU.adicionarContato(usuario.getId(), contato);
            } else {
                contato.setUsuario(null);
                daoC.adicionar(contato);
            }

            //redireciona para a pagina especificada relacionando atributos para o uso na pagina de resposta
            request.setAttribute("mensagem", "Agradeçemos pelo feedback!");
            request.getRequestDispatcher("contato.jsp").forward(request, response);

        } catch (Exception e) {
            //redireciona para a pagina especificada relacionando atributos para o tratamento do erro 
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("contato.jsp").forward(request, response);
        }
    }

}
