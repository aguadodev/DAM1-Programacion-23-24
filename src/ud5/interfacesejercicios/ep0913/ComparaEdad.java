package ud5.interfacesejercicios.ep0913;

import java.util.Comparator;

public class ComparaEdad implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Futbolista f1 = (Futbolista) o1;
        Futbolista f2 = (Futbolista) o2;
        return f1.edad - f2.edad;
    }
    
}
