package ud02.condicionalesapuntes;

import java.util.Scanner;

public class E0204 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        double numero;
        boolean casiCero = false;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número decimal:");
        numero = sc.nextDouble();
        sc.close();

        // Proceso
        if (numero != 0) {
            if (numero > -1) {
                if (numero < 1) {
                    casiCero = true;
                }
            }
        }

        /*
         * Resulsin ifs anidados
         * casiCero = numero != 0 && numero > -1 && numero < 1;
         */

        // Salida
        if (casiCero) {
            System.out.println("El numero " + numero + " es casi-cero.");
        } else {
            System.out.println("El numero " + numero + " NO es casi-cero.");
        }

    }
}
