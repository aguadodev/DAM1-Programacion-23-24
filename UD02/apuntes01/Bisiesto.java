package UD02.apuntes01;

import java.util.Scanner;

public class Bisiesto {public static void main(String[] args) {
    // Declaración de variables y constantes
    int anho;
    boolean bisiesto;
        
    // Entrada de datos
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce un año:");
    anho = sc.nextInt();
    sc.close();

    // Proceso
    bisiesto = (anho % 4 == 0) && ((anho % 100 != 0) || (anho % 400 == 0));
       
    // Salida
    if (bisiesto) {
        System.out.println("El año " + anho + " es bisiesto.");
    } else {
        System.out.println("El año " + anho + " NO es bisiesto.");
    }        
}

}
