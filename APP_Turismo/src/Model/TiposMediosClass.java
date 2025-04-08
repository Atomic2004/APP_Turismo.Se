package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Metodos.Conexion;

public class TiposMediosClass {
	public int idtipomedio;
	public String nombre;
	public String observacion;

	public TiposMediosClass(int idtipomedio, String nombre, String observacion) {
		super();
		this.idtipomedio = idtipomedio;
		this.nombre = nombre;
		this.observacion = observacion;
	}
	public TiposMediosClass() {
		
	}

	public int getIdtipomedio() {
		return idtipomedio;
	}

	public void setIdtipomedio(int idtipomedio) {
		this.idtipomedio = idtipomedio;
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

	public void create(String nombre, String observacion) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		String script = "INSERT INTO tbltiposmedios (nombre, observacion) VALUES (?, ?)";
		try {
			dbConnection = new Conexion().conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setString(1, nombre);
			pst.setString(2, observacion);
			pst.execute();
			System.out.println("Tipo de medio registrado con éxito.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void delete(String nombre, String observacion) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		String script = "INSERT INTO tbltiposmedios (nombre, observacion) VALUES (?, ?)";
		try {
			dbConnection = new Conexion().conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setString(1, nombre);
			pst.setString(2, observacion);
			pst.execute();
			System.out.println("Tipo de medio registrado con éxito.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void update(String nombre, String observacion) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		String script = "INSERT INTO tbltiposmedios (nombre, observacion) VALUES (?, ?)";
		try {
			dbConnection = new Conexion().conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setString(1, nombre);
			pst.setString(2, observacion);
			pst.execute();
			System.out.println("Tipo de medio registrado con éxito.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
