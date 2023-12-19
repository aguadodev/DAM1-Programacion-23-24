package ud4.arraysapuntes;

import java.util.Arrays;

public class E0506 {
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 49;
        final int NUM_NUMS = 6;
        int[] apuesta1 = tablaAleatoria(MIN, MAX, NUM_NUMS);

        int[] combinacionGanadora = tablaAleatoria(MIN, MAX, NUM_NUMS);
        Arrays.sort(combinacionGanadora);

        System.out.println("Apuesta: " + Arrays.toString(apuesta1));
        System.out.println("Combinación Ganadora: " + Arrays.toString(combinacionGanadora));

        System.out.println("Aciertos = " + numAciertos(apuesta1, combinacionGanadora));
    }

    static int numAciertos(int[] apuesta, int[] ganadora) {
        int numAciertos = 0;

        for (int num : apuesta)
            if (Arrays.binarySearch(ganadora, num) >= 0)
                numAciertos++;

        return numAciertos;
    }

    static int[] tablaAleatoria(int numInicio, int numFin, int longitud) {
        int[] t = new int[longitud];

        // Inicializa el array con números entre numInicio y numFin
        for (int i = 0; i < t.length; i++) {
            int num;
            boolean repetido;
            do {
                num = (int) (Math.random() * (numFin - numInicio + 1) + numInicio);
                repetido = false;
                for (int j = 0; j < i; j++)
                    if (t[j] == num)
                        repetido = true;
            } while (repetido);

            t[i] = num;

        }

        return t;
    }

}
