package ud6.coleccionesejercicios;

import java.util.ArrayList;

public class EP1231 {
    public static void main(String[] args) {
        // Programa principal de pruebas de Cola<T> y Pila<T>
        Cola<Integer> cola = new Cola<>();

        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);

        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());

        Pila<String> pila = new Pila<>();

        pila.apilar("Lola");
        pila.apilar("Maria");
        pila.apilar("Pepa");

        System.out.println(pila.desapilar());
        System.out.println(pila.desapilar());
        System.out.println(pila.desapilar());
        System.out.println(pila.desapilar());
    }
}

/**
 * Cola<T>
 */
class Cola<T> extends ArrayList<T> {

    public void encolar(T e) {
        add(e);
    }

    public T desencolar() {
        if (size() > 0)
            return remove(0);
        else
            return null;
    }
}

class Pila<T> extends ArrayList<T> {

    public void apilar(T e) {
        add(e);
    }

    public T desapilar() {
        if (size() > 0)
            return remove(size() - 1);
        else
            return null;

    }

}