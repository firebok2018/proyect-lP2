package patronDataAccessObjec;

import java.sql.SQLException;
import java.util.List;

import entidad.Menu;
import entidad.Usuario;

public interface UsuarioDao {

	public Usuario valida(String usu, String pass) throws SQLException;
	public List<Menu> menuXUsuario(int idusuario) throws SQLException;
	
	
}
