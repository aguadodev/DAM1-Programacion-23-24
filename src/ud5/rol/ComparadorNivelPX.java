package ud5.rol;

import java.util.Comparator;

public class ComparadorNivelPX implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Personaje p1 = (Personaje) o1;
        Personaje p2 = (Personaje) o2;
        if (p1.nivel == p2.nivel) {
            return p2.experiencia - p1.experiencia;
        } else {
            return p2.nivel - p1.nivel;
        }
    }
    
}
