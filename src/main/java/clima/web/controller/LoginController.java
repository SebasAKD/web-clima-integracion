package clima.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clima.web.model.Ciudad;
import clima.web.model.Pais;
import clima.web.model.Usuario;
import clima.web.services.CiudadService;


@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 4559832007285759976L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		CiudadService service = new CiudadService();
		List<Pais> paises = service.getPaises();
		
		request.getSession().setAttribute("paises", paises);
		
		response.sendRedirect("login.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user =  req.getParameter("exampleInputEmail1");
		String password =  req.getParameter("exampleInputPassword1");
		Integer pais = Integer.valueOf(req.getParameter("pais"));
		
		CiudadService ser = new CiudadService();
		
		Pais paisElegido = ser.getPais(pais);
		
		List<Ciudad> ciudades = ser.getCiudades(pais);
		
		Usuario usuario = new Usuario();
		usuario.setNombre(user);
		
		req.getSession().setAttribute("usuario", usuario);
		req.getSession().setAttribute("ciudades", ciudades);
		req.getSession().setAttribute("nombrePais", paisElegido.getName());
		
		resp.sendRedirect("preferences.jsp");
	}

	

}
