package ud6.coleccionesapuntes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;


public class E1204 {

    public static void main(String[] args) {
        Collection<Integer> coleccion = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe números enteros. -1 para terminar");

        // Leer un elemento (lectura anticipada)
        int n = sc.nextInt();

        while (n != -1) {
            // Hacer cosas
            coleccion.add(n);
            // Leer siguiente elemento
            n = sc.nextInt();
        }

        System.out.println(coleccion);

        System.out.println("Números pares: ");
        for(Integer num : coleccion) 
            if (num % 2 == 0)
                System.out.print(num + " ");


        System.out.println("Números pares: (con Iterador)");

        Iterator<Integer> it = coleccion.iterator();

        while (it.hasNext()){
            Integer num2 = it.next();
            //coleccion.remove(num2); // ERROR => modifico la colección con métodos ajenos al iterador!!
            if (num2 % 2 == 0)
                System.out.print(num2 + " ");
        }

        System.out.println("Eliminar múltiplos de 3: ");
        it = coleccion.iterator();

        while (it.hasNext()){
            Integer num = it.next();
            if (num % 3 == 0)
                it.remove();
        }
        System.out.println(coleccion);
        
        
        /*
        for (Integer num : coleccion)
            if (num % 3 == 0)
                coleccion.remove (num);
 */                


    }


}
