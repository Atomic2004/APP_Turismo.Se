package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Metodos.Conexion;

public class MediosClass {

	public int idmedios;
	public String nombre;
	public String observacion;

	public MediosClass(int idmedios, String nombre, String observacion) {
		super();
		this.idmedios = idmedios;
		this.nombre = nombre;
		this.observacion = observacion;
	}

	public MediosClass() {

	}

	public int getIdmedios() {
		return idmedios;
	}

	public void setIdmedios(int idmedios) {
		this.idmedios = idmedios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	Conexion conector = new Conexion();

	public void create(String nombre, String observacion, int idmedios) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		String script = "INSERT INTO tblmedios (nombre, observacion, idtipomedio) VALUES (?, ?, ?)";
		try {
			dbConnection = new Conexion().conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setString(1, nombre);
			pst.setString(2, observacion);
			pst.setInt(3, idmedios);
			pst.execute();
			System.out.println("Medio registrado con éxito.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(int idmedios, String nombre, String observacion) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "UPDATE tblmedios SET nombre = ?, observacion = ?, WHERE idmedios = ?;";
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);

			pst.setString(1, nombre);
			pst.setInt(6, idmedios);
			pst.setString(7, observacion);

			int confirm = JOptionPane.showConfirmDialog(null, "¿Desea actualizar esta fila?");
			if (confirm == JOptionPane.OK_OPTION) {
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Fila actualizada con éxito");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int idmedios) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "DELETE FROM tblmedios WHERE idmedios = ?;";
		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idmedios);

			int confirm = JOptionPane.showConfirmDialog(null, "¿Desea eliminar esta fila?");
			if (confirm == JOptionPane.OK_OPTION) {
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Fila eliminada con éxito");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}