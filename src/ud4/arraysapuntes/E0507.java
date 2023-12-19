package ud4.arraysapuntes;

import java.util.Arrays;

public class E0507 {
    static int[] sinRepetidos(int t[]) {
        int[] sinRepetidos = new int[0];

        // Para cada elemento del array original
        for(int i = 0; i < t.length; i++){
            // Buscamos el elemento a insertar en el array sinRepetidos
            boolean repetido = false;
            for(int j = 0; j < sinRepetidos.length; j++){
                if(t[i] == sinRepetidos[j])
                    repetido = true;
            }

/*          if (!existe(sinRepetidos, t[i])){ */            
            if (!repetido){
                // Inserto el elemento nuevo en sinRepetidos
                sinRepetidos = Arrays.copyOf(sinRepetidos, sinRepetidos.length + 1);
                sinRepetidos[sinRepetidos.length - 1] = t[i];
            }
        }
        
        return sinRepetidos;
    }


    static boolean existe(int t[], int valor){
        int i = 0;
        while (t[i] != valor && i < t.length){
            i++;
        }
        
        return t[i] == valor;
    }


    static int[] tablaRandom(int n) {
        int[] tablaRandom = new int[n];

        for (int i = 0; i < tablaRandom.length; i++)
            tablaRandom[i] = (int) (Math.random() * 10);

        return tablaRandom;
    }

    public static void main(String[] args) {
        int[] t = tablaRandom(10);

        System.out.println(Arrays.toString(t));

        int[] tSinRepetidos = sinRepetidos(t);

        System.out.println(Arrays.toString(tSinRepetidos));
    }

}
