package ud7.ficherosbinariosapuntes;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class E1105 {
    public static void main(String[] args) {
        // Lee los números enteros de un fichero binario
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\ud7\\ficherosbinariosapuntes\\datos.dat"))) {
            int[] t = null;
            t = (int[]) in.readObject();

            System.out.println(Arrays.toString(t));
        } catch (EOFException ex) {
            System.out.println("Leyendo... Excepción fin de fichero");
        } catch (FileNotFoundException ex) {
            System.out.println("Leyendo... Error No se encuentra el fichero");
        } catch (IOException ex) {
            System.out.println("Leyendo... Error Entrada/Salida");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
