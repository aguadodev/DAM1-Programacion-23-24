package ud7.ficherostextoapuntes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E1006bis {
    public static void main(String[] args) {
        // Crea un flujo de entrada con el fichero
        FileInputStream flujo = null;
        try {
            flujo = new FileInputStream("src\\ud7\\ficherostextoapuntes\\Enteros.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Crea un Scanner para analizar el flujo de entrada del fichero
        Scanner sc = new Scanner(flujo);
        int suma = 0;
        int cont = 0;
        while (sc.hasNextInt()) {
            cont++;
            suma += sc.nextInt();
        }

        System.out.println("Suma = " + suma);
        System.out.printf("Media = %.2f", ((double) suma / cont));
    }
}
