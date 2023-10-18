package UD02.condicionalesapuntes;

import java.util.Scanner;

public class Bisiesto {public static void main(String[] args) {
    // Declaración de variables y constantes
    int anho;
    boolean esBisiesto = false;
        
    // Entrada de datos
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce un año:");
    anho = sc.nextInt();
    sc.close();

    // Proceso con if's anidados
    if (anho % 4 == 0) {
        if (anho % 100 != 0) {
            esBisiesto = true;
        } else {
            if (anho % 400 == 0) {
                esBisiesto = true;
            }
        }
    }

    // Proceso en una única sentencia
    // esBisiesto = (anho % 4 == 0) && ((anho % 100 != 0) || (anho % 400 == 0));
       
    // Salida
    if (esBisiesto) {
        System.out.println("El año " + anho + " es bisiesto.");
    } else {
        System.out.println("El año " + anho + " NO es bisiesto.");
    }        
}

}
