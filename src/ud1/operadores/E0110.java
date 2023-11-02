package ud1.operadores;

import java.util.Scanner;

public class E0110 {
    public static void main(String[] args) {
        boolean podemosSalir;

        boolean llueve, tareas, recados;

        Scanner sc = new Scanner(System.in);

        System.out.print("Llueve? ");
        llueve = sc.nextBoolean();

        System.out.print("Tengo tareas? ");
        tareas = sc.nextBoolean();

        System.out.print("Tengo recados? ");
        recados = sc.nextBoolean();
        sc.close();


        podemosSalir = recados || (!tareas && !llueve);

        System.out.println("Podemos salir? " + podemosSalir);

    }
}
