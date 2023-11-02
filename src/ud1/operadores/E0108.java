package ud1.operadores;

import java.util.Scanner;

public class E0108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        byte edad;

        // Pedir la edad al usuario
        System.out.print("Escribe tu edad: ");
        edad = sc.nextByte();     
        sc.close();


        String textoSalida = edad >= 18 ? "Eres mayor de edad" : "Aún no eres mayor de edad";

        System.out.println(textoSalida);

        //System.out.println("Mayor de edad? " + mayorDeEdad);
    }
}
