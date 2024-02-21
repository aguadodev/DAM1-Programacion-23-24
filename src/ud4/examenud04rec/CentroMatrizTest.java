package ud4.examenud04rec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CentroMatrizTest {


    @Test
    public void testCentroMatriz() {
        // Caso de matriz nula
        assertEquals(0, CentroMatriz.centroMatriz(null));

        // Caso de matriz vacía
        assertEquals(0, CentroMatriz.centroMatriz(new int[][]{}));

        // Caso de matriz con elementos
        int[][] matriz1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        assertEquals(5, CentroMatriz.centroMatriz(matriz1));

        int[][] matriz2 = {
            {1, 2, 3, 4},
            {5, 7, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        assertEquals(8, CentroMatriz.centroMatriz(matriz2));

        int[][] matriz3 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        assertEquals(3, CentroMatriz.centroMatriz(matriz3));

        int[][] matriz4 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        assertEquals(3, CentroMatriz.centroMatriz(matriz4));

        int[][] matriz5 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        assertEquals(4, CentroMatriz.centroMatriz(matriz5));
    }
}
