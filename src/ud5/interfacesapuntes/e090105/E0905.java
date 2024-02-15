package ud5.interfacesapuntes.e090105;

import java.util.Arrays;
import java.util.Scanner;

public class E0905 {

    public static void main(String[] args) {

        /* CREA UNA COLA "ANÓNIMA" IMPLEMENTANDO EL INTERFAZ */
        Cola cola = new Cola() {
            Integer[] elementos = new Integer[0];

            public void encolar(Integer e) {
                elementos = Arrays.copyOf(elementos, elementos.length + 1);
                elementos[elementos.length - 1] = e;
            }

            public Integer desencolar() {
                Integer e = null;
                if (elementos.length > 0) {
                    e = elementos[0];
                    elementos = Arrays.copyOfRange(elementos, 1, elementos.length);
                }

                return e;
            }
        };


        /* USA EL OBJETO CREADO EN UN PROGRAMA */
        Integer numero;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un número entero (negativo para terminar): ");
        numero = sc.nextInt();

        while (numero >= 0) {
            cola.encolar(numero);
            System.out.println("Escribe otro número entero: ");
            numero = sc.nextInt();
        }

        System.out.println("Cola: Salida de elementos");
        numero = cola.desencolar();
        while (numero != null) {
            System.out.println(numero);
            numero = cola.desencolar();
        }

    }

}
