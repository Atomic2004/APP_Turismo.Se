package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Metodos.Conexion;

public class VehiculoClass {
	public String matricula;
	public String marca;
	public int puestos;
	public String modelo;
	public int numeromotor;
	public String categoria;
	public int idtipo;

	public VehiculoClass(String matricula, String marca, int puestos, String modelo, int numeromotor, String categoria,
			int idtipo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.puestos = puestos;
		this.modelo = modelo;
		this.numeromotor = numeromotor;
		this.categoria = categoria;
		this.idtipo = idtipo;
	}

	public VehiculoClass() {

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPuestos() {
		return puestos;
	}

	public void setPuestos(int puestos) {
		this.puestos = puestos;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumeromotor() {
		return numeromotor;
	}

	public void setNumeromotor(int numeromotor) {
		this.numeromotor = numeromotor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	Conexion conector = new Conexion();

	public void create(String matricula, String marca, int puestos, String modelo, int numeromotor, String categoria,
			int idtipo) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		String script = "INSERT INTO tblvehiculo (matricula, marca, puestos, modelo, numeromotor, categoria, idtipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			dbConnection = new Conexion().conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setString(1, matricula);
			pst.setString(2, marca);
			pst.setInt(3, puestos);
			pst.setString(4, modelo);
			pst.setInt(5, numeromotor);
			pst.setString(6, categoria);
			pst.setInt(7, idtipo);
			pst.execute();
			System.out.println("Vehículo registrado con éxito.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
