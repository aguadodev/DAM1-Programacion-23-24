package ud7.ficherostextoapuntes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class E1003 {
    public static void main(String[] args){
        String linea = null;
        String contenido = "";
        try {
            FileReader ficheroEntrada = new FileReader("src\\ud7\\ficherostextoapuntes\\E1003.java");
    
            BufferedReader bufferEntrada = new BufferedReader(ficheroEntrada);
            
            linea = bufferEntrada.readLine();
                    
            while (linea != null) {
                contenido += linea + "\n";
                linea = bufferEntrada.readLine();
            }
    
            System.out.println("Contenido de este fichero de código fuente:\n\n" + contenido);
            ficheroEntrada.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el fichero");    
        } catch (IOException ex) {
            System.out.println("Error de Entrada/Salida");
        }
    }
        
}
