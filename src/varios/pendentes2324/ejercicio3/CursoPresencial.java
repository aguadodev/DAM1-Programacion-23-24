package varios.pendentes2324.ejercicio3;

import java.time.LocalDate;

public class CursoPresencial extends Curso{
    String aula;

    public CursoPresencial(int id, String nombre, String descripcion, int duracion, LocalDate fechaInicio,
            LocalDate fechaFin, String aula) {
        super(id, nombre, descripcion, duracion, fechaInicio, fechaFin);
        this.aula = aula;
    }
}
