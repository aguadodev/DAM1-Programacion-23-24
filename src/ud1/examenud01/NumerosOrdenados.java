package ud1.examenud01;

import java.util.Scanner;

public class NumerosOrdenados {
    public static void main(String[] args) {
        int a, b, c;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce 3 números enteros: ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        sc.close();


        System.out.println("RESULTADO");

        boolean ordenadosMenorMayor = a <= b && b <= c;
        boolean ordenadosMayorMenor = a >= b && b >= c;

        System.out.print(ordenadosMenorMayor ? "Ordenados de menor a mayor\n" : "");
        System.out.print(ordenadosMayorMenor ? "Ordenados de mayor a menor\n" : "");
        System.out.println(!ordenadosMenorMayor && !ordenadosMayorMenor ? "Números desordenados" : "");        
        
    }
}
