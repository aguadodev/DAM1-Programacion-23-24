package ud4.stringsapuntes;

import java.util.Arrays;

public class E0612 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        String palabra1 = "roma", palabra2 = "amores";

        // Salida
        System.out.println(sonAnagramas(palabra1, palabra2));

    }

    static boolean sonAnagramas(String palabra1, String palabra2) {
        boolean sonAnagramas = false; // por defecto no son anagramas

        // Convertir palabras a arrays de caracteres
        char[] p1Array = palabra1.toCharArray();
        char[] p2Array = palabra2.toCharArray();

        // Ordenar palabras
        Arrays.sort(p1Array);
        Arrays.sort(p2Array);

        // Comparar arrays
        if (Arrays.equals(p1Array, p2Array))
            // Si son iguales son anagramas
            sonAnagramas = true;

        return sonAnagramas;
    }

}
