package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Metodos.Conexion;

public class CompaniasClass {

	public int idcompania;
	public String razonsocial;
	public String direccion;
	public String correo;
	public String telefono;
	public String fechacreacion;
	public String web;

	public CompaniasClass(int idcompania, String razonsocial, String direccion, String correo, String telefono,
			String fechacreacion, String web) {
		super();
		this.idcompania = idcompania;
		this.razonsocial = razonsocial;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.fechacreacion = fechacreacion;
		this.web = web;
	}
	public CompaniasClass() {
		
	}

	public int getIdcompania() {
		return idcompania;
	}

	public void setIdcompania(int idcompania) {
		this.idcompania = idcompania;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
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

	public String getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}
	
	Conexion conector = new Conexion();

    public void create(String razonsocial, String direccion, String correo, String telefono, String fechacreacion, String web) {
    	Connection dbConnection = null;
        PreparedStatement pst = null;
        
        String script = "INSERT INTO tblcompanias (razonsocial, direccion, correo, telefono, fechacreacion, web) VALUES (?, ?, ?, ?, ?, ?)";
        try {dbConnection = conector.conectarBD();
        pst = dbConnection.prepareStatement(script);
            pst.setString(1, razonsocial);
            pst.setString(2, direccion);
            pst.setString(3, correo);
            pst.setString(4, telefono);
            pst.setString(5, fechacreacion);
            pst.setString(6, web);
            pst.execute();
            System.out.println("Compañía registrada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(int idcompania, String razonsocial, String direccion, String correo, String telefono, String fechacreacion, String web) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "UPDATE tblcompanias SET razonsocial = ?, direccion = ?, correo = ?, telefono = ?, fechacreacion = ?, web = ? WHERE idcompania = ?";
        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);

            pst.setString(1, razonsocial);
            pst.setString(2, direccion);
            pst.setString(3, correo);
            pst.setString(4, telefono);
            pst.setString(5, fechacreacion);
            pst.setString(6, web);
            pst.setInt(7, idcompania);

            int confirm = JOptionPane.showConfirmDialog(null, "¿Desea actualizar esta compañía?");
            if (confirm == JOptionPane.OK_OPTION) {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Compañía actualizada con éxito");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(int idcompania) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "DELETE FROM tblcompanias WHERE idcompania = ?";
        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);
            pst.setInt(1, idcompania);

            int confirm = JOptionPane.showConfirmDialog(null, "¿Desea eliminar esta compañía?");
            if (confirm == JOptionPane.OK_OPTION) {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Compañía eliminada con éxito");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    
    
    

}