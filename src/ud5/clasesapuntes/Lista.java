package ud5.clasesapuntes;

import java.util.Arrays;

public class Lista {
    private Integer[] elementos;

    public Lista() {
        elementos = new Integer[0];
    }

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


    public void insertarFinal(Lista l){
        elementos = Arrays.copyOf(elementos, elementos.length + l.length());
        System.arraycopy(l.elementos, 0, elementos, elementos.length - l.length(), l.length());
    }

    public void eliminarEn(int i){
        Integer[] aux = Arrays.copyOf(elementos, elementos.length - 1);
        System.arraycopy(elementos, i + 1, aux, i, elementos.length - i - 1);
        elementos = aux;
    }

    


    public void mostrar(){
        System.out.println(Arrays.toString(elementos));
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


        l.mostrar();      

    }




}
