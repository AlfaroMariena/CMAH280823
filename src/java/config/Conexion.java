package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cortez
 */
public class Conexion {

    public Connection getConexion()  {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMA", "root", "12345678910");
            System.out.println("Conexion Exitosa");
            return conexion;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
}

