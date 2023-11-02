package ud2.funcionesapuntes;

public class E0410 {
    public static void main(String[] args) {
        // Salida
        System.out.println("Potencia iterativa: " + potenciaIterativa(5, 3));

        System.out.println("Potencia recursiva: " + potenciaRecursiva(5, 3));
    }

    static double potenciaRecursiva(double a, int n) {
        double resultado = 1;

        // Algoritmo recursivo
        if (n == 0) {
            resultado = 1;
        } else {
            resultado = a * potenciaRecursiva(a, n - 1);
        }
        return resultado;
    }

    static double potenciaIterativa(double a, int n) {
        double resultado = 1;

        // Algoritmo iterativo
        for (int i = 0; i < n; i++) {
            resultado *= a;
        }

        return resultado;
    }

}
