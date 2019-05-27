package dao;

//Esta es un fabrica de objeto daos
//El dao alumno , el dao curso, etc
public class SubFabricaMySql extends Fabrica{

	

	@Override
	public AlumnoDAO getAlumno() {
		return new MySqlAlumnoDAO();
	}

	

}
