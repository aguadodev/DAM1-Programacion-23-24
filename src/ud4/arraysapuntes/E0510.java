package ud4.arraysapuntes;

import java.util.Arrays;

public class E0510 {
    static int[] eliminarMayores(int t[], int valor) {
        int[] aux = new int[0];

        for (int val : t) {
            if (val <= valor) {
                aux = Arrays.copyOf(aux, aux.length + 1);
                aux[aux.length - 1] = val;
            }
        }

        return aux;
    }
}
