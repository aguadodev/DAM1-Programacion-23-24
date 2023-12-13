package ud4.arraysapuntes;

import java.util.Arrays;

public class E0506 {
    public static void main(String[] args) {
        int[] apuesta1 = tablaAleatoria(1, 49, 6);

        int[] combinacionGanadora = tablaAleatoria(1, 49, 6);
        Arrays.sort(combinacionGanadora);

        System.out.println("Apuesta: " + Arrays.toString(apuesta1));
        System.out.println("Combinación Ganadora: " + Arrays.toString(combinacionGanadora));

        System.out.println("Aciertos = " + numAciertos(apuesta1, combinacionGanadora));        
    }

    static int numAciertos(int[] apuesta, int[] ganadora) {
        return 0;
    }

    static int[] tablaAleatoria(int numInicio, int numFin, int longitud) {
        int[] t = new int[longitud];

        // Inicializa el arraya con números entre numInicio y numFin
        for (int i = 0; i < t.length; i++) {
            t[i] = (int) (Math.random() * (numFin - numInicio + 1) + numInicio);
        }

        return t;
    }

}
