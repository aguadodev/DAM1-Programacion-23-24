package ud5.interfacesapuntes.e090104;

import java.util.Arrays;

public class Lista implements Cola, Pila {
    private Integer[] elementos;

    public Lista() {
        elementos = new Integer[0];
    }

    /** Interfaz Cola */
    public void encolar(Integer e) {
        insertarFinal(e);
    }

    public Integer desencolar() {
        return eliminarEn(0);
    }

    /** Interfaz Pila */
    @Override
    public void apilar(Integer e) {
        insertarFinal(e);
    }

    @Override
    public Integer desapilar() {
        return eliminarEn(elementos.length - 1);
    }


    
    /** Métodos propios de Lista */
    public int length() {
        return elementos.length;
    }

    public void insertarFinal(Integer e) {
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        elementos[elementos.length - 1] = e;
    }

    public void insertarInicio(Integer e) {
        Integer[] aux = new Integer[elementos.length + 1];
        System.arraycopy(elementos, 0, aux, 1, elementos.length);
        aux[0] = e;
        elementos = aux;
    }

    public void insertarEn(Integer e, int i) {
        Integer[] aux = Arrays.copyOf(elementos, elementos.length + 1);
        aux[i] = e;
        System.arraycopy(elementos, i, aux, i + 1, elementos.length - i);
        elementos = aux;
    }

    public void insertarFinal(Lista l) {
        elementos = Arrays.copyOf(elementos, elementos.length + l.length());
        System.arraycopy(l.elementos, 0, elementos, elementos.length - l.length(), l.length());
    }

    public Integer eliminarEn(int i) {
        Integer e = null;

        if (i >= 0 && i < elementos.length) {
            e = elementos[i];
            Integer[] aux = Arrays.copyOf(elementos, elementos.length - 1);
            System.arraycopy(elementos, i + 1, aux, i, elementos.length - i - 1);
            elementos = aux;
        }

        return e;
    }

    public Integer valorEn(int i) {
        return (i >= 0 && i < elementos.length) ? elementos[i] : null;
    }

    public int buscar(Integer e) {
        int i = 0;
        int pos = -1;
        while (i < elementos.length && pos == -1) {
            if (elementos[i] == e)
                pos = i;
            i++;
        }

        return pos;
    }

    public void mostrar() {
        System.out.println(Arrays.toString(elementos));
    }

    public static Lista concatena(Lista l1, Lista l2) {

        // 1. CopyOf + ArrayCopy return

        // 2. Usando insertarFinal

        Lista l = l1;

        l.insertarFinal(l2);

        return l;
    }

    public static void main(String[] args) {
        Lista l = new Lista();

        System.out.println("Longitud inicial: " + l.length());

        l.insertarFinal(7);
        l.insertarInicio(6);
        l.insertarInicio(6);
        l.insertarFinal(7); // 6677
        l.insertarEn(5, 2); // 66577
        l.mostrar();

        Lista l2 = new Lista();
        l2.insertarFinal(1);
        l2.insertarFinal(2);
        l2.insertarFinal(3);

        l.insertarFinal(l2); // 66577123

        l.eliminarEn(4); // 6657123

        System.out.println("Posición del valor 1: " + l.buscar(1));

        Lista.concatena(l, l2);

        l.mostrar();

    }

}
