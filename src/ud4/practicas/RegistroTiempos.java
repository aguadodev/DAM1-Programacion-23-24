package ud4.practicas;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class RegistroTiempos {
    public static void main(String[] args) {
        int[] tiempos = new int[0];
        LocalTime horaInicio;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nRegistro de tiempos");
        System.out.println("===================\n");

        System.out.println(
                "Contando el tiempo desde el inicio de la ejecución. "
                        + "Pulsa la tecla Enter para registrar un nuevo tiempo."
                        + " Introduce una \'f\' o una \'F\' para registrar el último tiempo:");
        horaInicio = LocalTime.now();

        // Usamos un bucle do-while y no un while con lectura anticipada porque
        // en este problema tenemos que procesar también el caso del valor centinela
        // ('f', 'F')
        String entrada;
        do {
            // Lectura entrada
            entrada = sc.nextLine();
            // Procesar entrada
            LocalTime horaActual = LocalTime.now();
            int segundos = horaActual.toSecondOfDay() - horaInicio.toSecondOfDay();
            tiempos = Arrays.copyOf(tiempos, tiempos.length + 1);
            tiempos[tiempos.length - 1] = segundos;
            System.out.println(segundos + " segundos transcurridos");
        } while (entrada.isEmpty() || (entrada.charAt(0) != 'f' && entrada.charAt(0) != 'F'));

        sc.close();

        System.out.println(Arrays.toString(tiempos));

        double media = media(tiempos);
        System.out.println("Media de tiempos: " + media);

        System.out.println("Elementos mayores que la media: " + mayoresQue(tiempos, media));

    }

    private static int mayoresQue(int[] t, double valor) {
        int cont = 0;

        if (t != null) {
            for (int i = 0; i < t.length; i++) {
                if (t[i] > valor)
                    cont++;
            }
        }

        return cont;
    }

    private static double media(int[] t) {
        int media = 0;

        for (int i = 0; i < t.length; i++) {
            media += t[i];
        }

        return media == 0 ? 0 : (double) media / t.length;

    }
}
