package ud4.arraysapuntes;

import java.util.Arrays;
import java.util.Scanner;

public class E0511 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int[] combinacion;
        int[] combUsuario;
        char[] pistas;
        boolean combinacionOK = false;

        // Entrada de datos

        Scanner sc = new Scanner(System.in);
        System.out.println("Longitud de la combinación: ");
        int longitud = sc.nextInt();

        // Genera la combinación secreta
        combinacion = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            combinacion[i] = (int) (Math.random() * 5 + 1);
        }

        // Muestra la combinación secreta?? Para depurar..
        // System.out.println("Combinación: " + Arrays.toString(combinacion));

        // Repetir solicitar combinación hasta que acierte
        while (!combinacionOK) {
            System.out.println("Introduce los " + longitud + " números de la combinación separados por espacios: ");
            combUsuario = new int[longitud];
            pistas = new char[longitud];
            combinacionOK = true;

            for (int i = 0; i < longitud; i++) {
                combUsuario[i] = sc.nextInt();
                if (combUsuario[i] == combinacion[i]) {
                    pistas[i] = '=';
                } else if (combUsuario[i] > combinacion[i]) {
                    pistas[i] = '>';
                    combinacionOK = false;
                } else {
                    pistas[i] = '<';
                    combinacionOK = false;
                }
            }
            if (Arrays.equals(combinacion, combUsuario)) {
                System.out.println("Enhorabuena has acertado la combinación secreta!!");
            } else {
                System.out.println("Sigue probando...  Pistas: " + Arrays.toString(pistas));
            }
        }
        sc.close();
    }
}
