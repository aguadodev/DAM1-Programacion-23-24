package ud4.stringsapuntes;

public class E0610 {
    public static void main(String[] args) {
        System.out.println(esPalindromo("Dabale arroz a la zorra el abad")); // true
        System.out.println(esPalindromo("Dábale arroz a la zorra el abad")); // false
        System.out.println(esPalindromo2("Dábale arroz a la zorra el abad"));// true

    }

    public static Boolean esPalindromo(String str) {
        Boolean esPalindromo = true;

        int i = 0;
        str = str.replace(" ", "").toLowerCase();
        System.out.println(str);
        while (esPalindromo && i < str.length() / 2) {
            if (!(str.charAt(i) == str.charAt(str.length() - 1 - i)))
                esPalindromo = false;
            i++;
        }

        return esPalindromo;
    }

    public static Boolean esPalindromo2(String str) {
        Boolean esPalindromo = true;

        int i = 0;
        str = str.replace(" ", "").toLowerCase();
        System.out.println(str);
        while (esPalindromo && i < str.length() / 2) {
            char ch1 = letraSinTilde(str.charAt(i));
            char ch2 = letraSinTilde(str.charAt(str.length() - 1 - i));
            if (!(ch1 == ch2))
                esPalindromo = false;
            i++;
        }

        return esPalindromo;
    }

    private static char letraSinTilde(char ch) {
        return switch (ch) {
            case 'á' -> 'a';
            case 'é' -> 'a';
            case 'í' -> 'a';
            case 'ó' -> 'a';
            case 'ú' -> 'a';
            case 'ü' -> 'a';
            case 'Á' -> 'a';
            case 'É' -> 'a';
            case 'Í' -> 'a';
            case 'Ó' -> 'a';
            case 'Ú' -> 'a';
            case 'Ü' -> 'a';
            default -> ch;
        };
    }
}
