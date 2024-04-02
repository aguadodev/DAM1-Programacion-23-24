package ud6.coleccionesejercicios;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class EP1222 {
    public static void main(String[] args) {
        // Colección de nombres no repetidos ordenados por orden de inserción.
        // Se implementa con un LinkedHashSet
        Collection<String> nombres = new LinkedHashSet<>();
        String nombre;

        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe nombres para añadir a la colección. \"fin\" para terminar: ");
        nombre = sc.nextLine();
        
        while (!"fin".equals(nombre)) {
            nombres.add(nombre);
            nombre = sc.nextLine();
        }

        System.out.println(nombres.toString());

    }
}
