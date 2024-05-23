package ud8.jdbcapuntes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class E1409 {

    public static void main(String[] args) throws Exception {
        System.out.println("Consulta Parametrizada");

        Connection conexionBD = conectarBD();
        if (conexionBD == null) {
            System.out.println("Error al conectar con la BD");
        } else {
            // Trabajar con la BD...
            try {

                System.out.println("Alumnos con Bien:");
                MostrarAlumnadoPorNota(conexionBD, 6, 7);
                System.out.println("Alumnos con Notable:");
                MostrarAlumnadoPorNota(conexionBD, 7, 9);
            } catch (Exception e) {
                e.printStackTrace();
            }
            conexionBD.close();
        }

    }

    static void MostrarAlumnadoPorNota(Connection con, double n1, double n2) throws SQLException {
        String sql = "SELECT * FROM Alumno WHERE nota1 >= ? AND nota1 < ?";
        PreparedStatement consulta = con.prepareStatement(sql);
        consulta.setDouble(1, n1);
        consulta.setDouble(2, n2);
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("nombre") + " - " + rs.getDouble("nota1"));
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
