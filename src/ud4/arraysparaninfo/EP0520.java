package ud4.arraysparaninfo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class EP0520 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] result = fusionOrdenada(array1, array2);

        assertArrayEquals(expected, result);        

        System.out.println(Arrays.toString(result));

    }

    @Test
    public void testFusionOrdenada() {
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] result = fusionOrdenada(array1, array2);

        assertArrayEquals(expected, result);
    }


    public static int[] fusionOrdenada(int[] t1, int[] t2){        
        int[] tr = null; 

        if (t1 != null && t2 != null) {
            tr = new int[t1.length + t2.length];

            int i = 0, j = 0, k = 0;

            // Compara y copia elementos de los dos arrays hasta que se termina uno de ellos
            while (i < t1.length && j < t2.length){
                if (t1[i] <= t2[j]) {
                    tr[k] = t1[i];
                    i++;
                } else {
                    tr[k] = t2[j];
                    j++;                    
                }
                k++;
            }
            
            // Copia los elementos restantes del array que no se ha terminado aún
            if(i == t1.length) {
                // Copio t2
                System.arraycopy(t2, j, tr, k, tr.length - k);
            } else {
                // Copio t1
                System.arraycopy(t1, i, tr, k, tr.length - k);
            }

        }

        return tr;
    }


}
