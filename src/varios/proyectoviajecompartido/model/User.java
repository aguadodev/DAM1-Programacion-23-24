package varios.proyectoviajecompartido.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import varios.proyectoviajecompartido.CifradoBcrypt;
import varios.proyectoviajecompartido.Conexion;

public class User {
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private boolean enabled;

    public User(String username, String password, String email, LocalDateTime createdAt, LocalDateTime lastLogin,
            boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.enabled = enabled;
    }

    public User(String username, String password, String email, boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = LocalDateTime.now();
        this.enabled = enabled;
    }

    public User(String username, String password) {
        this(username, password, null, true);
    }

    public User(String username) {
        this(username, null);
    }

    @Override
    public String toString() {
        return username;
    }

    /*
     * FUNCIONES DE ACCESO A LA BASE DE DATOS
     */

    public static User loginUsuario(String username, String password) {
        User user = null;

        Connection conexion = Conexion.conectar();

        Statement sentencia;
        try {
            sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM USER WHERE username LIKE '" + username + "'");

            if (resultado.next()) {
                // Si existe el usuario valida la contraseña con BCrypt
                if (CifradoBcrypt.validarHash2Y(password, resultado.getString("password"))) {
                    // Si la contraseña es válida crea el objeto User
                    user = new User(resultado.getString("username"), resultado.getString("password"),
                            resultado.getString("email"), resultado.getBoolean("enabled"));
                    // Obtener createdAt
                    user.createdAt = resultado.getTimestamp("created_at").toLocalDateTime();
                    // Actualizar lastLogin
                    user.lastLogin = LocalDateTime.now();
                    // Guardar lastLogin en la BD
                    sentencia.executeUpdate("UPDATE USER SET last_Login = '" + user.lastLogin
                            + "' WHERE username LIKE '" + username + "'");
                }
            }

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

}
