package ud1.expresiones;

public class EOE08 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        char c1='E', c2='5', c3='?';

        // Salida
        System.out.println((char)(c1 + 1) + " - " + (c1 + 1));
        System.out.println((char)(c1 - c2 + c3) + " - " + (c1 - c2 + c3));
        System.out.println((char)(c2 - 2) + " - " + (c2 - 2));
        System.out.println((char)(c2 - '2') + " - " + (c2 - '2'));
        System.out.println((char)(c3 + '#') + " - " + (c3 + '#'));
        System.out.println((char)(c1 % c3) + " - " + (c1 % c3));
        System.out.println((char)('2' + '2') + " - " + ('2' + '2'));
        System.out.println((char)((c1 / c2) * c3) + " - " + ((c1 / c2) * c3));
        System.out.println((char)(3 * c2) + " - " + (3 * c2));
        System.out.println((char)('3' * c2) + " - " + ('3' * c2));

    }

}
