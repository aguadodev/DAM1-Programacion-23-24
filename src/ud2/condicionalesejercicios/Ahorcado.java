package ud2.condicionalesejercicios;

import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        byte numFallos;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ahorcado. Indica el número de fallos para dibujar el muñeco: ");
        numFallos = sc.nextByte();
        sc.close();

        // Imprime partes comunes iniciales del ahorcado
        System.out.println("    ___");
        System.out.println("   |   |");

        switch (numFallos) {
            case 0:
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 1:
                System.out.println("   O   |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 2:
                System.out.println("   O   |");
                System.out.println("  /    |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 3:
                System.out.println("   O   |");
                System.out.println("  /|   |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 4:
                // Hay que “escapar” la barra ‘\’ para imprimirla
                System.out.println("   O   |");
                System.out.println("  /|\\  |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 5:
                System.out.println("   O   |");
                System.out.println("  /|\\  |");
                System.out.println("   |   |");
                System.out.println("       |");
                break;
            case 6:
                System.out.println("   O   |");
                System.out.println("  /|\\  |");
                System.out.println("   |   |");
                System.out.println("  /    |");
                break;
            case 7:
                System.out.println("   O   |");
                System.out.println("  /|\\  |");
                System.out.println("   |   |");
                System.out.println("  / \\  |");
                break;
        }

        // Imprime partes comunes finales
        System.out.println("       |");
        System.out.println(" ______|");

    }
}
