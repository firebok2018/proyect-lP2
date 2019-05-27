package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogout
 */
@WebServlet("/logout")
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//se obtiene la session
		HttpSession session = request.getSession();
		
		//destruye
		session.invalidate();
		
		request.setAttribute("MENSAJE", "Usuario Salió de sesión");
		request.getRequestDispatcher("/portalSesionExpirada.jsp").forward(request, response);
		
	}

}
