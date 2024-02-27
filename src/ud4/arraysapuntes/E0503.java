package ud4.arraysapuntes;

import java.util.Scanner;

public class E0503 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        Scanner sc = new Scanner(System.in);

        System.out.println("Cuántos números?");
        int numNumeros = sc.nextInt();

        double numeros[] = new double[numNumeros];

        System.out.println("Introduce " + numNumeros + " números: ");

        // Entrada de datos
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextDouble();
        }
        sc.close();

        // Salida
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }

    }
}
