package ud7.ficherostextoapuntes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class E1004 {
    public static void main(String[] args) {
        String linea = null;
        Double suma = 0.0;
        int cont = 0;
        try {
            FileReader ficheroEntrada = new FileReader("src\\ud7\\ficherostextoapuntes\\NumerosReales.txt");

            BufferedReader bufferEntrada = new BufferedReader(ficheroEntrada);

            linea = bufferEntrada.readLine();

            while (linea != null) {
                String[] numerosStr = linea.split(" ");

                for (String numeroStr : numerosStr) {
                    suma += Double.valueOf(numeroStr);
                    cont++;
                }
                linea = bufferEntrada.readLine();
            }

            System.out.println("Suma: " + suma);
            System.out.println("Media: " + suma / cont);

            ficheroEntrada.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException ex) {
            System.out.println("Error de Entrada/Salida");
        } catch(NumberFormatException ex) {
            System.out.println("Algún dato del fichero no tiene el formato requerido");
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("Ha habido algún otro tipo de problema");
            System.out.println(ex);
        }
    }
}
