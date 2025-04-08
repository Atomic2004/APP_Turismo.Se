package Metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/bd_logistica";
    private static final String USUARIO = "root";
    private static final String CLAVE = "2556229";

    public Connection conectarBD() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println(" Conectado exitosamente a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println(" Error: No se encontró la base de datos de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(" Error no se pudo conectar a la base de datos:");
            e.printStackTrace();
        }

        return connection;
    }
}
