package ud5.interfacesapuntes;

import java.util.Arrays;
import java.util.Comparator;

public class AppComparaSocios {
    public static void main(String[] args) {
        Socio[] socios = {
                new Socio(3, "Anselmo", "11-07-2002"),
                new Socio(1, "Josefa", "21-11-2001"),
                new Socio(2, "Ana", "07-12-1995"),
                new Socio(5, "Jorge", "20-01-2002"),
                new Socio(4, "Juan", "20-01-2002"),
                new Socio(7, "Juan", "20-01-2002")
        };

        System.out.println(Arrays.toString(socios));
        Arrays.sort(socios); // Orden natural = fecha Alta > id
        System.out.println(Arrays.toString(socios));

        ComparaSociosNombre comparadorPorNombre = new ComparaSociosNombre();
        Arrays.sort(socios, comparadorPorNombre);
        System.out.println(Arrays.toString(socios));

        Comparator comparadorPorId = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Socio s1 = (Socio) o1;
                Socio s2 = (Socio) o2;
                return s1.id - s2.id;
            };
        };

        Comparator comparadorporIdDesc = comparadorPorId.reversed();

        Arrays.sort(socios, comparadorPorId);

        System.out.println(Arrays.toString(socios));

        Socio socioABuscar = new Socio(6, "Ana", "07-12-1995");
        System.out.println(Arrays.binarySearch(socios, socioABuscar, comparadorPorId));

        Arrays.sort(socios, comparadorPorNombre.reversed());
        System.out.println(Arrays.toString(socios));

        Arrays.sort(socios, comparadorPorNombre.reversed().thenComparing(comparadorporIdDesc));

        System.out.println(Arrays.toString(socios));



    }

}
