package ud4.simud0401;

import java.util.Arrays;
import java.util.Scanner;

public class Abadias {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int altura;
        int[] alturas = new int[0];
        int[] cimasAbadias;

        System.out.println("\nABADÍAS PIRENAICAS");
        System.out.println("==================\n");

        System.out.println(
                "Introduce las alturas (en metros, sin decimales) de las montañas que componen una determinada cordillera montañosa, de Oeste a Este. La entrada terminará cuando se introduzca una altura negativa o se llegue al límite de 1000 montañas.");

        altura = sc.nextInt();

        while (altura >= 0 && alturas.length < 1000) {
            alturas = Arrays.copyOf(alturas, alturas.length + 1);
            alturas[alturas.length - 1] = altura;
            altura = sc.nextInt();
        }
        sc.close();

        cimasAbadias = cimasAbadias(alturas);

        System.out.println("Número de abadías: " + cimasAbadias.length);
        System.out.println("Orden de cimas en las que se puede construir (numerando desde el Oeste): " + Arrays.toString(cimasAbadias));

    }

    static int[] cimasAbadias(int[] t) {
        int[] cimasAbadias;

        if (t == null || t.length == 0) {
            cimasAbadias = new int[0];
        } else {
            cimasAbadias = new int[1];
            cimasAbadias[0] = t.length;
            int alturaMax = t[t.length - 1];
            

            for (int i = t.length - 2; i >= 0; i--) {
                if (t[i] > alturaMax) {
                    alturaMax = t[i];
                    cimasAbadias = Arrays.copyOf(cimasAbadias, cimasAbadias.length + 1);
                    cimasAbadias[cimasAbadias.length - 1] = i + 1;
                }
            }
        }

        Arrays.sort(cimasAbadias);

        return cimasAbadias;
    }

}
