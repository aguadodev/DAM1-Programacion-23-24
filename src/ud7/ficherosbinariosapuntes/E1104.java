package ud7.ficherosbinariosapuntes;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class E1104 {
    public static void main(String[] args) {
        // Lee los números enteros de un fichero binario
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\ud7\\ficherosbinariosapuntes\\datos.dat"))) {
            while (true) {
                System.out.println(in.readInt());
            }
        } catch (EOFException ex) {
            System.out.println("Leyendo... Excepción fin de fichero");
        } catch (FileNotFoundException ex) {
            System.out.println("Leyendo... Error No se encuentra el fichero");
        } catch (IOException ex) {
            System.out.println("Leyendo... Error Entrada/Salida");
        }
    }
}
