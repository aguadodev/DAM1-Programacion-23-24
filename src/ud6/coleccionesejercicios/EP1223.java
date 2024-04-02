package ud6.coleccionesejercicios;

import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class EP1223 {

    public static void main(String[] args) {
        // Colección de nombres no repetidos ordenados por orden alfabético.
        // Se implementa igual que la actividad EP1222 pero con un TreeSet
        Collection<String> nombres = new TreeSet<>();
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
