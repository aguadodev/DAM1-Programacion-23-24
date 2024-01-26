package util;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class UtilMatrices {

    public static Boolean esMatrizValida(int[][] t) {
        return t != null && t.length > 0 && t[0].length > 0;
    }

    public static Boolean esCuadrada(int[][] t) {
        Boolean res = null;

        if (esMatrizValida(t)) {
            res = t.length == t[0].length;
        }

        return res;
    }

    public static int[][] traspuesta(int[][] t) {
        int[][] tr = null;

        if (esMatrizValida(t)) {
            tr = new int[t[0].length][t.length];

            for (int i = 0; i < tr.length; i++) {
                for (int j = 0; j < tr[0].length; j++) {
                    tr[i][j] = t[j][i];
                }
            }

        }

        return tr;
    }

    public static int[][] matrizIdentidad(int n) {
        int[][] t = null;

        if (n > 0) {
            t = new int[n][n];

            // Arrays.fill(t, 0);

            for (int i = 0; i < n; i++) {
                t[i][i] = 1;
            }
        }

        return t;
    }

    public static int[][] multiplicar(int t1[][], int t2[][]) {
        int[][] tr = null;

        if (t1 != null && t2 != null && t1[0] != null && t2[0] != null && t1[0].length == t2.length) {
            tr = new int[t1.length][t2[0].length];

            for (int i = 0; i < tr.length; i++) {
                for (int j = 0; j < tr[i].length; j++) {

                    // Asignar valor a la casilla
                    tr[i][j] = 0;
                    for (int r = 0; r < t2.length; r++) {
                        // SUMATORIO DE PRODUCTOS
                        tr[i][j] += t1[i][r] * t2[r][j];
                    }
                }
            }
        }

        return tr;
    }

    public static Boolean esOrtogonal(int[][] t) {
        Boolean res = null;

        if (esCuadrada(t)) {
            int[][] traspuesta = UtilMatrices.traspuesta(t);

            int[][] tProducto = UtilMatrices.multiplicar(t, traspuesta);

            int[][] tIdentidad = UtilMatrices.matrizIdentidad(t.length);

            res = Arrays.deepEquals(tProducto, tIdentidad);

        }

        return res;
    }

    /**
     * PRUEBAS JUNIT5
     */

    @Test
    void testTraspuestaMatrizCuadrada() {
        int[][] matrizOriginal = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] resultadoEsperado = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
        assertArrayEquals(resultadoEsperado, traspuesta(matrizOriginal));
    }

    @Test
    void testTraspuestaMatrizRectangular() {
        int[][] matrizOriginal = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] resultadoEsperado = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
        assertArrayEquals(resultadoEsperado, traspuesta(matrizOriginal));
    }

    @Test
    void testTraspuestaMatrizUnaFila() {
        int[][] matrizOriginal = { { 1, 2, 3 } };
        int[][] resultadoEsperado = { { 1 }, { 2 }, { 3 } };
        assertArrayEquals(resultadoEsperado, traspuesta(matrizOriginal));
    }

    @Test
    void testTraspuestaMatrizUnaColumna() {
        int[][] matrizOriginal = { { 1 }, { 2 }, { 3 } };
        int[][] resultadoEsperado = { { 1, 2, 3 } };
        assertArrayEquals(resultadoEsperado, traspuesta(matrizOriginal));
    }

    @Test
    void testMultiplicarMatrices() {
        // Definir matrices de prueba
        int[][] matriz1 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] matriz2 = { { 7, 8 }, { 9, 10 }, { 11, 12 } };

        // Calcular el producto de las matrices
        int[][] resultado = multiplicar(matriz1, matriz2);

        // Definir el resultado esperado
        int[][] resultadoEsperado = { { 58, 64 }, { 139, 154 } };

        // Verificar si el resultado es igual al resultado esperado
        assertArrayEquals(resultadoEsperado, resultado);

        // Calcular el producto de las matrices
        int[][] resultado2 = multiplicar(matriz2, matriz1);

        // Definir el resultado esperado
        int[][] resultadoEsperado2 = { { 39, 54, 69 }, { 49, 68, 87 }, { 59, 82, 105 } };

        // Verificar si el resultado es igual al resultado esperado
        assertArrayEquals(resultadoEsperado2, resultado2);

    }

    @Test
    public void matrizCuadradaOrtogonal() {
        int[][] matriz = { { 1, 0 }, { 0, -1 } };
        assertTrue(esOrtogonal(matriz));
    }

    @Test
    public void matrizNoCuadrada() {
        int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 } };
        assertNull(esOrtogonal(matriz));
    }

    @Test
    public void matrizCuadradaNoOrtogonal() {
        int[][] matriz = { { 1, 0 }, { 1, 1 } };
        assertFalse(esOrtogonal(matriz));
    }

    @Test
    public void matrizCuadradaNoOrtogonalConCeros() {
        int[][] matriz = { { 0, 1 }, { 0, 0 } };
        assertFalse(esOrtogonal(matriz));
    }

}
