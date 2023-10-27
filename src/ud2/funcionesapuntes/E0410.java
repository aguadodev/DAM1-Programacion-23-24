package ud2.funcionesapuntes;

public class E0410 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        double pot = potencia (5, 3);
    
        // Salida
        System.out.println(pot);
    }
    
    static double potencia(double b, int e) {
        double resultado = 1;
    
        // Algoritmo recursivo
        if (e == 0) {
            resultado = 1;
        } else {
            resultado = b * potencia (b, e - 1);
        }
    
        // Algoritmo iterativo
        /*
        for (int i = 0; i < e; i++) {
            resultado *= b;
        }*/              
    
        return resultado;
    }
        
}
