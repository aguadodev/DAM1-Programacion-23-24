package ud3.ejerciciosmath;

import java.util.Scanner;

public class Circulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Radio del círculo/esfera: ");
        double radio = sc.nextDouble();

        System.out.println("Área del círculo: " + areaCirculo(radio));

        System.out.println("Perímetro del círculo: " + perimetroCirculo(radio));

        System.out.println("Volumen de la esfera: " + volumenEsfera(radio));

    }

    private static double volumenEsfera(double radio) {
        return 4 / 3.0 * Math.PI * Math.pow(radio, 3);
    }

    private static double perimetroCirculo(double radio) {
        return 2 * Math.PI * radio;
    }

    private static double areaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }



}
