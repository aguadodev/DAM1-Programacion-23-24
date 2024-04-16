package ud7.ficherostextoapuntes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class E1005 {
    public static void main(String[] args) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("src\\ud7\\ficherostextoapuntes\\NumerosPorLinea.txt"));
            Scanner s;
            double numero;
            double suma = 0;
            // Lectura anticipada de la primera línea
            String linea = in.readLine();
            // Mientras siga habiendo líneas
            while (linea != null) {
                // Analiza la línea con un Scanner
                s = new Scanner(linea).useLocale(Locale.US); // Utiliza el punto decimal como separador
                // Si hay un número real en la línea, lo suma
                if (s.hasNextDouble()) {
                    numero = s.nextDouble();
                    suma += numero;
                } else {
                    System.out.println("La línea del fichero '" + linea + "' no contiene un número real. Se omitirá.");
                }
                // Lee la siguiente línea
                linea = in.readLine();
            }
            // Muestra la suma
            System.out.println("La suma es: " + suma);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // Si se ha abierto el fichero intenta cerrarlo
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

}
