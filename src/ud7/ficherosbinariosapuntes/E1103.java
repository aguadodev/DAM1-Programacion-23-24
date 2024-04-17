package ud7.ficherosbinariosapuntes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class E1103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int n = sc.nextInt();

        double[] t = new double[n];
        for(int i = 0; i < n; i++)
            t[i] = Math.random() * 100;
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("X:\\dam1\\Programación\\UD07\\numerosDouble.dat"))) {
            out.writeObject(t);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
