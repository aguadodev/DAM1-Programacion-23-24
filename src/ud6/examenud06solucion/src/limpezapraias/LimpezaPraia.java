package limpezapraias;

import java.io.Serializable;
import java.time.LocalDate;

public class LimpezaPraia implements Serializable {
    // Completa la clase
    String equipo;
    LocalDate fecha;
    int kilosBasura;
    Praia praia;

    public LimpezaPraia(String equipo, LocalDate fecha, int kilosBasura, Praia praia) {
        this.equipo = equipo;
        this.fecha = fecha;
        this.kilosBasura = kilosBasura;
        this.praia = praia;
    }

    @Override
    public String toString() {
        return fecha + " - Equipo = " + equipo + ", kilos recogidos = " + kilosBasura + ", praia = "
                + praia.getNome() + "(" + praia.getId() + ")";
    }


}
