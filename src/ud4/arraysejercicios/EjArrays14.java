package ud4.arraysejercicios;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class EjArrays14 {
    
    public static Boolean esMatrizValida(int[][] t){
        return t != null && t.length > 0 && t[0].length > 0;
    }

    public static int[][] traspuesta(int[][] t){
        int[][] tr = null;

        if (esMatrizValida(t)){
            tr = new int[t[0].length][t.length];

            for(int i = 0; i < tr.length; i++){
                for(int j = 0; j < tr[0].length; j++){
                    tr[i][j] = t[j][i];
                }
            }

        }

        return tr;
    }


    @Test
    void testTraspuestaMatrizCuadrada() {
        int[][] matrizOriginal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] resultadoEsperado = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(resultadoEsperado, traspuesta(matrizOriginal));
    }

    @Test
    void testTraspuestaMatrizRectangular() {
        int[][] matrizOriginal = {{1, 2, 3}, {4, 5, 6}};
        int[][] resultadoEsperado = {{1, 4}, {2, 5}, {3, 6}};
        assertArrayEquals(resultadoEsperado, traspuesta(matrizOriginal));
    }

    @Test
    void testTraspuestaMatrizUnaFila() {
        int[][] matrizOriginal = {{1, 2, 3}};
        int[][] resultadoEsperado = {{1}, {2}, {3}};
        assertArrayEquals(resultadoEsperado, traspuesta(matrizOriginal));
    }

    @Test
    void testTraspuestaMatrizUnaColumna() {
        int[][] matrizOriginal = {{1}, {2}, {3}};
        int[][] resultadoEsperado = {{1, 2, 3}};
        assertArrayEquals(resultadoEsperado, traspuesta(matrizOriginal));
    }    

}
