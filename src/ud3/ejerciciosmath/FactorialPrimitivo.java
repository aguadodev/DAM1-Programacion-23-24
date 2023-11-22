package ud3.ejerciciosmath;

public class FactorialPrimitivo {
    public static long factorial(int n) {
        int factorial = 1;
        for(int i = n; i > 1; i--){
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 50; i++){
            System.out.println("Factorial de " + i + " = " + factorial(i));
        }
        

    }

}
