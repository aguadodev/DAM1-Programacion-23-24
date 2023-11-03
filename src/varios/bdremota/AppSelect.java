package varios.bdremota;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class AppSelect {
    public static void main(String[] args) throws Exception {
        System.out.println("Accediendo a BD MySQL");

        String url = "jdbc:mysql://" + Conexion.HOST + ":3306/" + Conexion.DATABASE;
        System.out.println(url);
        Connection conexion = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);

        Statement sentencia = conexion.createStatement();

        ResultSet resultado = sentencia.executeQuery("SELECT * FROM user");

        while (resultado.next()) {
            // Procesa los datos
            int id = resultado.getInt("id");
            String username = resultado.getString("username");
            String password = resultado.getString("password");
            Timestamp createdAt = resultado.getTimestamp("created_at");

            // Procesa los datos
            System.out.println("ID: " + id + ", username: " + username + "(" + password + "), createdAt: " + createdAt);
        }

        resultado.close();
        sentencia.close();
        conexion.close();
    }
}
