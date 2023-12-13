package ud4.arraysapuntes;

import java.util.Arrays;
import java.util.Scanner;

public class ClaseArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indica la cantidad de números: ");
        int n = sc.nextInt();       
        
        int[] numeros = new int[n];

        // Inicializa el arraya con números entre -9 y 9
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 19 - 9);
        }       
   
        System.out.println(Arrays.toString(numeros));

        Arrays.sort(numeros);

        System.out.println(Arrays.toString(numeros));


        System.out.println("Hay un número -5 en la posición: " + Arrays.binarySearch(numeros, -5));



        System.out.println(Arrays.toString(rellenaPares(n, 10)));
        System.out.println(Arrays.toString(rellenaPares(n, 11)));



    }

    static int[] rellenaPares(int longitud, int fin) {
        int[] t = new int[longitud];

        for(int i = 0; i < t.length; i++)
            t[i] = (int) (Math.random() * fin / 2) * 2 + 2;

        Arrays.sort(t);

        return t;
    }    
}
