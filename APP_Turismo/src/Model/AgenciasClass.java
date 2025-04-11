package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Metodos.Conexion;

public class AgenciasClass {
	public int idagencia;
	public String nombre;
	public String direccion;
	public String correo;
	public String telefono;
	public String web;
	public int idcompania;
	
	public AgenciasClass(int idagencia, String nombre, String direccion, String correo, String telefono, String web,
			int idcompania) {
		super();
		this.idagencia = idagencia;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.web = web;
		this.idcompania = idcompania;
	}
	public AgenciasClass() {
		
	}

	public int getIdagencia() {
		return idagencia;
	}

	public void setIdagencia(int idagencia) {
		this.idagencia = idagencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public int getIdcompania() {
		return idcompania;
	}

	public void setIdcompania(int idcompania) {
		this.idcompania = idcompania;
	}
	
	Conexion conector = new Conexion();
	
	    public void create(String nombre, String direccion, String correo, String telefono, String web, int idcompania) {
	        Connection dbConnection = null;
	        PreparedStatement pst = null;
	        
	        String script = "INSERT INTO tblagencias (nombre, direccion, correo, telefono, web, idcompania) values(?, ?, ?, ?, ?, ?)";
	        try {
	            dbConnection = conector.conectarBD();
	            pst = dbConnection.prepareStatement(script);
	            pst.setString(1, nombre);
	            pst.setString(2, direccion);
	            pst.setString(3, correo);
	            pst.setString(4, telefono);
	            pst.setString(5, web);
	            pst.setInt(6, idcompania);
	            pst.execute();
	            JOptionPane.showMessageDialog(null, "Registro con éxito");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	    public void update(int idagencia, String nombre, String direccion, String correo, String telefono, String web) {
			Connection dbConnection = null;
			PreparedStatement pst = null;

			String script = "UPDATE tblagencias SET nombre = ?, direccion = ?, correo = ?, telefono = ?, web = ?, idcompania = ?";
			try {
				dbConnection = conector.conectarBD();
				pst = dbConnection.prepareStatement(script);

				pst.setString(1, nombre);
				pst.setString(2, direccion);
				pst.setString(3, correo);
				pst.setString(4, telefono);
				pst.setString(5, web);
				pst.setInt(7, idagencia);

				int confirm = JOptionPane.showConfirmDialog(null, "¿Desea actualizar esta fila?");
				if (confirm == JOptionPane.OK_OPTION) {
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Fila actualizada con éxito");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	    
	    public void delete(int idagencia) {
			Connection dbConnection = null;
			PreparedStatement pst = null;

			String script = "DELETE FROM tblagencias WHERE idagencia = ?;";
			try {
				dbConnection = conector.conectarBD();
				pst = dbConnection.prepareStatement(script);
				pst.setInt(1, idagencia);

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