package ud6.coleccionesejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EP1226 {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Alberto");
        lista.add("Angel");
        lista.add("Alejandro");
        lista.add("Borja");
        lista.add("Xabier");
        lista.add("Marcos");
        lista.add("Óscar");
        lista.add("Carla");
        lista.add("Alfonso");
        lista.add("Jorge");
        lista.add("Jonathan");
        lista.add("Pedro");
        lista.add("Yeray");
        lista.add("Alex");
        lista.add("Diego P");
        lista.add("Rodrigo");
        lista.add("Miguel");
        lista.add("Eloy");
        lista.add("Gonzalo");
        lista.add("Victoria");
        lista.add("David");
        lista.add("Yoel");
        lista.add("Diego");
  
        List<List<String>> listas = repartoAlumnos(lista, 4);

        int i = 1;
        for(List<String> l : listas) {
            System.out.println("Lista número : " + i);
            System.out.println(l);
            i++;
        }

    }

    static List<List<String>> repartoAlumnos(List<String> lista, int numGrupos){
        List<List<String>> repartoAlumnos = new ArrayList<>();

        // Crea las listas de cada grupo y las añade a la lista de listas
        for (int i = 0; i < numGrupos; i++){
            repartoAlumnos.add(new ArrayList<String>());
        }

        // Desordena la lista de alumnado y los va añadiendo a cada lista
        Collections.shuffle(lista);
        int i = 0;
        for(String alumno : lista){
            repartoAlumnos.get(i).add(alumno);
            i = (i + 1) % numGrupos;
        }

        return repartoAlumnos;
    }

}
