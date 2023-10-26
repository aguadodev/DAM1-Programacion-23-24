package ud02.condicionalesapuntes;

import java.util.Scanner;

public class E0209 {
    public static void main(String[] args) {
        int numero;
        int cifras = 1;

        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe un número entre -99999 y 99999: ");
        numero = Math.abs(sc.nextInt());
        sc.close();

        if (numero / 10000 > 0) {
            cifras = 5;
        } else if (numero / 1000 > 0) {
            cifras = 4;
        } else if (numero / 100 > 0) {
            cifras = 3;
        } else if (numero / 10 > 0) {
            cifras = 2;
        }

        System.out.println("Número de cifras: " + cifras);

    }
}
