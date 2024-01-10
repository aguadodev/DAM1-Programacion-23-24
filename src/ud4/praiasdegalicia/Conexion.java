package ud4.praiasdegalicia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static final String HOST = "143.47.52.115";
    static final String DATABASE = "damapp";
    static final String USER = "damapp";
    static final String PASSWORD = "DamApp-2324";
    static final String PORT = "3306";

    public static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://" + Conexion.HOST + ":3306/" + Conexion.DATABASE;

        try {
            con = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD.");
        }

        return con;
    }    
}
