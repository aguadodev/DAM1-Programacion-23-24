package ud6.streamapuntes;

import java.util.Comparator;

public class CompClienteNombre implements Comparator <Cliente>{

    @Override
    public int compare(Cliente o1, Cliente o2) {
        return o1.nombre.compareTo(o2.nombre);
    }

    
    
}
