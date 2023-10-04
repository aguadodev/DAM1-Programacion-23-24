package expresiones;

import java.time.LocalDate;

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

        // Con DN, MN, AN  día, mes y año de nacimiento de una persona y DA, MA, AA día, mes y año actual, 
        // escribe la expresión algorítmica que compruebe si tiene 18 años cumplidos.
        int dn = 3;
        int mn = 10;
        int an = 2000;
        int da = LocalDate.now().getDayOfMonth();
        int ma = LocalDate.now().getMonthValue();
        int aa = LocalDate.now().getYear();
        boolean v28 = (aa > an + 18) || (aa - an == 18 && ma > mn) || (aa - an == 18 && ma == mn && da > dn);
        System.out.println("28: Mayor de edad? " + v28);

        // Dado un número N de dos cifras, comprobar si las dos cifras son iguales.
        boolean v36 = (n2 % 10) == (n2 / 10);
        System.out.println("36: (" + n2 + ") " + v36);




    }

}
