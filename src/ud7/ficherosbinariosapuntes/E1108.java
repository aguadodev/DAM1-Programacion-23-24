package ud7.ficherosbinariosapuntes;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import ud7.ficherostextoapuntes.Socio;

public class E1108 {
    public static void main(String[] args) {
        Socio[] socios = {
                new Socio(1, "Juan", "Calle Chan do Monte", "01/01/2021"),
                new Socio(2, "Ana", "Calle Marín", "01/01/2022"),
                new Socio(3, "Luis", "Calle Vigo", "01/01/2023"),
        };

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("X:\\dam1\\Programación\\UD07\\socios.dat"))) {
            out.writeByte(3);
            out.writeObject(socios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
