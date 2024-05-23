package ud8.jpa.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import varios.proyectoviajecompartido.CifradoBcrypt;
import varios.proyectoviajecompartido.Conexion;

@Entity
public class User {
    @Id
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

    public User() {
    }

    @Override
    public String toString() {
        return username;
    }

    /*
     * Getters y Setters
     */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
            // TODO: Cambiar a consulta parametrizada
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM user WHERE username LIKE '" + username + "'");

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

    public static User read(int id) {

        Connection conexion = Conexion.conectar(); // Conectamos con la base de datos

        try {
            // Consulta SQL
            Statement sentencia = conexion.createStatement();
            // TODO: Cambiar a consulta parametrizada
            String sql = "SELECT * FROM USER WHERE id = " + id;

            ResultSet resultado = sentencia.executeQuery(sql);

            if (resultado.next()) {
                LocalDateTime createdAt = resultado.getTimestamp("created_at") == null ? null
                        : resultado.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime lastLogin = resultado.getTimestamp("last_login") == null ? null
                        : resultado.getTimestamp("last_login").toLocalDateTime();
                User user = new User(resultado.getString("username"), resultado.getString("password"),
                        resultado.getString("email"),
                        createdAt, lastLogin,
                        resultado.getBoolean("enabled"));

                return user;
            }
        } catch (SQLException e) {
        }

        return null;
    }

}
