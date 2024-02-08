package varios.pendentes2324.ejercicio3;

import java.time.LocalDate;

public class CursoDistancia extends Curso{
    String plataforma;

    public CursoDistancia(int id, String nombre, String descripcion, int duracion, LocalDate fechaInicio,
            LocalDate fechaFin, String plataforma) {
        super(id, nombre, descripcion, duracion, fechaInicio, fechaFin);
        this.plataforma = plataforma;
    }

    
}
