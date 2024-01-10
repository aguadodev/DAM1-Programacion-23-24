package ud4.arraysejercicios;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class EjArrays16 {
    

    @Test
    void testMultiplicarMatrices() {
        // Definir matrices de prueba
        int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matriz2 = {{7, 8}, {9, 10}, {11, 12}};

        // Calcular el producto de las matrices
        int[][] resultado = multiplicar(matriz1, matriz2);

        // Definir el resultado esperado
        int[][] resultadoEsperado = {{58, 64}, {139, 154}};

        // Verificar si el resultado es igual al resultado esperado
        assertArrayEquals(resultadoEsperado, resultado);

       // Calcular el producto de las matrices
        int[][] resultado2 = multiplicar(matriz2, matriz1);

        // Definir el resultado esperado
        int[][] resultadoEsperado2 = {{39, 54, 69}, {49, 68, 87}, {59,82,105}};

        // Verificar si el resultado es igual al resultado esperado
        assertArrayEquals(resultadoEsperado2, resultado2);
         
    }

    public static int[][] multiplicar(int t1[][], int t2[][]){
        int[][] tr = null;

        if (t1 != null && t2 != null && t1[0] != null && t2[0] != null && t1[0].length == t2.length) {
            tr = new int[t1.length][t2[0].length];

            for(int i = 0; i < tr.length; i++){
                for(int j = 0; j < tr[i].length; j++){

                    // Asignar valor a la casilla
                    tr[i][j] = 0;
                    for(int r = 0; r < t2.length; r++){
                        // SUMATORIO DE PRODUCTOS
                        tr[i][j] += t1[i][r] * t2[r][j];
                    }                     
                }
            }
        }

        return tr;
    }

}
