package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Metodos.Conexion;
import Metodos.Fr_Princiapl;
import view.FrmLogin;

public class PromotoresClass {
	public int id;
	public int tipodocumento;
	public int documento;
	public String nombres;
	public String apellidos;
	public String direccion;
	public String correopersonal;
	public String correocorp;
	public String fechanacimiento;
	public String telefono;
	public String contrasena;
	Conexion conector = new Conexion();
	Fr_Princiapl login = new Fr_Princiapl();

	public PromotoresClass(int id, int tipodocumento, int documento, String nombres, String apellidos, String direccion,
			String correopersonal, String correocorp, String fechanacimiento, String telefono) {
		super();
		this.id = id;
		this.tipodocumento = tipodocumento;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.correopersonal = correopersonal;
		this.correocorp = correocorp;
		this.fechanacimiento = fechanacimiento;
		this.telefono = telefono;
	}

	public PromotoresClass() {

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

	public String getCorreopersonal() {
		return correopersonal;
	}

	public void setCorreopersonal(String correopersonal) {
		this.correopersonal = correopersonal;
	}

	public String getCorreocorp() {
		return correocorp;
	}

	public void setCorreocorp(String correocorp) {
		this.correocorp = correocorp;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void create(int tipodocumento, int documento, String nombres, String apellidos, String direccion,
			String correopersonal, String correocorp, String fechanacimiento, String telefono) {

		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "INSERT INTO tblpromotores (tipodocumento, documento, nombres, apellidos, direccion, correopersonal, correocorp, fechanacimiento, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			dbConnection = new Conexion().conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, tipodocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombres);
			pst.setString(4, apellidos);
			pst.setString(5, direccion);
			pst.setString(6, correopersonal);
			pst.setString(7, correocorp);
			pst.setString(8, fechanacimiento);
			pst.setString(9, telefono);
			pst.execute();
			System.out.println("Promotor registrado con éxito.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void controlAcceaso(int user, String pass) {

		Connection dbConnection = null;

		PreparedStatement pst = null;

		String script = "SELECT * FROM tblpromotores WHERE documento = ? and contrasena = ?";

		try {

			dbConnection = conector.conectarBD();

			pst = dbConnection.prepareStatement(script);

			pst.setInt(1, user);

			pst.setString(2, pass);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				FrmLogin login = new FrmLogin();
				login.show();
				login.setVisible(true);

				// JOptionPane.showConfirmDialog(null, "Acceso permitido");

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}
}
