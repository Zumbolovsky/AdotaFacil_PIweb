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
import br.com.siquieri.entity.Doacao;
import br.com.siquieri.entity.Usuario;

@WebServlet("/doacoes")
public class DoacaoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DoacaoServlet() {
        super();
    }

    //metodo para salvar no banco os dados do formulario de doacao para usuarios nao logados
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            //recebe os valores do formulario
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String endereco = request.getParameter("end");
            double quantia = Double.parseDouble(request.getParameter("valor"));

            //instancia dos objetos da classe DAO
            GenericDao<Usuario> daoU = new GenericDao<>(Usuario.class);
            GenericDao<Doacao> daoD = new GenericDao<>(Doacao.class);

            //chama o metodo buscarUsuario que vai fazer uma busca no banco para achar o usuario
            Doacao doacao = new Doacao();
            Usuario usuario = daoU.buscarUsuario(email);

            //tratamento de dados para casos de feedbacks anonimos ou nao e definicao dos valores dos atributos da entidade
            if (nome.trim() == "") {
                doacao.setNome(null);
            } else {
                doacao.setNome(nome);
            }

            if (rg.trim() == "") {
                doacao.setRg(null);
            } else {
                doacao.setRg(rg);
            }

            if (email.trim() == "") {
                doacao.setEmail(null);
            } else {
                doacao.setEmail(email);
            }

            doacao.setCpf(cpf);
            doacao.setEndereco(endereco);
            doacao.setQuantia(quantia);

            //relaciona a doacao a um usuario caso ja esteja previamente cadastrado
            if (usuario != null) {
                daoU.adicionarDoacao(usuario.getId(), doacao);
            } else {
                doacao.setUsuario(null);
                daoD.adicionar(doacao);
            }

            //redireciona para a pagina especificada relacionando atributos para o uso na pagina de resposta
            request.setAttribute("mensagem", "Obrigado pela doação!");
            request.getRequestDispatcher("doacao.jsp").forward(request, response);
        } catch (Exception e) {
            //redireciona para a pagina especificada relacionando atributos para o tratamento do erro 
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("doacao.jsp").forward(request, response);
        }
    }

}
