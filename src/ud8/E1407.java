package ud8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E1407 {

    public static void main(String[] args) throws Exception {
        System.out.println("SQL Injection");

        Connection conexionBD = conectarBD();
        if (conexionBD == null) {
            System.out.println("Error al conectar con la BD");
        } else {
            // Trabajar con la BD...
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre del alumno a borrar: ");
            String nombre = sc.nextLine();
            borrarAlumno(conexionBD, nombre);
            conexionBD.close();
        }

    }

    static void borrarAlumno(Connection con, String nombre) throws SQLException {
        Statement consulta = con.createStatement();
        String sql = "DELETE FROM Alumno "
                + " WHERE nombre = '" + nombre + "'";
        consulta.executeUpdate(sql);

    }

    static private Connection conectarBD() {
        String url = "jdbc:mysql://" + BD.HOST + "/" + BD.DATABASE;
        try {
            return DriverManager.getConnection(url, BD.USER, BD.PASSWD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
