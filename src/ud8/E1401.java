package ud8;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class E1401 {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, BD!");

        List<String> lista = new ArrayList<>();
        lista.add("Alberto");
        lista.add("Angel");
        lista.add("Alejandro");
        lista.add("Borja");
        lista.add("Xabier");
        lista.add("Marcos");
        lista.add("Óscar");
        lista.add("Carla");
        lista.add("Alfonso");
        lista.add("Jorge");
        lista.add("Jonathan");
        lista.add("Pedro");
        lista.add("Yeray");
        lista.add("Alex");
        lista.add("Diego P");
        lista.add("Rodrigo");
        lista.add("Miguel");
        lista.add("Eloy");
        lista.add("Gonzalo");
        lista.add("Victoria");
        lista.add("David");
        lista.add("Yoel");
        lista.add("Diego");

        Connection conexionBD = conectarBD();
        if (conexionBD == null) {
            System.out.println("Error al conectar con la BD");
        } else {
            // Trabajar con la BD...
            incNotaCurso(conexionBD, "1B", 100);
            conexionBD.close();
        }

    }

    static void incNotaCurso(Connection con, String curso, double incNota) throws SQLException {
        Statement consulta = con.createStatement();
        String sql = "UPDATE Alumno SET "
                + "nota1 = nota1 + " + incNota
                + ", nota2 = nota2 + " + incNota
                + ", nota3 = nota3 + " + incNota
                + " WHERE curso = '" + curso + "'";
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
