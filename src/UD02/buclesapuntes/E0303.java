package ud02.buclesapuntes;

import java.util.Scanner;

public class E0303 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        final int NUM_MAXIMO = 100;
        int numSecreto = (int) (Math.random() * NUM_MAXIMO + 1);
        int numUsuario;
        boolean numeroAcertado = false;
        boolean usuarioRendido = false;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.println("ADIVINA EL NÚMERO SECRETO (1-" + NUM_MAXIMO + ")");

        do {
            // Cuerpo del bucle
            // Leer número
            System.out.println("Introduce un número: ");
            numUsuario = sc.nextInt();

            // Comparar con número secreto
            if (numUsuario == -1) {
                System.out.println("Te has rendido...");
                usuarioRendido = true;
            } else {
                if (numUsuario > numSecreto) {
                    System.out.println("Demasiado alto!");
                } else if (numUsuario < numSecreto) {
                    System.out.println("Demasiado bajo!");
                } else {
                    System.out.println("Acertaste Enhorabuena!!");
                    numeroAcertado = true;
                }
            }
        } while (!numeroAcertado && !usuarioRendido);
        sc.close();
    }
}
