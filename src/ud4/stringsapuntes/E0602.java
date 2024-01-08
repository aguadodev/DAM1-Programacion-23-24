package ud4.stringsapuntes;

import java.util.Scanner;

public class E0602 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        Scanner sc = new Scanner(System.in);
        String cad1, cad2;
        int lonCad1, lonCad2;

        // Entrada de datos
        System.out.print("Cadena 1: ");
        cad1 = sc.nextLine();
        System.out.print("Cadena 2: ");
        cad2 = sc.nextLine();
        sc.close();
        
        // Proceso
        lonCad1 = cad1.length();
        lonCad2 = cad2.length();

        // Salida
        if (lonCad1 > lonCad2)
            System.out.println("La cadena más larga es: " + cad1);
        else if (lonCad2 > lonCad1) {
            System.out.println("La cadena más larga es: " + cad2);
        } else {
            System.out.println("Las cadenas tienen la misma longitud.");
        }
    }

}
