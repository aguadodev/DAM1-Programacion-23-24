package UD02.apuntes01;

import java.util.Scanner;

public class E0208 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        double a, b, c;
        double discriminante;
        double x1, x2;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el valor del coeficiente 'a': ");
        a = sc.nextDouble();
        System.out.println("Introduce el valor del coeficiente 'b': ");
        b = sc.nextDouble();
        System.out.println("Introduce el valor del coeficiente 'c': ");
        c = sc.nextDouble();
        sc.close();

        // Proceso
        discriminante = Math.pow(b, 2) - 4 * a * c;

        // Salida
        if (discriminante < 0) {
            // no hay soluciones reales
            System.out.println("No hay soluciones reales a la ecuación.");
        } else {
            x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("La ecuación tiene dos soluciones: ");
            System.out.println("- Solución A: " + x1);
            System.out.println("- Solución B: " + x2);
        }
    }
}
