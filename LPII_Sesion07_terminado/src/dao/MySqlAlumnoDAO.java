package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import miConexion.MysqlDBConexion;
import entidad.Alumno;

public class MySqlAlumnoDAO implements AlumnoDAO{

	public Alumno buscaAlumno(int idAlumno){
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Alumno obj = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql ="select * from tbalumno where idtbAlumno=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idAlumno);
			rs = pstm.executeQuery();
			if(rs.next()){
				obj = new Alumno();
				obj.setIdAlumno(rs.getInt("idtbalumno"));
				obj.setNombre(rs.getString("nombre"));
				obj.setApellido(rs.getString("apellido"));
				obj.setEdad(rs.getInt("edad"));
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
	
	public List<Alumno> consultaAlumno(int desde, int hasta){
		List<Alumno> data = new ArrayList<Alumno>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql ="select * from tbalumno where edad between ? and ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, desde);
			pstm.setInt(2, hasta);
			rs = pstm.executeQuery();
			
			Alumno obj = null;
			while(rs.next()){
				obj = new Alumno();
				obj.setIdAlumno(rs.getInt("idtbalumno"));
				obj.setNombre(rs.getString("nombre"));
				obj.setApellido(rs.getString("apellido"));
				obj.setEdad(rs.getInt("edad"));
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
	
	public List<Alumno> listaAlumno(){
		List<Alumno> data = new ArrayList<Alumno>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql ="select * from tbalumno";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Alumno obj = null;
			while(rs.next()){
				obj = new Alumno();
				obj.setIdAlumno(rs.getInt("idtbalumno"));
				obj.setNombre(rs.getString("nombre"));
				obj.setApellido(rs.getString("apellido"));
				obj.setEdad(rs.getInt("edad"));
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
	
	public int eliminaAlumno(int idAlumno){
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = MysqlDBConexion.getConexion();
			String sql ="delete from tbalumno where idtbAlumno=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idAlumno);
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close(
						);
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}
	
	public int actualizaAlumno(Alumno obj){
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = MysqlDBConexion.getConexion();
			String sql ="update tbAlumno set nombre=?, apellido=?, edad=? where idtbalumno=?";     
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setInt(3, obj.getEdad());
			pstm.setInt(4, obj.getIdAlumno());
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close(
						);
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}
	
	public int insertaAlumno(Alumno obj){
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = MysqlDBConexion.getConexion();
			String sql ="insert into tbalumno values(null,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setInt(3, obj.getEdad());
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close(
						);
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}
	

}
