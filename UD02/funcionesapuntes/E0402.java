package UD02.funcionesapuntes;

public class E0402 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int num1 = 6, num2 = 18;
    
        // Proceso & Salida
        numerosEntre(num1, num2);
    
        numerosEntre(13, 27);
    }
    
    static void numerosEntre(int inicio, int fin) {
        // Imprime los números entre los valores pasados como parámetros, inclusive
        for (int i = inicio; i <= fin; i++) {
            System.out.println(i);
        }
    }
        
}
