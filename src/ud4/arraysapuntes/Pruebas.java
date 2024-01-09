package ud4.arraysapuntes;

import java.util.Arrays;

public class Pruebas {

    public static void imprimirMatriz(int[][] t) {

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][][] datos = new int[5][5][5];

        int datos2[][] = { { 1, 2, 3 },
                { 1, 2, 3 },
                { 1, 2, 3 } };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++)
                    datos[i][j][k] = (int) (Math.random() * 10);
            }
        }

        System.out.println(Arrays.deepToString(datos));

        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                for (int k = 0; k < datos[0][0].length; k++) {
                    System.out.print(datos[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }



        imprimirMatriz(datos2);

        /*
         * int datos2[][];
         * 
         * String[] alumnos = { "Aarón", "Adrián Q", "Marcelo", "Adrián R", "Adrián T",
         * "Alberto", "Brais", "César", "Diego", "Eduardo", "Gabriel",
         * "Giuseppe", "Gonzalo", "Iago", "Maicol", "Martín", "Nicolás",
         * "Raúl", "Roberto", "Sergio" };
         * 
         * 
         * System.out.println(Arrays.toString(alumnos));
         * 
         * 
         * 
         * 
         * 
         * /*
         * int[] edad; // Declaración de un array
         * int[] edadFutura;
         * 
         * edad = new int[30];
         * 
         * edad[0] = 25;
         * edad[1] = 19;
         * // ..
         * System.out.println("Edad 1: " + edad[1]);
         * System.out.println("Edad 2: " + edad[2]);
         * 
         * edadFutura = edad;
         * 
         * System.out.println("Edad Futura: " + edadFutura[0]);
         * 
         * double[] notas = new double[30];
         * String[] nombres = new String[30];
         * boolean[] bombillas = new boolean[10];
         * System.out.println(notas[0]);
         * System.out.println(nombres[0]);
         * 
         * int[] alumnadoCiclos = { 30, 25, 32, 20 };
         * 
         * System.out.println(alumnadoCiclos);
         */
    }

}
