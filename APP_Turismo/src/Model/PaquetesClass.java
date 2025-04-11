package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Metodos.Conexion;

public class PaquetesClass {

    private int idpaquete;
    private String descripcion;
    private int puestos;
    private String destino;
    private String fechaenvio;

    // Constructor
    public PaquetesClass(int idpaquete, String descripcion, int puestos, String destino, String fechaenvio) {
        this.idpaquete = idpaquete;
        this.descripcion = descripcion;
        this.puestos = puestos;
        this.destino = destino;
        this.fechaenvio = fechaenvio;
    }

    public PaquetesClass() {
    }

    // Getters y Setters
    public int getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(int idpaquete) {
        this.idpaquete = idpaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuestos() {
        return puestos;
    }

    public void setPuestos(int puestos) {
        this.puestos = puestos;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaenvio() {
        return fechaenvio;
    }

    public void setFechaenvio(String fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    Conexion conector = new Conexion();

    public void create(String descripcion, int puestos, String destino, String fechaenvio) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "INSERT INTO tblpaquetes (descripcion, puestos, destino, fechaenvio) VALUES (?, ?, ?, ?)";

        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);

            pst.setString(1, descripcion);
            pst.setInt(2, puestos); 
            pst.setString(3, destino);
            pst.setString(4, fechaenvio);

            pst.execute();
            System.out.println("Paquete registrado con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int idpaquete, String descripcion, int puestos, String destino, String fechaenvio) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "UPDATE tblpaquetes SET descripcion = ?, puestos = ?, destino = ?, fechaenvio = ? WHERE idpaquete = ?";

        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);

            pst.setString(1, descripcion);
            pst.setInt(2, puestos);
            pst.setString(3, destino);
            pst.setString(4, fechaenvio);
            pst.setInt(5, idpaquete);

            int confirm = JOptionPane.showConfirmDialog(null, "¿Desea actualizar este paquete?");
            if (confirm == JOptionPane.OK_OPTION) {
                pst.executeUpdate();
                System.out.println("Paquete actualizado con éxito.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int idpaquete) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "DELETE FROM tblpaquetes WHERE idpaquete = ?";

        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);
            pst.setInt(1, idpaquete);

            int confirm = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este paquete?");
            if (confirm == JOptionPane.OK_OPTION) {
                pst.executeUpdate();
                System.out.println("Paquete eliminado con éxito.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
