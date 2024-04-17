package ud7.ficherosbinariosapuntes;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class E1102 {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("src\\ud7\\ficherosbinariosapuntes\\cancionPirata.dat"))) {
            String str = "Con diez cañones por banda,\n";
            str += "viento en popa a toda vela,\n";
            str += "no corta el mar, sino vuela\n";
            str += "un velero bergantin.";

            out.writeObject(str);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
