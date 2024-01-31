package ud5.clasesejercicios;

import java.util.Arrays;

public class Conjunto {
    private Integer[] elementos;

    public Conjunto() {
        elementos = new Integer[0];
    }

    public int numeroElementos(){
        return elementos.length;
    }

    boolean insertar(Integer nuevo) {
        boolean insertar = true;
        int i = 0;
        while (i < elementos.length && insertar) {
            if (elementos[i] == nuevo)
                insertar = false;
            else
                i++;
        }

        if (insertar){
            elementos = Arrays.copyOf(elementos, elementos.length + 1);
            elementos[elementos.length - 1] = nuevo;
        }

        return insertar;
    }


    public boolean insertar(Conjunto otroConjunto){
        boolean insertar = false;

        for (int i = 0; i < otroConjunto.numeroElementos(); i++){
            if (insertar(otroConjunto.elementos[i]))
                insertar = true;
        }

        return insertar;
    }

    boolean eliminar(Integer elemento){
        boolean eliminar = false;

        int i = 0;
        while (i < elementos.length && !eliminar){
            if (elementos[i] == elemento) {
                System.arraycopy(elementos, i + 1, elementos, i, elementos.length - i - 1);
                elementos = Arrays.copyOf(elementos, elementos.length - 1);
                eliminar = true;
            }
            i++;
        }

        return eliminar;
    }

    boolean eliminar(Conjunto otroConjunto){
        boolean eliminar = false;

        for (int i = 0; i < otroConjunto.numeroElementos(); i++) 
            if (eliminar(otroConjunto.elementos[i]))
                eliminar = true;

        return eliminar;
    }

    boolean pertenece(Integer elemento){
        boolean pertenece = false;

        int i = 0;
        while (i < elementos.length && !pertenece){
            if (elementos[i] == elemento)
                pertenece = true;
            i++;
        }

        return pertenece;
    }

    void mostrar(){
        System.out.println(Arrays.toString(elementos));
    }


    public static void main(String[] args) {
        Conjunto c = new Conjunto();

        System.out.println(c.insertar(7));
        System.out.println(c.insertar(6));
        System.out.println(c.insertar(5));

        /*System.out.println(c.eliminar(5));
        System.out.println(c.eliminar(6));
        System.out.println(c.eliminar(6));
        System.out.println(c.eliminar(7));*/

        
        Conjunto b = new Conjunto();

        System.out.println(b.insertar(4));
        System.out.println(b.insertar(2));
        System.out.println(b.insertar(3));

        System.out.println(c.eliminar(b));

        c.mostrar();

        System.out.println(c.pertenece(7));
        System.out.println(c.pertenece(4));


    }
    
}
