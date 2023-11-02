package varios.freedb;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class UsuarioDAO {
    private static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://" + Conexion.HOST + ":3306/" + Conexion.DATABASE;

        try {
            con = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD.");
        }

        return con;
    }

    public static void listarUsuarios() {
        Connection conexion = conectar();

        Statement sentencia;
        try {
            sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM user");

            while (resultado.next()) {
                // Procesa los datos
                int id = resultado.getInt("id");
                String username = resultado.getString("username");
                String password = resultado.getString("password");
                Timestamp createdAt = resultado.getTimestamp("createdAt");

                // Procesa los datos
                System.out.println(
                        "ID: " + id + ", username: " + username + "(" + password + "), createdAt: " + createdAt);
            }

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean loginUsuario(String username, String password) {
        boolean loginOk = false;
        Connection conexion = conectar();

        Statement sentencia;
        try {
            sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM user WHERE username LIKE '" + username + "'");

            if (resultado.next()) {
                // Procesa los datos
                int id = resultado.getInt("id");
                Timestamp createdAt = resultado.getTimestamp("created_at");
                // String username = resultado.getString("username");
                byte[] passwordHashed = resultado.getString("password").getBytes(StandardCharsets.UTF_8);
                BCrypt.Result resultStrict = BCrypt.verifyer(BCrypt.Version.VERSION_2Y).verifyStrict(password.getBytes(StandardCharsets.UTF_8),
                        passwordHashed);
                loginOk = resultStrict.verified;

                // Procesa los datos
                System.out.println(
                        "ID: " + id + ", username: " + username + "(" + password + "), createdAt: " + createdAt);
            }

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginOk;

    }

    public static void main(String[] args) {
        System.out.println(loginUsuario("oscar", "oscar123.,"));
    }

}
