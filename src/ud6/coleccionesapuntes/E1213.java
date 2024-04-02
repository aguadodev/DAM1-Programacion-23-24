package ud6.coleccionesapuntes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E1213 {
    // PROGRAMAS PRINCIPALES PARA PROBAR LA CLASE SORTEO
    public static void main(String[] args) {
        Sorteo<Integer> primitiva = new Sorteo<>();

        for (int i = 1; i < 50; i++) {
            primitiva.add(i);
        }

        System.out.println("Premiados: " +
                primitiva.premiados(6).toString());
    }

}


class Sorteo<T> {
    // Atributos
    Set<T> elementos;

    public Sorteo() {
        elementos = new HashSet<>();
    }

    // Métodos
    boolean add(T elemento) {
        return elementos.add(elemento);
    }

    Set<T> premiados(int numPremiados) {
        Set<T> conjuntoRes = new HashSet<>();
        List<T> listaAux;
        listaAux = new ArrayList<>(elementos);
        Collections.shuffle(listaAux);

        for (int i = 0; i < numPremiados; i++)
            conjuntoRes.add(listaAux.get(i));

        return conjuntoRes;
    }
}
