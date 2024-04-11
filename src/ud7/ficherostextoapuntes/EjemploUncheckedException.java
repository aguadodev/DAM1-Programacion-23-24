package ud7.ficherostextoapuntes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjemploUncheckedException {
    public static void main(String[] args) {
        try {
            // Bloque de código susceptible de provocar una excepción
            System.out.println("EJEMPLOS DE EXCEPCIONES NO COMPROBADAS:");
            Scanner sc = new Scanner(System.in);
            System.out.println("(1) - Provoca ArithmeticException");
            System.out.println("(2) - Provoca ArrayIndexOutOfBoundsException");
            System.out.println("(3) - Provoca NullPointerException");
            System.out.println("(no entero) - Provoca InputMismatchException");
            System.out.print("Elige una opción: ");           
    
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: int a = 5/0;                        // División por cero
                case 2: int[] arr = new int[0]; arr[1] = 0; // Índice fuera del límite
                case 3: Integer i = null; i.compareTo(5);   // Acceso a un miembro de null
            }                        
        } catch (InputMismatchException e){
                System.out.println("InputMismatchException: " + e.getMessage());
        } catch (ArithmeticException e){
                System.out.println("ArithmeticException: " + e.getMessage());
        } catch (NullPointerException e){
                System.out.println("NullPointerException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e){
            // Se puede capturar cada excepción con su propio bloque catch() o
            // capturarlas todas indicando la clase "madre" Exception.
            System.out.println("\nEXCEPCIÓN!!");
            System.out.println("toString(): " + e); 
            System.out.println("Clase: " + e.getClass().getSimpleName());
            System.out.println("Mensaje: " + e.getMessage());
        } finally {
            // Este bloque se ejecutará siempre
            System.out.println("FIN DEL EJEMPLO");
        }        
    }
        
}
