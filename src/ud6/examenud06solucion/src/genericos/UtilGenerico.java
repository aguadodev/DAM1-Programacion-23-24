package genericos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * UtilGenerico
 */
public class UtilGenerico {

    static <T> Collection<T> sinRepetidos(Collection<T> coleccion) {
        return new LinkedHashSet<>(coleccion);
    }

    static <T> Map<T, Integer> contarRepetidos(Collection<T> coleccion) {
        Map<T, Integer> contarRepetidos = new LinkedHashMap<>();
        for (T elemento : coleccion)
            if (contarRepetidos.containsKey(elemento))
                contarRepetidos.put(elemento, contarRepetidos.get(elemento) + 1);
            else
                contarRepetidos.put(elemento, 1);
        return contarRepetidos;
    }

    static <K, V> Map<K, V> iniciarMapa(Set<K> claves, List<V> valores) {
        Map<K, V> mapa = new TreeMap<>();
        int i = 0;
        for (K clave : claves) {
            V valor = i < valores.size() ? valores.get(i) : null;
            mapa.put(clave, valor);
            i++;
        }
            
        return mapa;
    }

    public static void main(String[] args) {

        Collection<Integer> coleccion = new LinkedList<>();
        coleccion.add(1);
        coleccion.add(2);
        coleccion.add(3);
        coleccion.add(1);
        coleccion.add(2);
        coleccion.add(1);
        coleccion.add(3);
        coleccion.add(1);
        coleccion.add(2);
        coleccion.add(4);

        System.out.println("Colección inicial: " + coleccion);

        // Elimina los elementos repetidos
        System.out.println("sinRepetidos: " + sinRepetidos(coleccion));

        // Cuenta los elementos repetidos
        System.out.println("contarRepetidos: " + contarRepetidos(coleccion));

        // Inicializa un mapa con claves y valores
        Set<String> claves = new TreeSet<>();
        claves.add("a");
        claves.add("c");
        claves.add("b");
        claves.add("d");
        claves.add("e");

        List<String> valores = new ArrayList<>();
        valores.add("1");
        valores.add("2");
        valores.add("3");
        valores.add("4");

        System.out.println("iniciarMapa: " + iniciarMapa(claves, valores));

    }
}