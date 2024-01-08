package ud4.stringsapuntes;

import java.util.Scanner;

public class ClaseCharacter {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        Scanner sc = new Scanner(System.in);
        char caracter;

        // Entrada de datos
        System.out.print("Introduce un carácter: ");
        caracter = sc.nextLine().charAt(0);
        sc.close();

        // Salida
        System.out.println("Es un dígito? " + Character.isDigit(caracter));
        System.out.println("Es una letra? " + Character.isLetter(caracter));
        System.out.println("Es un dígito o una letra? " + Character.isLetterOrDigit(caracter));
        boolean esMinuscula = Character.isLowerCase(caracter);
        System.out.println("Es minúscula? " + esMinuscula);
        if (esMinuscula)
            System.out.println("Letra mayúscula equivalente: " + Character.toUpperCase(caracter));
        boolean esMayuscula = Character.isUpperCase(caracter);
        System.out.println("Es mayúscula? " + esMayuscula);
        if (esMayuscula)
            System.out.println("Letra minúscula equivalente: " + Character.toLowerCase(caracter));
        System.out.println("Es un espacio? " + Character.isSpaceChar(caracter));
        System.out.println("Es un espacio en blanco? " + Character.isWhitespace(caracter));
    }

}
