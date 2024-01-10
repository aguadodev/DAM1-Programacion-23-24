package ud4.arraysejercicios;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class EjArrays18 {
    

    public static Boolean esCuadrada(int[][] t){
        Boolean res = null;

        if (t != null && t.length > 0 && t[0].length > 0) {
            res = t.length == t[0].length;
        }

        return res;
    }

    public static Boolean esOrtogonal(int[][] t){
        Boolean res = null;

        if (esCuadrada(t)) {
            int[][] traspuesta = UtilMatrices.traspuesta(t);

            int[][] tProducto = UtilMatrices.multiplicar(t, traspuesta);

            int[][] tIdentidad = UtilMatrices.matrizIdentidad(t.length);

            res = Arrays.deepEquals(tProducto, tIdentidad);

        }

        return res; 
    }


    @Test
    public void matrizCuadradaOrtogonal() {
        int[][] matriz = {{1, 0}, {0, -1}};
        assertTrue(esOrtogonal(matriz));
    }

    @Test
    public void matrizNoCuadrada() {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}};
        assertNull(esOrtogonal(matriz));
    }

    @Test
    public void matrizCuadradaNoOrtogonal() {
        int[][] matriz = {{1, 0}, {1, 1}};
        assertFalse(esOrtogonal(matriz));
    }

    @Test
    public void matrizCuadradaNoOrtogonalConCeros() {
        int[][] matriz = {{0, 1}, {0, 0}};
        assertFalse(esOrtogonal(matriz));
    }


}
