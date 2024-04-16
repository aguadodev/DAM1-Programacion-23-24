package ud7.ficherostextoapuntes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class E1007 {
    public static void main(String[] args) {
        BufferedWriter out = null;

        try {
            out  = new BufferedWriter(new FileWriter("src\\ud7\\ficherostextoapuntes\\Quijote.txt"));

            String linea = "En un lugar de La Mancha,";

            // Escribe la línea caracter a caracter;
            for(int i = 0; i < linea.length(); i++)
                out.append(linea.charAt(i));

            // Escribe el salto de línea
            out.newLine();
            
            // Fuerza la escritura del buffer en el fichero
            //out.flush(); 

            linea = "de cuyo nombre no quiero acordarme";
            // Escribe una línea completa
            out.append(linea);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // Intenta cerrar el fichero
            try {
                // Vacía el búffer y cierra el fichero
                out.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
