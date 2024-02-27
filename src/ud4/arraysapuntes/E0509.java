package ud4.arraysapuntes;

import java.util.Arrays;
import java.util.Scanner;

public class E0509 {
    public static void main(String[] args) {
        final int NUM_PROGRAMADORES = 5;
        int[] puntuaciones = new int[NUM_PROGRAMADORES];

        // Leer y almacenar puntuación de 5 programadores
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < puntuaciones.length; i++) {
            System.out.print("Puntuación Programador/a " + i + ": ");
            puntuaciones[i] = sc.nextInt();
        }
        // Mostrar puntuaciones ordenadas
        Arrays.sort(puntuaciones);
        System.out.println(Arrays.toString(puntuaciones));

        // Añadir puntuaciones de programadores de exhibición, hasta introducir -1
        System.out.print("Puntuación programador/a de exhibición (-1 para terminar): ");
        int puntuacion = sc.nextInt();
        while (puntuacion != -1) {
            puntuaciones = Arrays.copyOf(puntuaciones, puntuaciones.length + 1);
            puntuaciones[puntuaciones.length - 1] = puntuacion;

            System.out.print("Puntuación programador/a de exhibición (-1 para terminar): ");
            puntuacion = sc.nextInt();
        }
        sc.close();

        // Mostrar todos ordenados
        Arrays.sort(puntuaciones);
        System.out.println(Arrays.toString(puntuaciones));

    }
}
