package ud02.buclesparaninfo;

import java.util.Scanner;

public class EP0314 {
    public static void main(String[] args) {
        int n;
        int numPrimos = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Número: ");
        n = sc.nextInt();
        sc.close();

        System.out.print("Números primos entre 1 y " + n + ": ");
        for (int i = 2; i <= n; i++){
            boolean primo = true;
            for (int j = 2; j < i; j++) {
                // TODO: Optimizar Bucle
                if (i % j == 0)
                    primo = false;
            }
            if (primo) {
                System.out.print(i + " ");
                numPrimos++;
            }                
        }

        if (numPrimos == 0) {
            System.out.println("No hay primos en ese intervalo");
        } else {
            System.out.println("\nHay " + numPrimos + " números primos.");
        }
    }
}
