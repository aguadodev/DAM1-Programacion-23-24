package ud6.streamapuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class E1304 {
    public static void main(String[] args) {

        // Crea una tabla ordenada de 50 números enteros entre 1 y 100
        Integer[] t = new Integer[50];
        for (int i = 0; i < t.length; i++)
            t[i] = (int) (Math.random() * 100) + 1;

        Arrays.sort(t);
        System.out.println("\n50 números enteros: " + Arrays.toString(t));

        // Obtiene otra tabla con los múltiplos de 3
        Integer[] t3 = filtrar(t, e -> e % 3 == 0);
        System.out.println("\nMúltiplos de 3: " + Arrays.toString(t3));

        // Obtiene e imprime una lista con los múltiplos de 5
        System.out.println("\nMúltiplos de 5: " + filtrar(Arrays.asList(t), e -> e % 5 == 0));
    }

    /**
     * Devuelve un array filtrado con los elementos que cumplen el predicado.
     * 
     * @param <T>
     * @param t
     * @param p
     * @return
     */
    private static <T> T[] filtrar(T[] t, Predicate<T> p) {
        // Como no podemos instanciar tablas de genéricos, creamos la tabla resultado a
        // partir de una copia vacía de la tabla de entrada.
        T[] tR = Arrays.copyOf(t, 0);
        for (T e : t)
            if (p.test(e)) {
                tR = Arrays.copyOf(tR, tR.length + 1);
                tR[tR.length - 1] = e;
            }
        return tR;
    }

    private static <T> List<T> filtrar(List<T> t, Predicate<T> p) {
        // Sí podemos instanciar una lista (dinámica) de un tipo genético T
        List<T> tR = new ArrayList<>();
        for (T e : t)
            if (p.test(e))
                tR.add(e);
        return tR;
    }    

}
