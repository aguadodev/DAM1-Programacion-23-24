package ud2.buclesapuntes;

import java.util.Scanner;

public class E0309 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int numero;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número entre 1 y 10: ");
        numero = sc.nextInt();

        // Si el número no es correcto repetimos la entrada de datos
        // while (numero < 1 || numero > 10) {
        while (!(numero >= 1 && numero <= 10)) {
            System.out.println("El número no está entre 1 y 10.");
            System.out.println("Por favor escribe otro número: ");
            numero = sc.nextInt();
        }

        // Proceso & Salida
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " * " + i + " = " + numero * i);
        }
        sc.close();
    }
}
