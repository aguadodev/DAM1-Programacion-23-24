package ud1.api;

import java.util.Locale;
import java.util.Scanner;

public class LeerTiposPrimitivos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        byte varByte;
        System.out.print("Escribe un dato de tipo byte: ");
        varByte = sc.nextByte();
        System.out.println("Has introducido el valor " + varByte);

        int varInt;
        System.out.print("Escribe un dato de tipo int: ");
        varInt = sc.nextInt();
        System.out.println("Has introducido el valor " + varInt); 
        

        float varFloat;
        System.out.print("Escribe un dato de tipo float: ");
        varFloat = sc.nextFloat();
        System.out.println("Has introducido el valor " + varFloat);
        

        char varChar;
        System.out.print("Escribr un carácter: ");
        varChar = sc.next().charAt(0);
        System.out.println("Has introducido el valor " + varChar);
        sc.close();

        sc = new Scanner(System.in);
        String varString;
        System.out.print("Escribe una frase: ");
        varString = sc.nextLine();
        System.out.println("Has introducido el valor " + varString);
        sc.close();

        sc = new Scanner(System.in);
        boolean varBoolean;
        System.out.print("Escribe un valor booleano: ");
        varBoolean = sc.nextBoolean();
        System.out.println("Has introducido el valor " + varBoolean);

        sc.close();

    }
}
