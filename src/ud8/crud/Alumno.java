package ud8.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Alumno {
    int id;
    String nombre;
    LocalDate fechaNac;
    double nota1, nota2, nota3;
    String curso;
    LocalDateTime createdAt;

    public Alumno() {
    }

    public Alumno(int id) {
        this.id = id;
    }

    public Alumno(int id, String nombre, LocalDate fechaNac, double nota1, double nota2, double nota3, String curso,
            LocalDateTime createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.curso = curso;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Alumno [id=" + id + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", nota1=" + nota1 + ", nota2="
                + nota2 + ", nota3=" + nota3 + ", curso=" + curso + ", createdAt=" + createdAt + "]";
    }

    public boolean create() {
        boolean create = true;

        Connection con = conectarBD();

        String sql = "INSERT INTO Alumno (id, nombre, fechaNac, nota1, nota2, nota3, curso, createdAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setInt(1, this.id);
            consulta.setString(2, this.nombre);
            consulta.setDate(3, Date.valueOf(fechaNac));
            consulta.setDouble(4, this.nota1);
            consulta.setDouble(5, this.nota2);
            consulta.setDouble(6, this.nota3);
            consulta.setString(7, this.curso);
            consulta.setTimestamp(8, Timestamp.valueOf(this.createdAt));
            consulta.executeUpdate();

        } catch (SQLException e) {
            create = false;
        }

        return create;
    }


    public static Alumno read(int id) {
        Alumno alumno = null;

        Connection con = conectarBD();

        String sql = "SELECT * FROM Alumno WHERE id = ?";

        try {
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setInt(1, id);
            ResultSet rs = consulta.executeQuery();
            if (rs.next()){
                alumno = new Alumno(id);
                alumno.nombre = rs.getString("nombre");
                alumno.fechaNac = rs.getDate("fechaNac").toLocalDate();
                alumno.nota1 = rs.getDouble("nota1");
                alumno.nota2 = rs.getDouble("nota2");
                alumno.nota3 = rs.getDouble("nota3");
                alumno.curso = rs.getString("curso");
                alumno.createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
            }
                
        } catch (SQLException e) {
            
        }

        return alumno;            

    }

    public boolean update(){
        boolean update = true;

        Connection con = conectarBD();

        String sql = "UPDATE Alumno SET nombre = ?, fechaNac = ?, nota1 = ?, nota2 = ?, nota3 = ?, curso = ? WHERE id = ?";

        try {
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setString(1, this.nombre);
            consulta.setDate(2, Date.valueOf(fechaNac));
            consulta.setDouble(3, this.nota1);
            consulta.setDouble(4, this.nota2);
            consulta.setDouble(5, this.nota3);
            consulta.setString(6, this.curso);
            consulta.setInt(7, this.id);
            consulta.executeUpdate();

        } catch (SQLException e) {
            update = false;
        }

        return update;        
    }

    public boolean delete() {
        boolean delete = true;

        Connection con = conectarBD();

        String sql = "DELETE FROM Alumno WHERE id = ?";

        try {
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setInt(1, this.id);
            consulta.executeUpdate();

        } catch (SQLException e) {
            delete = false;
        }

        return delete;
    }

    static private Connection conectarBD() {
        Connection con;
        String url = "jdbc:mysql://" + BD.HOST + "/" + BD.DATABASE;
        try {
            return DriverManager.getConnection(url, BD.USER, BD.PASSWD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // CREATE
        Alumno a = new Alumno(34, "Pruebas", LocalDate.of(2000, 11, 23), 6, 7, 8, "1B", LocalDateTime.now());
        if (a.create())
            System.out.println("El alumno se ha añadido correctamente en la BD: \n" + a);
        else
            System.out.println("ERROR: El alumno NO se ha podido insertar en la BD: \n" + a);

        // UPDATE
        a.nombre = "PRUEBAS MOD";
        a.nota1 = 10;
        a.nota2 = 10;
        a.nota3 = 10;
        if (a.update())
            System.out.println("El alumno se ha modificado correctamente en la BD: \n" + a);
        else
            System.out.println("ERROR: El alumno NO se ha podido modificar en la BD: \n" + a);

        // READ     
        Alumno a2 = Alumno.read(34);
        if (a2 != null)
            System.out.println("Alumno leído de la BD:\n" + a2);
        else
            System.out.println("ERROR: El alumno NO se ha podido leer de la BD: \n" + a);

        // DELETE
        Alumno a3 = new Alumno(34);
        if (a3.delete())
            System.out.println("El alumno se ha borrado correctamente en la BD: \n" + a);
        else
            System.out.println("ERROR: El alumno NO se ha podido borrar en la BD: \n" + a);

    }


}
