package ud6.examenud05col;

import java.util.Comparator;

public class CompFechaRecogido implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Objeto obj1 = (Objeto) o1;
        Objeto obj2 = (Objeto) o2;
        
        // Controla que fechaHoraRecogida sea null
        if (obj1.fechaHoraRecogida == null && obj2.fechaHoraRecogida != null)
            return 1;
        else if (obj1.fechaHoraRecogida != null && obj2.fechaHoraRecogida == null)
            return -1;
        else if (obj1.fechaHoraRecogida == null && obj2.fechaHoraRecogida == null)
            return 0;
        else
            return obj1.fechaHoraRecogida.compareTo(obj2.fechaHoraRecogida);
    }

}
