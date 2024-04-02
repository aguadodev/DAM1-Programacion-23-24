package ud6.coleccionesejercicios;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class EP1221 {
    public static void main(String[] args) {
        final int NUM_ELEMENTOS = 20;
        final int MAX_RANDOM = 100;
        // Suponemos que los números han de ser distintos así que definimos la colección
        // como un conjunto ordenado por el inverso del criterio de orden natural de
        // números enteros.
        Collection<Integer> coleccion = new TreeSet<>(Comparator.reverseOrder());

        // Añade elementos aleatorios a la colección (conjunto). Se irán ordenando por el criterio indicado
        do {
            coleccion.add((int) (Math.random() * MAX_RANDOM));
        } while (coleccion.size() < NUM_ELEMENTOS);

        System.out.println(coleccion.toString());
    }
}
