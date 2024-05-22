package ud8;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class E14b {

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
            Statement consulta = conexionBD.createStatement();

            for (String nombre : lista) {
                double nota1 = Math.random() * 10;
                double nota2 = Math.random() * 10;
                double nota3 = Math.random() * 10;
                String sql = "UPDATE Alumno SET nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3
                        + " WHERE nombre = '" + nombre + "'";
                consulta.executeUpdate(sql);
            }

            conexionBD.close();
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
