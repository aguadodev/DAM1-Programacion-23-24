package ud1.api;

import java.util.Scanner;

public class RaizCuadrada {
    public static void main(String[] args) {
        int numero;

        Scanner sc = new Scanner(System.in);

        numero = sc.nextInt();

        System.out.println("La raíz cuadrada de " + numero + " es " + Math.sqrt(numero));

        System.out.printf("La raíz cuadrada de %d es %.2f", numero, Math.sqrt(numero));

        sc.close();
    }
    
}
