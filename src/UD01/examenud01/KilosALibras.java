package ud01.examenud01;

import java.util.Scanner;

public class KilosALibras {
    public static void main(String[] args) {
        final double KILOS_POR_LIBRA = 0.453592;

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una medida de peso en kilogramos: ");
        double kilos = sc.nextDouble();
        sc.close();


        double libras = kilos / KILOS_POR_LIBRA;

        System.out.printf("%.2f kilos es igual a %.2f libras%n%n", kilos, libras);

    }
}
