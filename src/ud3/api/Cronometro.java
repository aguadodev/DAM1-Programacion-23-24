package ud3.api;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Cronometro {
    public static void main(String[] args) {
        System.out.println("Cronómetro. Pulsa Enter para empezar...");

        // Horas
        LocalDateTime horaInicio, horaActual, horaParcial = null;
        ;
        Scanner sc = new Scanner(System.in);

        // Leer entrada y registrar el tiempo de inicio
        String entrada = sc.nextLine();
        horaInicio = LocalDateTime.now();
        System.out.println("Hora de inicio: " + horaInicio);

        System.out.println("Cronómetro en marcha. "
                + "\n- Pulsa Enter para registrar un nuevo tiempo."
                + "\n- Introduce un cero '0' para terminar");

        // Leer nueva entrada
        entrada = sc.nextLine();
        horaActual = LocalDateTime.now();
        System.out.println("Hora Parcial: " + horaActual);

        while (entrada.isEmpty() || entrada.charAt(0) != '0') {
            // Calcular tiempo desde el inicio (horaInicio, horaActual)
            System.out.println("Tiempo desde el inicio: " + mostrarTiempoTranscurrido(horaInicio, horaActual));

            // Calcular tiempo desde el último registro (horaParcial) horaActual)
            if (horaParcial != null) {
                System.out.println("Tiempo parcial: " + mostrarTiempoTranscurrido(horaParcial, horaActual));
            }
            horaParcial = LocalDateTime.now();

            // Volver a leer
            entrada = sc.nextLine();
            horaActual = LocalDateTime.now();
            System.out.println("Hora Parcial: " + horaActual);
        }
    }

    private static String mostrarTiempoTranscurrido(LocalDateTime horaInicio, LocalDateTime horaActual) {
        long segundos = horaInicio.until(horaActual, ChronoUnit.SECONDS);
        return segundos / 60 + " minutos y " + segundos % 60 + " segundos";
    }

}
