package patronDataAccessObjec;


public class MySqlFactory  extends Factory{

	@Override
	public UsuarioDao getUsuario() {
		return new MySqlUsuarioDao();
	}

	
	
}
