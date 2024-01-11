package ud4.simud0401;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ud4.arraysejercicios.UtilMatrices;

public class MatrizTriangular {

    public static Boolean esTriangular(int[][] t) {
        Boolean esTriangular = null;

        if (UtilMatrices.esCuadrada(t) && t.length >= 2) {
            boolean esTriangularSuperior = true;
            for (int i = 1; i < t.length; i++)
                for (int j = 0; j < i; j++)
                    if (t[i][j] != 0){
                        esTriangularSuperior = false;
                    }
                        

            boolean esTriangularInferior = true;
            for (int i = 0; i < t.length - 1; i++)
                for (int j = i + 1; j < t.length; j++)
                    if (t[i][j] != 0)
                        esTriangularInferior = false;

            esTriangular = esTriangularInferior || esTriangularSuperior;
        }

        return esTriangular;
    }


    // TODO: Crear métodos esTriangularSuperior() y esTriangularInferior() y aplicar para evaluar en cortocircuito
    // TODO: Mejorar rendimiento con while o con break.




    /**
     * TESTS JUNIT 5
     */
    @Test
    void matrizTriangularSuperior() {
        int[][] matriz = {
                { 1, 2, 3 },
                { 0, 4, 5 },
                { 0, 0, 6 }
        };
        assertTrue(esTriangular(matriz));
    }

    @Test
    void matrizTriangularInferior() {
        int[][] matriz = {
                { 1, 0, 0 },
                { 4, 5, 0 },
                { 7, 8, 9 }
        };
        assertTrue(esTriangular(matriz));
    }

    @Test
    void matrizNoTriangular() {
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        assertFalse(esTriangular(matriz));
    }

    @Test
    void matrizVacia() {
        int[][] matriz = {};
        assertFalse(esTriangular(matriz));
    }

    @Test
    void matrizNoCuadrada() {
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        assertFalse(esTriangular(matriz));
    }
}
