package ud6.coleccionesapuntes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class E1216 {

    // PROGRAMA PRINCIPAL
    public static void main(String[] args) {
        // Declaración del mapa de la academia
        Map<Character, Academico> academia;
        // Creación del mapa con ordenación por clave
        academia = new TreeMap<>();

        // Inserción de nuevos académicos
        Academico.nuevoAcademico(academia, new Academico("Juan", 2015), 'A');
        Academico.nuevoAcademico(academia, new Academico("María", 2007), 'C');
        Academico.nuevoAcademico(academia, new Academico("Pedro", 2010), 'Ñ');
        Academico.nuevoAcademico(academia, new Academico("Lola", 2013), 'V');
        Academico.nuevoAcademico(academia, new Academico("Alba", 1999), 'm');

        System.out.println("Academia: " + academia);

        // Genera una vista de los valores y la inserta en un ArrayList para poder
        // ordenar después
        List<Academico> academicos = new ArrayList(academia.values());

        System.out.println("Valores (Académicos): " + academicos);

        // Ordena los académicos por nombre
        // Usa una clase anónima Comparator pero podría implementarse como método natural
        academicos.sort(new Comparator<Academico>() {
            @Override
            public int compare(Academico o1, Academico o2) {
                return o1.nombre.compareTo(o2.nombre);
            }
        });

        System.out.println("Valores (Académicos por nombre): " + academicos);

        // Ordena los académicos por año de ingreso
        academicos.sort(new Comparator<Academico>() {
            @Override
            public int compare(Academico o1, Academico o2) {
                return o1.anhoIngreso - o2.anhoIngreso;
            }
        });

        System.out.println("Valores (Académicos por año de ingreso): " + academicos);

        // Genera e imprime una vista de entradas.
        Set<Map.Entry<Character, Academico>> entradas = academia.entrySet();

        System.out.println("Vista de entradas: " + entradas);

        // Para ordenar esta vista habría que convertirla en una lista e implementar el comparador adecuado.
        List<Map.Entry<Character, Academico>> listaEntradas = new ArrayList<>(entradas);
        listaEntradas.sort(new Comparator<Map.Entry<Character, Academico>>() {
            @Override
            public int compare(Map.Entry<Character, Academico> o1, Map.Entry<Character, Academico> o2) {
                return o1.getValue().anhoIngreso - o2.getValue().anhoIngreso;
            }
        });

        System.out.println("Lista de entradas (Ordenados por año de ingreso): " + listaEntradas);

    }

}

// CLASE ACADÉMICO (Incluye el método estático indicado en el enunciado)

class Academico implements Comparable<Academico>{
    String nombre;
    int anhoIngreso;

    public Academico(String nombre, int anhoIngreso) {
        this.nombre = nombre;
        this.anhoIngreso = anhoIngreso;
    }

    @Override
    public String toString() {
        return nombre + " (" + anhoIngreso + ')';
    }

    static boolean nuevoAcademico(Map<Character, Academico> academia, Academico nuevo, Character letra) {
        boolean resultado = true;
        if ((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'Z') || letra == 'ñ' || letra == 'Ñ') {
            academia.put(letra, nuevo);
        } else
            resultado = false;

        return resultado;
    }

    @Override
    public int compareTo(Academico o) {
        return nombre.compareTo(o.nombre);
    }
}
