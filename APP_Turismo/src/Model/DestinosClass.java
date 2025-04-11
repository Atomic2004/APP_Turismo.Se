package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Metodos.Conexion;

public class DestinosClass {

    public int idDestino;
    public String nombre;
    public String ciudad;
    public String pais;
    public String descripcion;

    public DestinosClass(int idDestino, String nombre, String ciudad, String pais, String descripcion) {
        this.idDestino = idDestino;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.descripcion = descripcion;
    }

    public DestinosClass() {
    }

    // Getters y setters
    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    Conexion conector = new Conexion();

    public void create(String nombre, String ciudad, String pais, String descripcion) {
        Connection dbConnection = null;
        PreparedStatement pst = null;
        
        String script = "INSERT INTO tbldestinos (nombre, ciudad, pais, descripcion) VALUES (?, ?, ?, ?)";
        
        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);
            pst.setString(1, nombre);
            pst.setString(2, ciudad);
            pst.setString(3, pais);
            pst.setString(4, descripcion);
            pst.execute();
            System.out.println("Destino registrado con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int idDestino, String nombre, String ciudad, String pais, String descripcion) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "UPDATE tbldestinos SET nombre = ?, ciudad = ?, pais = ?, descripcion = ? WHERE iddestino = ?";
        
        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);
            pst.setString(1, nombre);
            pst.setString(2, ciudad);
            pst.setString(3, pais);
            pst.setString(4, descripcion);
            pst.setInt(5, idDestino);
            pst.executeUpdate();
            System.out.println("Destino actualizado con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int idDestino) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "DELETE FROM tbldestinos WHERE iddestino = ?";
        
        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);
            pst.setInt(1, idDestino);
            pst.executeUpdate();
            System.out.println("Destino eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
