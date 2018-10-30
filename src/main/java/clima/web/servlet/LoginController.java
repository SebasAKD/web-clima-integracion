package clima.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clima.web.model.Pais;


@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 4559832007285759976L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Collection<Pais> paises = getPaises();
		
		request.setAttribute("paises", paises);
		
		
		
		response.sendRedirect("login.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user =  req.getParameter("exampleInputEmail1");
		String password =  req.getParameter("exampleInputPassword1");
		Integer pais = Integer.valueOf(req.getParameter("pais"));
		super.doPost(req, resp);
	}

	private Collection<Pais> getPaises(){
		Collection<Pais> listaPaises = new ArrayList<>();
		
		Pais arg = new Pais();
		arg.setId(54);
		arg.setName("Argentina");
		
		Pais uru = new Pais();
		uru.setId(598);
		uru.setName("Uruguay");
		
		Pais bra = new Pais();
		uru.setId(55);
		uru.setName("Brasil");
		
		Pais chi = new Pais();
		uru.setId(56);
		uru.setName("Chile");
		
		Pais par = new Pais();
		uru.setId(595);
		uru.setName("Paraguay");
		
		listaPaises.add(arg);
		listaPaises.add(uru);
		listaPaises.add(bra);
		listaPaises.add(chi);
		listaPaises.add(par);
		
		return listaPaises;
	}

}
