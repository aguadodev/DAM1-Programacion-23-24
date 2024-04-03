package ud6.coleccionesejercicios;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class EP1230 {
    
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(1);
        lista.add(3);
        lista.add(3);        
        lista.add(2);


        System.out.println(eliminaRepetidos(lista));
    }

    static <T> List<T> eliminaRepetidos(List<T> lista){
        return new ArrayList<>(new LinkedHashSet<>(lista));
    }

}
