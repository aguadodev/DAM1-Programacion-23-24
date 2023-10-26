package ud02.buclesapuntes;

import java.util.Scanner;

public class E0313 {
    public static void main(String[] args) {
        final int NUM_NOTAS = 6;

        int aprobados = 0;
        int condicionados = 0;
        int suspensos = 0;


        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe " + NUM_NOTAS + " notas: ");

        for(int i = 1; i <= NUM_NOTAS; i++){
            int nota = sc.nextInt();
            switch (nota) {
                case 5, 6, 7, 8, 9, 10 -> aprobados++;
                case 4 -> condicionados++;
                case 0, 1, 2, 3 -> suspensos++;
            }
        }
        sc.close();

        System.out.println("Aprobados: " + aprobados);
        System.out.println("Condicionados: " + condicionados);
        System.out.println("Suspensos: " + suspensos);
    }
}
