package ud6.examenud05col;
import java.util.Comparator;

public class CompFechaPublicado implements Comparator <Objeto>{

    @Override
    public int compare(Objeto o1, Objeto o2) {
        return o1.fechaHoraPublicacion.compareTo(o2.fechaHoraPublicacion);
    }
}
