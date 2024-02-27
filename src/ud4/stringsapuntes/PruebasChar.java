package ud4.stringsapuntes;

public class PruebasChar {
    public static void main(String[] args) {
        char a = 'a';
        char b = 97;
        char c = '\u0061';
        char d = '\u2661';
        char e = '\u2708';
        char comilla = '\'';
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(comilla);

        int f = '1';
        System.out.println(f);

        int g = 'g';
        char chg = (char) (g + 'A' - 'a');
        System.out.println(chg);

        System.out.println(Character.isDigit(f));
        System.out.println(Character.isLowerCase('Ñ'));
        //System.out.println(Character.isEmoji('\u1F4A'));

    }
}
