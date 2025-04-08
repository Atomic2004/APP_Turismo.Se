package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Metodos.Conexion;

public class PaquetesClass {
    public int codigo;
    public int iddestino;
    public int idorigen;
    public String precio;
    public String fechaventa;
    public String horaventa;
    public String horasalida;
    public String fechaejecucion;
    public String observacion;
	public PaquetesClass(int codigo, int iddestino, int idorigen, String precio, String fechaventa, String horaventa,
			String horasalida, String fechaejecucion, String observacion) {
		super();
		this.codigo = codigo;
		this.iddestino = iddestino;
		this.idorigen = idorigen;
		this.precio = precio;
		this.fechaventa = fechaventa;
		this.horaventa = horaventa;
		this.horasalida = horasalida;
		this.fechaejecucion = fechaejecucion;
		this.observacion = observacion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getIddestino() {
		return iddestino;
	}
	public void setIddestino(int iddestino) {
		this.iddestino = iddestino;
	}
	public int getIdorigen() {
		return idorigen;
	}
	public void setIdorigen(int idorigen) {
		this.idorigen = idorigen;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getFechaventa() {
		return fechaventa;
	}
	public void setFechaventa(String fechaventa) {
		this.fechaventa = fechaventa;
	}
	public String getHoraventa() {
		return horaventa;
	}
	public void setHoraventa(String horaventa) {
		this.horaventa = horaventa;
	}
	public String getHorasalida() {
		return horasalida;
	}
	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}
	public String getFechaejecucion() {
		return fechaejecucion;
	}
	public void setFechaejecucion(String fechaejecucion) {
		this.fechaejecucion = fechaejecucion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	 Conexion conector = new Conexion();

	    public void create(int iddestino, int idorigen, String precio, String fechaventa, String horaventa, String horasalida, String fechaejecucion, String observacion) {
	    	Connection dbConnection = null;
	    	PreparedStatement pst = null;
	        String script = "INSERT INTO tblpaquetes (iddestino, idorigen, precio, fechaventa, horaventa, horasalida, fechaejecucion, observacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        try {
	        	dbConnection = conector.conectarBD();
		        pst = dbConnection.prepareStatement(script); 
	            pst.setInt(1, iddestino);
	            pst.setInt(2, idorigen);
	            pst.setString(3, precio);
	            pst.setString(4, fechaventa);
	            pst.setString(5, horaventa);
	            pst.setString(6, horasalida);
	            pst.setString(7, fechaejecucion);
	            pst.setString(8, observacion);
	            pst.execute();
	            System.out.println("Paquete registrado con éxito.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
    
}
