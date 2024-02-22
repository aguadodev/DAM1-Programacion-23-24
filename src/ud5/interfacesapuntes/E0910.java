package ud5.interfacesapuntes;

import java.util.Arrays;
import java.util.Comparator;

public class E0910 {
    public static void main(String[] args) {
        Comparator ordenNaturalInverso = Comparator.reverseOrder();
        Comparator ordenNaturalInverso2 = Comparator.naturalOrder().reversed();

        Integer[] numeros = {4,7,2,9,2123,56,23,964,456,42,13,765};

        Arrays.sort(numeros, ordenNaturalInverso2);

        System.out.println(Arrays.toString(numeros));

    }
}    
