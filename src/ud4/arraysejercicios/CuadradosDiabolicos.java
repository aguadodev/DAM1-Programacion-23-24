package ud4.arraysejercicios;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CuadradosDiabolicos {
    
    public static void main(String[] args) {
        int[][] t1 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};

        int[][] t2 = {{1, 2}, {3, 4}};

        assertTrue(esCuadradoDiabolico(t1));
        assertFalse(esCuadradoDiabolico(t2));        
    }

    @Test
    void esCuadradoDiabolicoTest()  {
        int[][] t1 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};

        int[][] t2 = {{1, 2}, {3, 4}};

        assertTrue(esCuadradoDiabolico(t1));
        assertFalse(esCuadradoDiabolico(t2));
    }
    @Test
    void esCuadradoEsotericoTest()  {
        int[][] t1 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};

        int[][] t2 = {{1, 2}, {3, 4}};

        assertTrue(esCuadradoEsoterico(t1));
        assertFalse(esCuadradoEsoterico(t2));
    }

    private static Boolean esCuadradoEsoterico(int[][] t) {
        Boolean esEsoterico = true;

        if (esCuadradoDiabolico(t)) {
            int n = t.length;
            boolean[] numeros = new boolean[n*n]; // Array que pondrá a true los números utilizados en el cuadrado

            for (int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    // Si el número se sale de los límites 1 a n*n no es esotérico
                    if (t[i][j] < 1 || t[i][j] > n * n)
                        esEsoterico = false;
                    // Si el número está repetido no es esoterico
                    else if (numeros[t[i][j] - 1])
                        esEsoterico = false;
                    // Si no está repetido se registra
                    else 
                        numeros[t[i][j] - 1] = true;                        

        } else {
            esEsoterico = false;
        }


        return esEsoterico;

    }


    private static Boolean esCuadradoDiabolico(int[][] t) {
        Boolean esDiabolico = true;
        
        if (UtilMatrices.esCuadrada(t)) {
            int n = t.length;
            int cm = 0;
            // Recorrer filas
            for(int i = 0; i < n; i++) {
                int suma = 0;
                for (int j = 0; j < n; j++)
                    suma += t[i][j];
                
                if (cm == 0) {
                    cm = suma;
                } else if (suma != cm){
                    esDiabolico = false;
                }
            }

            // Recorrer columnas
            for(int j = 0; j < n; j++){
                int suma = 0;

                for (int i = 0; i < n; i++)
                    suma += t[i][j];

                if (suma != cm) 
                    esDiabolico = false;
            }

            // Recorrer diagonales
            int sumaDP = 0;
            int sumaDI = 0;
            for (int i = 0; i < n; i++){
                sumaDP += t[i][i];
                sumaDI += t[i][n-i-1];
            }

            if(sumaDP != cm || sumaDI != cm){
                esDiabolico = false;
            }

        } else {
            esDiabolico = false;
        }

        return esDiabolico;
    }
}
