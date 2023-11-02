package ud2.funcionesapuntes;

public class E0402 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int num1 = 6, num2 = 18;
    
        // Proceso & Salida
        imprimirNumerosEntre(num1, num2);
    
        imprimirNumerosEntre(13, 27);
    }
    
    static void imprimirNumerosEntre(int inicio, int fin) {
        // Imprime los números entre los valores pasados como parámetros, inclusive
        for (int i = inicio; i <= fin; i++) {
            System.out.println(i);
        }
    }
        
}
