package ud4.examenud04rec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CentroMatriz {

    public static int centroMatriz(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return 0;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas % 2 == 0 && columnas % 2 != 0) {
            // Número de filas par y número de columnas impar
            int valorCentralFila1 = matriz[filas / 2 - 1][columnas / 2];
            int valorCentralFila2 = matriz[filas / 2][columnas / 2];
            return Math.round((valorCentralFila1 + valorCentralFila2) / 2);
        } else if (filas % 2 != 0 && columnas % 2 == 0) {
            // Número de filas impar y número de columnas par
            int valorCentralColumna1 = matriz[filas / 2][columnas / 2 - 1];
            int valorCentralColumna2 = matriz[filas / 2][columnas / 2];
            return Math.round((valorCentralColumna1 + valorCentralColumna2) / 2);
        } else if (filas % 2 == 0 && columnas % 2 == 0) {
            // Número de filas y columnas par
            int valor1 = matriz[filas / 2 - 1][columnas / 2 - 1];
            int valor2 = matriz[filas / 2 - 1][columnas / 2];
            int valor3 = matriz[filas / 2][columnas / 2 - 1];
            int valor4 = matriz[filas / 2][columnas / 2];
            return Math.round((valor1 + valor2 + valor3 + valor4) / 4);
        } else {
            // Caso de matriz impar x impar
            return matriz[filas / 2][columnas / 2];
        }
    }

    @Test
    public void testCentroMatriz() {
        // Caso de matriz nula
        assertEquals(0, centroMatriz(null));

        // Caso de matriz vacía
        assertEquals(0, centroMatriz(new int[][]{}));

        // Caso de matriz con elementos
        int[][] matriz1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        assertEquals(5, centroMatriz(matriz1));

        int[][] matriz2 = {
            {1, 2, 3, 4},
            {5, 7, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        assertEquals(8, centroMatriz(matriz2));

        int[][] matriz3 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        assertEquals(3, centroMatriz(matriz3));

        int[][] matriz4 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        assertEquals(3, centroMatriz(matriz4));

        int[][] matriz5 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        assertEquals(4, centroMatriz(matriz5));
    }
}
