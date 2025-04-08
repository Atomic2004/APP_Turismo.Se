package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Metodos.Conexion;

public class TipoTransporteClass {
	public int idtipo;
	public String nombre;
	public String observacion;

	public TipoTransporteClass(int idtipo, String nombre, String observacion) {
		super();
		this.idtipo = idtipo;
		this.nombre = nombre;
		this.observacion = observacion;
	}
	public TipoTransporteClass() {
		
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
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
		String script = "INSERT INTO tbltipotransporte (nombre, observacion) VALUES (?, ?)";
		try {
			dbConnection = new Conexion().conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setString(1, nombre);
			pst.setString(2, observacion);
			pst.execute();
			System.out.println("Tipo de transporte registrado con éxito.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
