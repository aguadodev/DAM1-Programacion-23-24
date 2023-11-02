package ud1.expresiones;

public class EOE01 {
    public static void main(String[] args) {
        double varA = 3 / 2 + 4 / 3;
        System.out.println("varA: " + varA);

        double varAb = 3 / 2.0 + 4 / 3.0;
        System.out.println("varAb: " + varAb);

        // ...

        double a = 0, b = 0, x = 0;
        double varK = (Math.pow(a, 2) + 2 * a * b + Math.pow(b, 2)) / (1 / Math.pow(x, 2) + 2);
        System.out.println("varK: " + varK);

        // Pruebas de operaciones con división por cero.
        System.out.println("1 / Math.pow(0, 2): " + (1 / Math.pow(0, 2)));
        System.out.println("1 / 0: " + (1 / 0));

    }
}
