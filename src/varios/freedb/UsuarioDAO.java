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
                Timestamp createdAt = resultado.getTimestamp("created_at");

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
                // Si existe el usuario valida la contraseña con BCrypt
                byte[] passwordHashed = resultado.getString("password").getBytes(StandardCharsets.UTF_8);
                BCrypt.Result resultStrict = BCrypt.verifyer(BCrypt.Version.VERSION_2Y).verifyStrict(
                        password.getBytes(StandardCharsets.UTF_8),
                        passwordHashed);
                loginOk = resultStrict.verified;
                loginOk = validarHash2Y(password, resultado.getString("password"));
            }

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginOk;

    }

    public static boolean validarHash2Y(String password, byte[] hash2y){
        return BCrypt.verifyer(BCrypt.Version.VERSION_2Y)
        .verifyStrict(password.getBytes(StandardCharsets.UTF_8), hash2y)
        .verified;
    }
    public static boolean validarHash2Y(String password, String hash2y){
        return BCrypt.verifyer(BCrypt.Version.VERSION_2Y)
        .verifyStrict(password.getBytes(StandardCharsets.UTF_8), hash2y.getBytes(StandardCharsets.UTF_8))
        .verified;
    }

    public static byte[] generarHash2Y(String password){
        return BCrypt.with(BCrypt.Version.VERSION_2Y).hash(13, password.getBytes(StandardCharsets.UTF_8));
    }

    public static String generarStringHash2Y(String password){
        char[] bcryptChars = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToChar(13, password.toCharArray());
        return String.valueOf(bcryptChars);
    }



    public static void main(String[] args) {
        /*
        // TODO: Cronometrar el tiempo que tarda cada método. Depende del coste al generar el hash
        String password = "abc123.,";
        System.out.println("Hash de bytes[]: " + generarHash2Y(password));
        System.out.println("Hash de String: " + generarStringHash2Y(password));
        System.out.println(validarHash2Y(password, generarHash2Y(password)));
        System.out.println(validarHash2Y(password, generarStringHash2Y(password)));*/

        
        listarUsuarios();
        System.out.println("Login OK?: " + loginUsuario("mcostcruz", "mcostcruz"));
        /*System.out.println("Login OK?: " + loginUsuario("oscar", "oscar123.,"));
        */
    }

}
