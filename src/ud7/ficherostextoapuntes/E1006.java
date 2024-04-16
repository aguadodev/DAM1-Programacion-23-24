package ud7.ficherostextoapuntes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class E1006 {
    public static void main(String[] args) {
        BufferedReader in = null;
        int suma = 0; 
        int cont = 0;
        try {
            in = new BufferedReader(new FileReader("src\\ud7\\ficherostextoapuntes\\Enteros.txt"));

            String linea = in.readLine();
            while (linea != null) {
                Scanner sc = new Scanner(linea);
                while (sc.hasNextInt()){
                    cont++; 
                    suma += sc.nextInt();
                }
                linea = in.readLine();
            }

            System.out.println("Suma = " + suma);
            System.out.printf("Media = %.2f", ((double) suma / cont));          

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
