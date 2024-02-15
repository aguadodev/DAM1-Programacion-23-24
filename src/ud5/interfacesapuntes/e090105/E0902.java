package ud5.interfacesapuntes.e090105;

import java.util.Scanner;

public class E0902 {
    public static void main(String[] args) {
        Lista cola = new Lista();
        Lista pila = new Lista();
        ColaDoble colaDoble = new Lista();
        int numero;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un número entero (negativo para terminar): ");
        numero = sc.nextInt();

        while (numero >= 0) {
            cola.encolar(numero);
            pila.apilar(numero);
            System.out.println("Escribe otro número entero: ");
            numero = sc.nextInt();
        }

        System.out.println("Cola: Salida de elementos");
        while (cola.length() > 0){
            System.out.println(cola.desencolar());
        }

        System.out.println("Pila: Salida de elementos");
        while (pila.length() > 0){
            System.out.println(pila.desapilar());
        }
   
    }
}
