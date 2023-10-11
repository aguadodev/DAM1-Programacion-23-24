package UD02.apuntes01;

import java.util.Scanner;

public class E0201 {
    public static void main(String[] args) {
    // Declaración de variables y constantes
    int numero;
    boolean par;
        
    // Entrada de datos
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce un número entero:");
    numero = sc.nextInt();
    sc.close();
        
    // Proceso
    par = numero % 2 == 0;
       
    // Salida
    if (par) {
        System.out.println("El número " + numero + " es par.");
    }
        
    if (!par) {
        System.out.println("El número " + numero + " es impar.");
    }       
        
    System.out.println("Fin del programa");
}

}
