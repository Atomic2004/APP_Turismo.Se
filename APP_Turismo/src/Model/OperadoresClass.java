package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Metodos.Conexion;

public class OperadoresClass {
	public int id;
	public int tipodocumento;
	public int documento;
	public String nombres;
	public String apellidos;
	public String direccion;
	public String correo;
	public String telefono;

	public OperadoresClass(int id, int tipodocumento, int documento, String nombres, String apellidos, String direccion,
			String correo, String telefono) {
		super();
		this.id = id;
		this.tipodocumento = tipodocumento;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
	}
	public OperadoresClass() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(int tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	Conexion conector = new Conexion();

	public void create(int tipodocumento, int documento, String nombres, String apellidos, String direccion,
			String correo, String telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		String script = "INSERT INTO tbloperadores (tipodocumento, documento, nombres, apellidos, direccion, correo, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			dbConnection = new Conexion().conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, tipodocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombres);
			pst.setString(4, apellidos);
			pst.setString(5, direccion);
			pst.setString(6, correo);
			pst.setString(7, telefono);
			pst.execute();
			System.out.println("Operador registrado con éxito.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
