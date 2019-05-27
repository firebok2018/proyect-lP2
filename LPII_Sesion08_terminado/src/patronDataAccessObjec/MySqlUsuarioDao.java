package patronDataAccessObjec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import miConexion.MySqlDBConn;

import entidad.Menu;
import entidad.Usuario;

public class MySqlUsuarioDao  implements UsuarioDao{

	@Override
	public Usuario valida(String usu, String pass) throws SQLException {
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Usuario obj = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="select * from tb_usuario where log_usu = ? and pas_usu =? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usu);
			pstm.setString(2, pass);
			rs = pstm.executeQuery();
			while(rs.next()){
				obj = new Usuario();
				obj.setCodigo(rs.getInt("cod_usu"));
				obj.setLogin(rs.getString("log_usu"));
				obj.setPassword(rs.getString("pas_usu"));
				obj.setNombre(rs.getString("nom_usu"));
				obj.setApellido(rs.getString("ape_usu"));
				obj.setEdad(rs.getInt("eda_usu"));
				obj.setEstado(rs.getString("est_usu"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return obj;
	}

	@Override
	public List<Menu> menuXUsuario(int idusuario) throws SQLException {
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Menu> data = new ArrayList<Menu>();
		Menu obj = null;
		
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="SELECT m.COD_MEN, m.DES_MEN, m.URL_MEN FROM tb_menu  m inner join tb_acceso a on m.COD_MEN = a.COD_MEN where a.COD_USU =?";     
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idusuario);

			rs = pstm.executeQuery();
			while(rs.next()){
				obj = new Menu();
				obj.setIdMenu(rs.getString(1));
				obj.setDescripcion(rs.getString(2));
				obj.setUrl(rs.getString(3));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return data;
	}

	

}
