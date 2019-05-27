package dao;

import java.util.List;

import entidad.Alumno;

public interface AlumnoDAO {

	public Alumno buscaAlumno(int idAlumno);
	public List<Alumno> consultaAlumno(int desde, int hasta);
	public List<Alumno> listaAlumno();
	public int eliminaAlumno(int idAlumno);
	public int actualizaAlumno(Alumno obj);
	public int insertaAlumno(Alumno obj);
		
	
}
