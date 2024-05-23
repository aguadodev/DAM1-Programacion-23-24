package ud8.jdbcapuntes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class E1404 {

    public static void main(String[] args) throws Exception {
        System.out.println("Alumnado y Notas medias:");
        System.out.println("========================");

        Connection conexionBD = conectarBD();
        if (conexionBD == null) {
            System.out.println("Error al conectar con la BD");
        } else {
            // Trabajar con la BD...
            mostrarInfoCurso(conexionBD, "1B");
            conexionBD.close();
        }

    }

    static void mostrarInfoCurso(Connection con, String curso) throws SQLException {
        Statement consulta = con.createStatement();
        String sql = "SELECT nombre, createdAt, nota1, nota2, nota3 FROM Alumno "
                + " WHERE curso = '" + curso + "' "
                + " ORDER BY nombre DESC";
        ResultSet rs = consulta.executeQuery(sql);

        while (rs.next()) {
            String nombre = rs.getString(1);
            LocalDateTime createdAt = Instant.ofEpochMilli(rs.getDate(2).getTime())
                    .atZone(ZoneId.systemDefault()).toLocalDateTime();
            double notaMedia = (rs.getDouble(3) + rs.getDouble(4) + rs.getDouble(5)) / 3;
            System.out.println(nombre + " (" + createdAt + ") " + ((int) (notaMedia * 100)) / 100.0);

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
