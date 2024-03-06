package ud5.examenud05;

import java.util.Comparator;

public class CompUsuarioPublicacion implements Comparator {
    // Coloca primero los que tienen usuario de publicación registrado, y luego los
    // anónimos
    @Override
    public int compare(Object o1, Object o2) {
        Objeto obj1 = (Objeto) o1;
        Objeto obj2 = (Objeto) o2;
        if (obj1.usuarioPublicacion != null && obj2.usuarioPublicacion == null) {
            return -1;
        } else if (obj1.usuarioPublicacion == null && obj2.usuarioPublicacion != null) {
            return 1;
        } else {
            return 0;
        }
    }

}
