package ud4.arraysapuntes;

import java.util.Arrays;
import java.util.Scanner;

public class ClaseArrays {
    public static void main(String[] args) {
        /*
         * Scanner sc = new Scanner(System.in);
         * System.out.print("Indica la cantidad de números: ");
         * int n = sc.nextInt();
         */
        int n = 10;

        int[] numeros = new int[n];

        // Inicializa el arraya con números entre -9 y 9
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 19 - 9);
        }

        Arrays.sort(numeros);
        System.out.println("Array original: " + Arrays.toString(numeros));

        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe un número para borrar en el array: ");
        int numero = sc.nextInt();
        numeros = borrarTodosOrdenado(numeros, numero);

        System.out.println("Array reducido: " + Arrays.toString(numeros));

    }


    static int[] borrarOrdenado(int[] t, int valor){
        if (t != null){
            int indiceBorrar = Arrays.binarySearch(t, valor);
            if (indiceBorrar >= 0){
                System.arraycopy(t, indiceBorrar + 1, t, indiceBorrar, t.length - indiceBorrar - 1);
                t = Arrays.copyOf(t, t.length - 1);
            }
        }
        return t;
    }


    static int[] borrarTodosOrdenado(int[] t, int valor){
        if (t != null){
            int indiceBorrar = Arrays.binarySearch(t, valor);
            while (indiceBorrar >= 0){
                System.arraycopy(t, indiceBorrar + 1, t, indiceBorrar, t.length - indiceBorrar - 1);
                t = Arrays.copyOf(t, t.length - 1);

                indiceBorrar = Arrays.binarySearch(t, valor);
            }
        }
        return t;
    }


    static int[] insertarOrdenado(int[] t, int valor) {
        if (t == null) {
            t = new int[1];
            t[0] = valor;
        } else {
            int[] copia = new int[t.length + 1];
            int indiceInsercion = Arrays.binarySearch(t, valor);
            if (indiceInsercion < 0) {
                indiceInsercion = -indiceInsercion - 1;
            }
            System.arraycopy(t, 0, copia, 0, indiceInsercion);
            copia[indiceInsercion] = valor;
            System.arraycopy(t, indiceInsercion, copia, indiceInsercion + 1, t.length - indiceInsercion);
            t = copia;
        }
        return t;
    }

    static int[] rellenaPares(int longitud, int fin) {
        int[] t = new int[longitud];

        for (int i = 0; i < t.length; i++)
            t[i] = (int) (Math.random() * fin / 2) * 2 + 2;

        Arrays.sort(t);

        return t;
    }
}
