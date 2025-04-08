

package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Metodos.Conexion;

public class LoginClass {
	public String correo;
	public String rol;

	public LoginClass(String correo, String rol) {
		this.correo = correo;
		this.rol = rol;
	}

	public LoginClass() {

	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	Conexion conector = new Conexion();

	public String validarUsuario(String correo) {
		String rol = null;
		Connection dbConnection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String query = "SELECT rol FROM tblusuarios WHERE correo = ?";

		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(query);
			pst.setString(1, correo);
			rs = pst.executeQuery();

			if (rs.next()) {
				rol = rs.getString("rol");
			}
		} catch (SQLException e) {
			System.out.println("Error en la validación del usuario: " + e.getMessage());
		} finally {
			cerrarRecursos(rs, pst, dbConnection);
		}
		return rol;
	}

	private void cerrarRecursos(ResultSet rs, PreparedStatement pst, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
