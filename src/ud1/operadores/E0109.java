package ud1.operadores;

import java.util.Scanner;

public class E0109 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe un número: ");
        int numero; 

        numero = sc.nextInt();
        sc.close();

        boolean esPar = numero % 2 == 0;

        System.out.println("Es par? " + esPar);
    }

}