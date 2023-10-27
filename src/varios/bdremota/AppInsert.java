package varios.bdremota;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

public class AppInsert {
    public static void main(String[] args) throws Exception {
        System.out.println("Accediendo a BD MySQL");

        String url = "jdbc:mysql://" + Conexion.HOST + ":3306/" + Conexion.DATABASE;

        try {
            Connection conexion = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);

            Statement sentencia = conexion.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese un usuario: ");
            String user = sc.nextLine();
            System.out.println("Ingrese una contraseña: ");
            String pass = sc.nextLine();

            String sql = "INSERT INTO user (username, password, createdAt) VALUES ('"
            + user + "', '" + pass + "', NOW())";

            sentencia.executeUpdate(sql);

            sentencia.close();
            conexion.close();    
            System.out.println("Se ha añadido el usuario");        
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }

    }
}
