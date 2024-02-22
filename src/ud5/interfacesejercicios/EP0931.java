package ud5.interfacesejercicios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class EP0931 {
    public static void main(String[] args) {
        
        Llamada l1 = new Llamada(
            "986666666", 
            "699999999", 
            true, 
            LocalDateTime.of(2023, 03, 23, 12, 50), 
            LocalDateTime.of(2023, 03, 23, 13, 50), 
            Llamada.Zona.ZONA_A);

            Llamada l2 = new Llamada(
                "986666666", 
                "699999999", 
                true, 
                LocalDateTime.of(2023, 03, 23, 10, 00), 
                LocalDateTime.of(2023, 03, 23, 10, 30), 
                Llamada.Zona.ZONA_E);

                
                Llamada l3 = new Llamada(
                    "981111111", 
                    "699999999", 
                    false, 
                    LocalDateTime.of(2023, 03, 23, 12, 50), 
                    LocalDateTime.of(2023, 03, 23, 13, 50), 
                    Llamada.Zona.ZONA_C);
        
        List<Llamada> llamadas = new ArrayList<>();
        llamadas.add(l1);
        llamadas.add(l2);
        llamadas.add(l3);

        llamadas.sort(Comparator.naturalOrder());

        System.out.println(llamadas);

    }
}

class Llamada implements Comparable<Llamada> {
    String telefonoCliente;
    String telefonoInterlocutor;
    boolean llamadaSaliente;
    LocalDateTime fechaHoraInicio;
    LocalDateTime fechaHoraFin;

    enum Zona {
        ZONA_A, ZONA_B, ZONA_C, ZONA_D, ZONA_E
    }

    Zona zonaInterlocutor;

    static final int[] tarifasZonaMinuto = { 1, 5, 10, 20, 50 };

    @Override
    public int compareTo(Llamada o) {
        int compTelefono = telefonoCliente.compareTo(o.telefonoCliente);
        if (compTelefono != 0)
            return compTelefono;
        else
            return fechaHoraInicio.compareTo(o.fechaHoraInicio);
    }

    public Llamada(String telefonoCliente, String telefonoInterlocutor, boolean llamadaSaliente,
            LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Llamada.Zona zonaInterlocutor) {
            
        this.telefonoCliente = telefonoCliente;
        this.telefonoInterlocutor = telefonoInterlocutor;
        this.llamadaSaliente = llamadaSaliente;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.zonaInterlocutor = zonaInterlocutor;
    }

    int duracionMinutos() {
        return (int) fechaHoraInicio.until(fechaHoraFin, ChronoUnit.MINUTES);
    }

    int coste() {
        if (llamadaSaliente)
            return duracionMinutos() * tarifasZonaMinuto[zonaInterlocutor.ordinal()];
        else
            return 0;
    }

    @Override
    public String toString() {
        return telefonoCliente + " -> " + telefonoInterlocutor
                + " FechaHora: " + fechaHoraInicio + " (" + duracionMinutos() + " min. - " + coste()/100.0 + " €) \n";
    }

}
