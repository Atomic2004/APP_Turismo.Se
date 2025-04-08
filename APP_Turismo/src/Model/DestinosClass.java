package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Metodos.Conexion;

public class DestinosClass {
	public int iddestino;
	public String nombre;
	public String pais;
	public String ciudad;
	public String descripcion;
	public String atractivo_principal;

	public DestinosClass(int iddestino, String nombre, String pais, String ciudad, String descripcion,
			String atractivo_principal) {
		super();
		this.iddestino = iddestino;
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.atractivo_principal = atractivo_principal;
	}
	public DestinosClass() {
		
	}

	public int getIddestino() {
		return iddestino;
	}

	public void setIddestino(int iddestino) {
		this.iddestino = iddestino;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAtractivo_principal() {
		return atractivo_principal;
	}

	public void setAtractivo_principal(String atractivo_principal) {
		this.atractivo_principal = atractivo_principal;
	}

	Conexion conector = new Conexion();

	public void create(String nombre, String pais, String ciudad, String descripcion, String atractivo_principal) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		String script = "INSERT INTO tbldestinos (nombre, pais, ciudad, descripcion, atractivo_principal) VALUES (?, ?, ?, ?, ?)";
		try {
			dbConnection = new Conexion().conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setString(1, nombre);
			pst.setString(2, pais);
			pst.setString(3, ciudad);
			pst.setString(4, descripcion);
			pst.setString(5, atractivo_principal);
			pst.execute();
			System.out.println("Destino registrado con éxito.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
