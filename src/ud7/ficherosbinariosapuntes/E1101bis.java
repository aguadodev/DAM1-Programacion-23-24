package ud7.ficherosbinariosapuntes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class E1101bis {
    public static void main(String[] args) {
        // Escribe 10 números enteros e un fichero binario
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\ud7\\ficherosbinariosapuntes\\datos.dat"))) {
            out.writeObject(numeros);
        } catch (IOException ex) {
            System.out.println("Escribiendo... Error Entrada/Salida");
        }
    }
}
