package varios.pendentes2324.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    int id;
    String nombre;
    String descripcion;
    int duracion;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    List<Alumno> alumnosMatriculados;

    public Curso(int id, String nombre, String descripcion, int duracion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.alumnosMatriculados = new ArrayList<Alumno>();
    }

    void matricularAlumno(Alumno alumno) {
        if (LocalDate.now().isBefore(fechaInicio)) {
            alumnosMatriculados.add(alumno);
        }
    }

    int numAlumnosMatriculados() {
        return alumnosMatriculados.size();
    }

    void listarAlumnos() {
        System.out.println("Alumnos matriculados en el curso " + nombre + "(" + numAlumnosMatriculados() + "):");
        for (Alumno alumno : alumnosMatriculados)
            System.out.println("- " + alumno);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Alumno> getAlumnosMatriculados() {
        return alumnosMatriculados;
    }

    public void setAlumnosMatriculados(List<Alumno> alumnosMatriculados) {
        this.alumnosMatriculados = alumnosMatriculados;
    }

}
