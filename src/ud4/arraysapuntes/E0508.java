package ud4.arraysapuntes;

import java.util.Arrays;

public class E0508 {

    static int[] tablaRandom(int n) {
        int[] tablaRandom = new int[n];

        for (int i = 0; i < tablaRandom.length; i++)
            tablaRandom[i] = (int) (Math.random() * 10);

        return tablaRandom;
    }

    public static void main(String[] args) {
        int[] t = tablaRandom(10);

        System.out.println(Arrays.toString(t));

        int[] impares = new int[0];
        int[] pares = new int[0];

        for (int n : t) {
            if (n % 2 != 0) {
                impares = Arrays.copyOf(impares, impares.length + 1);
                impares[impares.length - 1] = n;
            } else {
                pares = Arrays.copyOf(pares, pares.length + 1);
                pares[pares.length - 1] = n;
            }
        }

        System.out.println(Arrays.toString(pares));

        System.out.println(Arrays.toString(impares));

        System.out.println(Arrays.toString(getImpares(t)));

        System.out.println(Arrays.toString(getPares(t)));



        int[] imparesAlt = new int[t.length];
        int[] paresAlt = new int[t.length];
        int nPares = 0;
        int nImpares = 0;

        for (int n : t) {
            if (n % 2 != 0) {
                imparesAlt[nImpares] = n;
                nImpares++;
            } else {
                paresAlt[nPares] = n;
                nPares++;
            }
        }
        paresAlt = Arrays.copyOf(paresAlt, nPares);
        imparesAlt = Arrays.copyOf(imparesAlt, nImpares);

        System.out.println(Arrays.toString(paresAlt));

        System.out.println(Arrays.toString(imparesAlt));

    }

    private static int[] getImpares(int[] t) {
        int[] impares = new int[0];

        for (int n : t) {
            if (n % 2 != 0) {
                impares = Arrays.copyOf(impares, impares.length + 1);
                impares[impares.length - 1] = n;
            }
        }

        return impares;
    }

    private static int[] getPares(int[] t) {
        int[] pares = new int[0];

        for (int n : t) {
            if (n % 2 == 0) {
                pares = Arrays.copyOf(pares, pares.length + 1);
                pares[pares.length - 1] = n;
            }
        }

        return pares;
    }

}
