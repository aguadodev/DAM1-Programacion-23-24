package limpezapraias;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AppEjemplo {
    public static void main(String[] args) {
        // Carga las playas desde el fichero JSON en un array de Praias
        Praia[] praias = Util.importarPraias("praias.json");

        // TODO Resuelve el problema propuesto
        // Ejemplo: Imprime las 10 primeras playas del listado.
        Praia.imprimirLista(praias, 10);



        // Ejemplos de escritura y lectura del mapa de playas y limpiezas en el fichero
        // limpieza.dat

        // Carga en un mapa el contenido del fichero limpieza.dat
        Map<Praia, List<LimpezaPraia>> mapaPlayas = Util.leerFichero("limpeza.dat",
                new TreeMap<Praia, List<LimpezaPraia>>());

        System.out.println(mapaPlayas);

        // Crea una lista de limpiezas de playas
        List<LimpezaPraia> limpezas = new ArrayList<>();
        limpezas.add(new LimpezaPraia());
        limpezas.add(new LimpezaPraia());

        // Añade o actualiza las limpiezas de las playas en el mapa
        mapaPlayas.put(praias[0], limpezas);
        mapaPlayas.put(praias[1], List.of(new LimpezaPraia()));


        // Escribir el mapa de playas y limpiezas en el fichero limpeza.dat
        Util.escribirFichero(mapaPlayas, "limpeza.dat");

    }
}