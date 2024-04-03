package ud6.streamapuntes;

import java.util.Arrays;
import java.util.function.Function;

public class E1305 {
    public static void main(String[] args) {
        // Crea una tabla ordenada de 10 números enteros entre 1 y 100
        Integer[] t = new Integer[10];
        for (int i = 0; i < t.length; i++)
            t[i] = (int) (Math.random() * 100) + 1;

        Arrays.sort(t);
        System.out.println("\n10 números enteros: " + Arrays.toString(t));

        // Genera la tabla con las raíces cuadradas.
        Double[] tSqr = new Double[0];
        tSqr = transformar(t, tSqr, v -> Math.sqrt(v));
        System.out.println("\nRaíces cuadradas: " + Arrays.toString(tSqr));

    }

    public static <T, V> V[] transformar(T[] t, V[] transf, Function<T, V> f) {
        // Como no podemos instanciar tablas de genéricos usamos la que nos proporcionan
        // en el segundo parámetro.
        // En este caso conocemos el tamaño final que debe tener.
        transf = Arrays.copyOf(transf, t.length);
        // Rellenamos la tabla transformada aplicando la función a los elementos de la
        // tabla original
        for (int i = 0; i < t.length; i++)
            transf[i] = f.apply(t[i]);

        return transf;
    }
}
