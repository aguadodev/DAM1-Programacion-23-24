package ud1.expresiones;

import java.util.Scanner;

// Programa que lea un caracter de teclado e imprima si se trata de un dígito, una mayúscula o una minúscula

public class EOE10 {
    public static void main(String[] args) {
        char ch;

        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe un caracter: ");
        ch = sc.nextLine().charAt(0);
        sc.close();
       

        System.out.print(ch >= '0' && ch <= '9' ? "Es un dígito" : "");
        System.out.print(ch >= 'A' && ch <= 'Z' ? "Es una letra mayúscula" : "");
        System.out.print(ch >= 'a' && ch <= 'z' ? "Es una letra minúscula" : "");

    }
}
