package praiasdegalicia;

import java.util.Arrays;

public class AppClase {
    public static void main(String[] args) {
        // Carga las playas desde el fichero JSON en un array de Praias
        Praia[] praias = Util.importarPraias("praias.json");

        // Ordenar por método natural (id)
        Arrays.sort(praias);

        // muestra 
        System.out.println("\n\nPRAIAS ORDENADAS POR id");
        System.out.println("=======================");
        Praia.imprimirLista(praias, 10);

        // Buscar una playa por id y la muestra
        int id = 2181;
        int pos = Arrays.binarySearch(praias, new Praia(id));

        System.out.println("\nPRAIA CON id = " + id + " - " + praias[pos]);

        System.out.print("\nDetalles: ");
        praias[pos].mostrarDetalles();

        System.out.println();

    }
}
