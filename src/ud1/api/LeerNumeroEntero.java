package ud1.api;

import java.util.Scanner;

public class LeerNumeroEntero {
    public static void main(String[] args) {
        int numero;

        Scanner sc = new Scanner(System.in);

        numero = sc.nextInt();

        System.out.println("Has introducido el número " + numero);
        
        sc.close();
    }
}
