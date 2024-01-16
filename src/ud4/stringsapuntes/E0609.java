package ud4.stringsapuntes;

import java.util.Scanner;

public class E0609 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "Windows-1250");
        String palabra, frase = "";

        // Bucle: leer hasta que se introduzca "fin" en cualquier combinación
        // de mayúsculas y minúsculas.
        System.out.print("Palabra: ");
        palabra = sc.nextLine();

        while (!palabra.toUpperCase().equals("FIN")) {
            // Proceso: concatenar la palabra y un espacio.
            if (!frase.equals("")) {
                frase += " ";
            }
            frase += palabra;
            // Volver a leer
            System.out.print("Palabra: ");
            palabra = sc.nextLine();
        }

        System.out.println("Frase: " + frase);

    }
}
