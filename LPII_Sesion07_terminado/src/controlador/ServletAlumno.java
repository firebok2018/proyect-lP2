package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumnoDAO;
import dao.Fabrica;
import entidad.Alumno;

/**
 * Servlet implementation class ServletAlumno
 */
@WebServlet("/alumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String met = request.getParameter("metodo");

		if(met.equals("lista")){
			lista(request, response);
		}else if(met.equals("registra")){
			registra(request, response);
		}else if(met.equals("elimina")){
			elimina(request, response);
		}else if(met.equals("busca")){
			busca(request, response);
		}else if(met.equals("actualiza")){
			actualiza(request, response);
		}
		
	}
	protected void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.MYSQL);
		AlumnoDAO dao = subFabrica.getAlumno();
	
		List<Alumno> data = dao.listaAlumno();
		request.setAttribute("data", data);
		request.getRequestDispatcher("/listaAlumno.jsp").								forward(request, response);
	}
	
	protected void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String edad = request.getParameter("edad");
		
		Alumno a = new Alumno();
		a.setIdAlumno(Integer.parseInt(id));
		a.setNombre(nombre);
		a.setApellido(apellido);
		a.setEdad(Integer.parseInt(edad));
		
		
		Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.MYSQL);
		AlumnoDAO dao = subFabrica.getAlumno();
		dao.actualizaAlumno(a);

		
		lista(request, response);	
		
	}
	protected void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String edad = request.getParameter("edad");
	
		Alumno a = new Alumno();
		a.setNombre(nombre);
		a.setApellido(apellido);
		a.setEdad(Integer.parseInt(edad));
		
		
		Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.MYSQL);
		AlumnoDAO dao = subFabrica.getAlumno();
		dao.insertaAlumno(a);
		
		lista(request, response);
	}
	
	protected void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Se obtiene el id
		String id = request.getParameter("id");
		
		Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.MYSQL);
		AlumnoDAO dao = subFabrica.getAlumno();
	
		dao.eliminaAlumno(Integer.parseInt(id));
		
		//se ejecuta el listado
		lista(request, response);
	}
	
	protected void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.MYSQL);
		AlumnoDAO dao = subFabrica.getAlumno();
	
		Alumno a =  dao.buscaAlumno(Integer.parseInt(id));
		
		request.setAttribute("alumno", a);
		request.getRequestDispatcher("/actualizaAlumno.jsp").forward(request, response);
		
	}

}
