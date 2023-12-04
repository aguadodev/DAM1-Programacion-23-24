package ud2.examenrec;

import java.util.Scanner;

public class FormacionSoldados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de soldados: ");
        int numSoldados = scanner.nextInt();

        formarFormaciones(numSoldados);

        scanner.close();
    }

    private static void formarFormaciones(int numSoldados) {
        int soldadosRestantes = numSoldados;

        while (soldadosRestantes >= 4) {
            int ladoCuadrado = (int) Math.sqrt(soldadosRestantes);

            int soldadosEnFormacion = ladoCuadrado * ladoCuadrado;
            System.out.println("Formación cuadrada: " + soldadosEnFormacion + " soldados");
            dibujarFormacion(ladoCuadrado);
            soldadosRestantes -= soldadosEnFormacion;
        }

        if (soldadosRestantes > 0) {
            System.out.println("Formación en línea: " + soldadosRestantes + " soldados");
            dibujarFormacionEnLinea(soldadosRestantes);
        } 
    }


    private static void dibujarFormacion(int lado) {
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void dibujarFormacionEnLinea(int soldados) {
        for (int i = 0; i < soldados; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

}


