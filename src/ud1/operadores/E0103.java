package ud1.operadores;

import java.util.Scanner;

public class E0103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        byte edad;

        // Pedir la edad al usuario
        System.out.print("Escribe tu edad: ");
        edad = sc.nextByte();
        sc.close();


        // Calcular la nueva edad
        edad++;

        // Mostrar salida
        System.out.println("El año que viene tendrás " + edad + " años.");
    }
}
