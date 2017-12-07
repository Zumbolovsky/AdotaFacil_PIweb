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
import br.com.siquieri.entity.Doacao;
import br.com.siquieri.entity.Usuario;

@WebServlet("/usuario/doacoesU")
public class DoacaoUServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DoacaoUServlet() {
        super();
    }

    //metodo para salvar no banco de dados os dados digitados no formulario de doacao enquanto estiver logado
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try {
            //instancia o GenericDao para executar uma busca que retorna o usuario da sessao
            GenericDao<Usuario> daoU = new GenericDao<>(Usuario.class);
            Usuario usuario = daoU.buscarUsuario((String) session.getAttribute("user"));
            
            //le os parametros recebidos pelo formulario e busca os parametros ja passados no cadastro
            String nome = usuario.getNome();
            String email = usuario.getEmail();
            String cpf = usuario.getCpf();
            String rg = request.getParameter("rg");
            String endereco = request.getParameter("end");
            double quantia = Double.parseDouble(request.getParameter("valor"));

            //instancia uma nova doacao
            Doacao doacao = new Doacao();

            //definicao dos valores dos atributos da entidade
            doacao.setNome(nome);
            doacao.setRg(rg);
            doacao.setEmail(email);
            doacao.setCpf(cpf);
            doacao.setEndereco(endereco);
            doacao.setQuantia(quantia);
            daoU.adicionarDoacao(usuario.getId(), doacao);

            //redireciona para a pagina especificada relacionando atributos para o uso na pagina de resposta
            request.setAttribute("mensagem", "Obrigado pela doação!");
            request.getRequestDispatcher("doacaoU.jsp").forward(request, response);
        } catch (Exception e) {
            //redireciona para a pagina especificada relacionando atributos para o tratamento do erro 
            request.setAttribute("mensagem", "ERRO: " + e.getMessage());
            request.getRequestDispatcher("doacaoU.jsp").forward(request, response);
        }
    }

}
