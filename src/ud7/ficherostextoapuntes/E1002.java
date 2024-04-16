package ud7.ficherostextoapuntes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class E1002 {
    public static void main(String[] args){
        String contenido = "";
        try {
            FileReader ficheroEntrada = new FileReader("prueba.txt");
    
            int ch = ficheroEntrada.read();  
            while (ch != -1) {
                contenido += (char) ch;
                ch = ficheroEntrada.read();  
            }
    
            System.out.println("Contenido del fichero: " + contenido);
            ficheroEntrada.close();
    
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException ex) {
            System.out.println("Error al leer el fichero");
        }
    }
    
}
