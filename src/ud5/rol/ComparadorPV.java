package ud5.rol;

import java.util.Comparator;

public class ComparadorPV implements Comparator {
    // Orden descendente por puntos de vida

    @Override
    public int compare(Object o1, Object o2) {
        Personaje p1 = (Personaje) o1;
        Personaje p2 = (Personaje) o2;
        return p2.puntosVida - p1.puntosVida;
    }
    
}
