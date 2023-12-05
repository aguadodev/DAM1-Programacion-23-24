package ud4.arraysapuntes;

import java.util.Arrays;

public class E0505 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        System.out.println(Arrays.toString(rellenaPares(100, 200)));
    }

    static int[] rellenaPares(int longitud, int fin) {
        // Declara y crea el array
        int numeros[] = new int[longitud];

        // Recorrer e inicializar el array
        for (int i = 0; i < longitud; i++) {
            // Generar número para aleatorio entre 2 y fin
            numeros[i] = (int) (Math.random() * fin / 2) * 2 + 2;
        }

        // Generar número para aleatorio entre 2 y fin
        Arrays.sort(numeros);

        return numeros;
    }

}
