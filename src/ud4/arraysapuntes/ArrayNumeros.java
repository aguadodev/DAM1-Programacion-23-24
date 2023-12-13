package ud4.arraysapuntes;

import java.util.Scanner;

public class ArrayNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indica la cantidad de números: ");
        int n = sc.nextInt();

        int[] numeros = new int[n];
        int[] numeros2 = null;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 19 - 9);
        }

        numeros[numeros.length - 1] = 0;

        imprimir(numeros);

        System.out.println("\n\nArray al revés: ");
        imprimirInverso(numeros);

        System.out.println("\n\nRESULTADOS:\n");
        System.out.println("Media de números positivos: " + mediaPositivos(numeros));
        System.out.println("Número de ceros: " + contarCeros(numeros));
        System.out.println("El primer 0 se encuentra en la posición: " + buscar(numeros, 0));

    }

    private static Double mediaPositivos(int[] t) {
        Double media = null;

        if (t != null && t.length > 0) {
            int sumaPositivos = 0;
            int cantidadPositivos = 0;
            for (int i = 0; i < t.length; i++) {
                if (t[i] > 0) {
                    sumaPositivos += t[i];
                    cantidadPositivos++;
                }
            }
            media = sumaPositivos / (double) cantidadPositivos;
        }

        return media;
    }

    private static int contarCeros(int[] t) {
        int cont = 0;
        for (int i = 0; i < t.length; i++)
            if (t[i] == 0)
                cont++;
        return cont;
    }

    public static void imprimir(int[] t) {
        for (int i = 0; i < t.length; i++)
            System.out.print(t[i] + " ");
    }

    private static void imprimirInverso(int[] t) {
        for (int i = t.length - 1; i >= 0; i--)
            System.out.print(t[i] + " ");
    }

    static int buscar(int t[], int clave) {
        int posicion = -1;

        if (t != null) {
            int i = 0;
            while (posicion == -1 && i < t.length) {
                if (clave == t[i])
                    posicion = i;
                i++;
            }
        }

        return posicion;
    }

}
