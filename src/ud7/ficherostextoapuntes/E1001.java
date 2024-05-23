package ud7.ficherostextoapuntes;

import java.util.Scanner;

public class E1001 {
    static Integer leerEntero() {
        Integer numero = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        do {
            try {
                numero = sc.nextInt();
            } catch (Exception e) {
                sc.nextLine(); // Vacía el buffer de entrada
                System.out.print("Error de entrada. Prueba otra vez: ");
            }
        } while (numero == null);
        return numero;
    }

    public static void main(String[] args) {
        Integer n = leerEntero();

        System.out.println(n);
    }

}
