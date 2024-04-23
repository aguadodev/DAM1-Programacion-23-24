package ud7.ficherosbinariosapuntes;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

import ud7.ficherostextoapuntes.Socio;

public class E1108Input {
    public static void main(String[] args) {
        // LEE EL FICHERO BINARIO E IMPRIME SUS DATOS
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("X:\\dam1\\Programación\\UD07\\socios.dat"))) {
            in.readByte();
            Socio[] sociosFichero = (Socio []) in.readObject();

            System.out.println(Arrays.toString(sociosFichero));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
