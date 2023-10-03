package expresiones;

public class EOE09 {
    public static void main(String[] args) {
        int n = 123;
        char a = '9';
        int n2 = 43;

        System.out.println("Construir expresiones algorítmicas\n");

        boolean v10 = n / 100 % 2 == 1;
        System.out.println("10: (" + n + ") " + v10);

        boolean v12 = a >= 'A' && a <= 'Z';
        System.out.println("12: (" + a + ") " + v12);

        boolean v16 = !(a >= 'A' && a <= 'Z')  &&  !(a >= 'a' && a <= 'z');
        System.out.println("16: (" + a + ") " + v16);

        // Dado un número N de dos cifras, comprobar si las dos cifras son iguales.
        boolean v36 = (n2 % 10) == (n2 / 10);
        System.out.println("36: (" + n2 + ") " + v36);




    }

}
