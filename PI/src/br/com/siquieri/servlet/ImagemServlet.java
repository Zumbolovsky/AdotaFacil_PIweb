package br.com.siquieri.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siquieri.dao.GenericDao;
import br.com.siquieri.entity.Produto;

@WebServlet("/imagem")
public class ImagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImagemServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			GenericDao<Produto> dao = new GenericDao<>(Produto.class);
			
			byte[] imagem = dao.buscar(id).getImagem();
			response.setContentType("image/jpeg");
			ServletOutputStream os = response.getOutputStream();
			os.write(imagem);
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
