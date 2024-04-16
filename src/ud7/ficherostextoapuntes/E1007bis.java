package ud7.ficherostextoapuntes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class E1007bis {
    public static void main(String[] args) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("src\\ud7\\ficherostextoapuntes\\Quijote.txt"));) {

            String linea = "En un lugar de La Mancha,";

            // Escribe la línea caracter a caracter;
            for (int i = 0; i < linea.length(); i++)
                out.append(linea.charAt(i));

            // Escribe el salto de línea
            out.newLine();

            linea = "de cuyo nombre no quiero acordarme";
            // Escribe una línea completa
            out.append(linea);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
