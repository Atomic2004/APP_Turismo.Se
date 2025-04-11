package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Metodos.Conexion;

public class OperadoresClass {
    // Atributos de la clase
    private int idOperador;
    private String nombre;
    private String direccion;
    private String correo;
    private String telefono;
    private String licencia;

    // Constructor de la clase
    public OperadoresClass(int idOperador, String nombre, String direccion, String correo, String telefono, String licencia) {
        this.idOperador = idOperador;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.licencia = licencia;
    }

    public OperadoresClass() {
    }

    // Getters y Setters
    public int getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(int idOperador) {
        this.idOperador = idOperador;
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

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    Conexion conector = new Conexion();

    public void create(String nombre, String direccion, String correo, String telefono, String licencia) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "INSERT INTO tbloperadores (nombre, direccion, correo, telefono, licencia) VALUES (?, ?, ?, ?, ?)";
        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, correo);
            pst.setString(4, telefono);
            pst.setString(5, licencia);
            pst.execute();
            System.out.println("Operador registrado con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int idOperador, String nombre, String direccion, String correo, String telefono, String licencia) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "UPDATE tbloperadores SET nombre = ?, direccion = ?, correo = ?, telefono = ?, licencia = ? WHERE idOperador = ?";
        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, correo);
            pst.setString(4, telefono);
            pst.setString(5, licencia);
            pst.setInt(6, idOperador);
            pst.executeUpdate();
            System.out.println("Operador actualizado con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int idOperador) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "DELETE FROM tbloperadores WHERE idOperador = ?";
        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);
            pst.setInt(1, idOperador);
            pst.executeUpdate();
            System.out.println("Operador eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
