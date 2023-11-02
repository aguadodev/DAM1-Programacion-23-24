package ud2.funcionesapuntes;

public class E0408 {
    static double calculadora(double a, double b, int operacion) {
        double resultado = 0;

        switch (operacion) {
            case 1 -> resultado = a + b;
            case 2 -> resultado = a - b;
            case 3 -> resultado = a * b;
            case 4 -> resultado = a / b;
        }

        return resultado;
    }
}
