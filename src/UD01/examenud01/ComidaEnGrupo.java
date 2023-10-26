package UD01.examenud01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ComidaEnGrupo {
    public static void main(String[] args) {
        // DECLARACION DE VARIABLES
        int numeroPersonas;
        double importeTotal;
        double importePorPersona;

        Scanner sc = new Scanner(System.in);
        //sc.useLocale(Locale.US);

        // ENTRADA
        System.out.print("Número de personas: ");
        numeroPersonas = sc.nextInt();

        System.out.print("Importe total de la comida (€): ");
        importeTotal = sc.nextDouble();
        sc.close();


        // PROCESO
        importePorPersona = importeTotal / numeroPersonas;

        DecimalFormat df = new DecimalFormat("#.00");

        // SALIDA
        System.out.println("Cantidad a pagar por comensal: " + df.format(importePorPersona) + " €");
    
    }
}
