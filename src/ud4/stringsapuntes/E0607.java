package ud4.stringsapuntes;

import java.util.Scanner;

public class E0607 {
    
    public static void main(String[] args) {
        // Declaración de variables y constantes
        Scanner sc = new Scanner(System.in);
        String frase, palabra;
        int veces = 0;

        // Entrada de datos
        System.out.print("Frase: ");
        frase = sc.nextLine();
        System.out.print("Palabra: ");
        palabra = sc.nextLine();
        sc.close();

        // Resolución con split()
        /*
         * String[] palabras;
         * palabras = frase.split(" ");
         * 
         * for (int i = 0; i < palabras.length; i++) {
         * if (palabras[i].equals(palabra)) {
         * veces++;
         * }
         * }
         */

        // Resolución con indexOf()
        int posicion, posBusqueda = 0;
        do {
            // Proceso
            posicion = frase.indexOf(palabra, posBusqueda);
            if (posicion != -1) {
                System.out.println("\"" + palabra + "\" se encuentra en la posición " +
                        posicion + " de la frase \"" + frase + "\"");
                posBusqueda = posicion + 1;
                veces++;
            }
        } while (posicion != -1);

        if (veces == 0) {
            System.out.println("\"" + palabra + "\" no se encuentra en la frase \"" + frase + "\"");
        } else {
            System.out.println("La palabra se ha encontrado " + veces + " veces.");
        }

    }

}
