package ud1.expresiones;

import java.time.LocalDate;

public class EOE09 {
    public static void main(String[] args) {
        int n = 623; // número de 3 cifras
        char a = '9';
        int n2 = 43;

        System.out.println("Construir expresiones algorítmicas\n");

        // La suma de los dígitos de un número entero N de 3 cifras
        int v6 = (n % 10) + (n / 10 % 10) + (n / 100);
        System.out.println("6: (" + n + ") " + v6);


        boolean v10 = n / 100 % 2 == 1;
        System.out.println("10: (" + n + ") " + v10);

        boolean v12 = a >= 'A' && a <= 'Z';
        System.out.println("12: (" + a + ") " + v12);

        boolean v16 = !(a >= 'A' && a <= 'Z')  &&  !(a >= 'a' && a <= 'z');
        System.out.println("16: (" + a + ") " + v16);


        // 23. Una variable entera M contiene un número de mes codificado de 1 (enero) a 12 (diciembre). Comprobar si corresponde a un mes de 30 días.
        int mes = 11;
        boolean v23 = mes == 4 || mes == 6 || mes == 9 || mes == 11;
        System.out.println("23: (" + mes + ") " + v23);

        // 28. Con DN, MN, AN  día, mes y año de nacimiento de una persona y DA, MA, AA día, mes y año actual, 
        // escribe la expresión algorítmica que compruebe si tiene 18 años cumplidos.
        int dn = 3;
        int mn = 10;
        int an = 2000;
        int da = LocalDate.now().getDayOfMonth();
        int ma = LocalDate.now().getMonthValue();
        int aa = LocalDate.now().getYear();
        boolean v28 = (aa > an + 18) || (aa - an == 18 && ma > mn) || (aa - an == 18 && ma == mn && da >= dn);
        System.out.println("28: Mayor de edad? " + v28);

        // 31. Determinar si un número entero N de 5 cifras es capicúa.
        int n5 = 12321;
        boolean v31 = n5 % 10 == n5 / 10000 && n5 / 10 % 10 == n5 / 1000 % 10;
        System.out.println("31: (" + n5 + ") " + v31);

        // 36. Dado un número N de dos cifras, comprobar si las dos cifras son iguales.
        boolean v36 = (n2 % 10) == (n2 / 10);
        System.out.println("36: (" + n2 + ") " + v36);




    }

}
