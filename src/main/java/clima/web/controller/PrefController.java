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
import clima.web.services.CiudadService;

public class PrefController extends HttpServlet {
	
	@WebServlet("/preferences")
	public class LoginController extends HttpServlet {

		private static final long serialVersionUID = 4559832007285759976L;

		@Override
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			CiudadService service = new CiudadService();
			List<Ciudad> ciudades = service.getCiudades(idPais);
			
			request.getSession().setAttribute("paises", paises);
			
			response.sendRedirect("preferences.jsp");
			
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String user =  req.getParameter("exampleInputEmail1");
			String password =  req.getParameter("exampleInputPassword1");
			Integer pais = Integer.valueOf(req.getParameter("pais"));
			super.doPost(req, resp);
		}

	}

}
