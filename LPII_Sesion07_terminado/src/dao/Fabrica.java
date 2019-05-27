package dao;

public  abstract class Fabrica {

	public static final int MYSQL = 1;
	public static final int SQL_SERVER = 2;
	public static final int ORACLE = 3;
	
	//Registran los daos
	public abstract AlumnoDAO getAlumno();
		
	//Se va retornar la subfabrica segun el tipo
	public static  Fabrica getSubFabrica(int tipo){
			switch (tipo) {
			case MYSQL:
				return new SubFabricaMySql();
			case SQL_SERVER:
				//Se crea la subfabrica cuando se necesite con SqlServer
				return null;
			case ORACLE:
				//Se crea la subfabrica cuando se necesite con Oracle
				return null;
			}
		return null;
	}
	
}
