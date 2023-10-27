package ud2.buclesejercicios;

import java.util.Scanner;

public class Digitos {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        long numero;
        long divisor;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número entre 1 y 9.223.372.036.854.775.808:  ");
        numero = sc.nextInt();
        sc.close();

        // Proceso & Salida
        for (int i = 18; i >= 0; i--) {
            divisor = (long) Math.pow(10, i);
            if (numero / divisor != 0) {
                System.out.println((numero / divisor) % 10);
            }
        }
    }
}
