package ud2.excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        System.out.println("Escribe un número x para 100/x: ");
        int n = leerEnteroRecursiva();

        try {
            //int n = new Scanner(System.in).nextInt();
            System.out.println("Intentando división....");
            System.out.println(3/n);
            // Otro código 
        } catch (ArithmeticException e) {
            // TODO: handle exception
            System.out.println("No se puede dividir por cero");
        } catch (InputMismatchException e) {
            // TODO: handle exception
            System.out.println("El dato introducido no es un número entero");
        } catch (Exception e) {
            System.out.println("Se ha producido algún error...");
        }
        
    }

    static int leerEnteroRecursiva(){
        int n;

        try {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            sc.close();
        } catch (Exception e) {
            System.out.print("Por favor, introduce un número entero: ");
            n = leerEnteroRecursiva();
        }

        return n;
    }

        static int leerDoubleRecursiva(){
        int n;

        try {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            sc.close();
        } catch (Exception e) {
            System.out.print("Por favor, introduce un número, utilizando el punto como separador decimal: ");
            n = leerDoubleRecursiva();
        }

        return n;
    }

    static int leerEnteroIterativo(){
        int num = 0;
        boolean numeroInvalido;
    
        // Entrada de datos
        do {
            try {
                // Leer de teclado
                Scanner sc = new Scanner(System.in);        
                System.out.print("Introduce un entero: ");
                num = sc.nextInt();
                numeroInvalido = false;                
            } catch (Exception e) {
                // Código si la entrada por teclado genera una excepción
                numeroInvalido = true;
                System.out.println("Lo que has introducido no es dato de tipo int.");
            }
        } while (numeroInvalido);        
    
        return num;
    }
    
    
}
