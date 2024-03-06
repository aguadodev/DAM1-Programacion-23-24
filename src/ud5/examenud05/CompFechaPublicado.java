package ud5.examenud05;
import java.util.Comparator;

public class CompFechaPublicado implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Objeto obj1 = (Objeto) o1;
        Objeto obj2 = (Objeto) o2;
        return obj1.fechaHoraPublicacion.compareTo(obj2.fechaHoraPublicacion);
    }

}
