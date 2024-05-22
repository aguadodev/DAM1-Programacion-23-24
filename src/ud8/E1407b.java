package ud8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class E1407b {

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
            try {
                borrarAlumno(conexionBD, nombre);
            } catch (Exception e) {
                e.printStackTrace();
            }
            conexionBD.close();
        }

    }

    static void borrarAlumno(Connection con, String nombre) throws SQLException {
        String sql = "DELETE FROM Alumno "
                + " WHERE nombre = ?";
        PreparedStatement consulta = con.prepareStatement(sql);
        consulta.setString(1, nombre);

        if (consulta.executeUpdate() > 0)
            System.out.println("Se ha borrado el alumno");
        else {
            System.out.println("No se ha borrado nada");
        }

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
