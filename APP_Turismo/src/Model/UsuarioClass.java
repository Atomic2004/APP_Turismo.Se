package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Metodos.Conexion;

public class UsuarioClass {
    public int idusuario;
    public String nombre;
    public String correo;
    public String contrasena;
    public String rol;

    Conexion conector = new Conexion();

    public UsuarioClass(int idusuario, String nombre, String correo, String contrasena, String rol) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public UsuarioClass() {}

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void create(String nombre, String correo, String contrasena, String rol) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "INSERT INTO tblusuarios (nombre, correo, contrasena, rol) values(?, ?, ?, ?)";
        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);
            pst.setString(1, nombre);
            pst.setString(2, correo);
            pst.setString(3, contrasena);
            pst.setString(4, rol);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
