package ud7.ficherosbinariosapuntes;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class E1103bis {
    public static void main(String[] args) {
        double[] t = null;
         
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("X:\\dam1\\Programación\\UD07\\numerosDouble.dat"))) {
            t = (double[]) in.readObject();
            System.out.println(Arrays.toString(t));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
