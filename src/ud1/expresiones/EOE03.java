package ud1.expresiones;

public class EOE03 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int a=8, b=3, c=-5;

        System.out.println(a + b + c);
        System.out.println(2 * b + 3 * (a - c));
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println(a / c);
        System.out.println(a % c);
        System.out.println(a * b / c);
        System.out.println(a * (b / c));
        System.out.println((a * c) % b);
        System.out.println(a * (c % b));
        System.out.println((3 * a - 2 * b) % (2 * a - c));
        System.out.println(2 * ( a / 5 + (4 - b * 3)) % (a + c - 2));
        System.out.println((a - 3 * b) % (c + 2 * a) / (a - c));
        System.out.println(a - b - c * 2);
    }

}
