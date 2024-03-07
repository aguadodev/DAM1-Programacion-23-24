package ud6.coleccionesapuntes;

import java.util.Arrays;

public class Util {

    static <U> int numeroNulos(U[] t) {
        int cont = 0;
        for (U e : t)
            if (e == null)
                cont++;
        return cont;
    }


    public static <U> U[] add(U e, U[] t) {
        U[] aux = Arrays.copyOf(t, t.length + 1);
        aux[aux.length - 1] = e;
        return aux;
    }

    public static <U> boolean buscar(U e, U[] t) {
        for (U ei : t){
            if (ei.equals(e)){
                return true;
            }
        }
        return false;
    }

    

}
