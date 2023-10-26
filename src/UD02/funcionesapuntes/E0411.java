package ud02.funcionesapuntes;

public class E0411 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int mcd = mcd(45, 132);
    
        // Salida
        System.out.println(mcd);
    }
    
    static int mcd(int a, int b) {
        int resultado = 0;
    
        if (a == 0) {
            resultado = b;
        } else if (b == 0) {
            resultado = a;
        } else if (b > a) {
            resultado = mcd(a, b - a);
        } else if (a >= b) {
            resultado = mcd(a - b, b);
        }
    
        return resultado;
    }
        
}
