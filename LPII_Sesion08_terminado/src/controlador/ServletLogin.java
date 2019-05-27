package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Menu;
import entidad.Usuario;
import patronDataAccessObjec.Factory;
import patronDataAccessObjec.UsuarioDao;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String usu = request.getParameter("txtLogin");
		String pas = request.getParameter("txtPassword");
		
		
		Factory subFarica = Factory.getTipo(Factory.TIPO_MYSQL);
		UsuarioDao dao = subFarica.getUsuario();
		
		Usuario usuario = null;
		try {
			usuario = dao.valida(usu, pas);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		if(usuario == null){ //No existe
			request.setAttribute("MENSAJE", "Usuario no existe");
			request.getRequestDispatcher("/portalLogin.jsp").forward(request, response);
		}else{//Si existe
			
			//Se obtiene la session
			HttpSession session = request.getSession();
			
			//Se guarda en session al usuario
			session.setAttribute("USUARIO", usuario);
			
			//se guarda los menus en session
			List<Menu> menus = null;
			
			try {
				menus = dao.menuXUsuario(usuario.getCodigo());
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("MENU", menus);
			
			
			
			request.getRequestDispatcher("/intranetPrincipal.jsp").forward(request, response);
		}
	}

}
