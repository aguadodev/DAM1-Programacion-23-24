package ud3.api;
import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int numero = 50;

        BigInteger factorial = calcularFactorial(numero);

        System.out.println("El factorial de " + numero + " es: " + factorial);
    }

    private static BigInteger calcularFactorial(int n) {
        BigInteger resultado = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }

        return resultado;
    }
}
