package ud2.funcionesapuntes;

public class Multiplicador {
    
    public static int multiplicar(int a, int b) {
        return a * b;
    }
    
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static int multiplicar(int a, int b, int c){
        return a * b * c;
    }

    public static void main(String[] args) {
        System.out.println(multiplicar(5, 5.0));
        System.out.println(multiplicar(5, 5));
        System.out.println(multiplicar(5, 5, 5));
    }
} 