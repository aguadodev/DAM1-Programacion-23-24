package ud6.streamapuntes;

import java.util.Arrays;

public class E1307 {
    public static void main(String[] args) {
        // Crea una tabla ordenada de 10 números reales entre 1 y 100
        Double[] t = new Double[10];
        for (int i = 0; i < t.length; i++)
            t[i] = Math.random() * 100;

        Arrays.sort(t);
        System.out.println("\n10 números reales: " + Arrays.toString(t));


        // Genera la tabla con las raíces cúbicas.
        Double[] raices = E1305.transformar(t, new Double[0], Calculos::raiz3);

        System.out.println("\nRaíces cúbicas: " + Arrays.toString(raices));

    }
}
