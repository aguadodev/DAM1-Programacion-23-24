package ud4.stringsapuntes;

import java.util.Scanner;

public class E0603 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        Scanner sc = new Scanner(System.in);
        String cadInicial, cad;
        boolean acierto = false;

        // Entrada de datos
        System.out.print("Jugador 1. Contraseña: ");
        cadInicial = sc.nextLine();

        do {
            System.out.print("Jugador 2. Acierta la contraseña: ");
            cad = sc.nextLine();
            if (cad.equals(cadInicial)) {
                acierto = true;
                System.out.println("ACERTASTE LA CONTRASEÑA!!");
            } else {
                System.out.println("ERROR. PRUEBA OTRA VEZ.");
            }
        } while (!acierto);
        sc.close();
    }

}
