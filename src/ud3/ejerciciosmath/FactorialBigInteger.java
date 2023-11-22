package ud3.ejerciciosmath;
import java.math.BigInteger;

public class FactorialBigInteger {
    public static void main(String[] args) {
        int numero = 50;

        BigInteger factorial = factorial(numero);

        System.out.println("El factorial de " + numero + " es: " + factorial);
    }

    private static BigInteger factorial(int n) {
        BigInteger resultado = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }

        return resultado;
    }
}
