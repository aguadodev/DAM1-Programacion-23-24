package ud2.buclesapuntes;

import java.util.Scanner;

public class E0304 {
    public static void main(String[] args) {
        int numArbol = 0;
        int altura = 0;
        int alturaMaxima = -1;
        int numArbolMasAlto = -1;
        Scanner sc = new Scanner(System.in);

         do {
            System.out.print("Introduce la altura en centímetros del árbol número " + numArbol + " (-1 para terminar): ");
            altura = sc.nextInt();

            if (altura > alturaMaxima) {
                alturaMaxima = altura;
                numArbolMasAlto = numArbol;
            }
            numArbol++;
        }  while (altura != -1);

        if (alturaMaxima != -1) {
            System.out.println("El árbol más alto es el número " + numArbolMasAlto +
                    " con una altura de " + alturaMaxima + " centímetros.");
        } else {
            System.out.println("No has introducido ninguna altura.");
        }

        sc.close();
    }
}
