package ud6.coleccionesapuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AppColeccionClieGlobal {
    public static void main(String[] args) {

        // coleccionClie
        Collection<Cliente> coleccionClie = new ArrayList<>();        
        coleccionClie.add(new Cliente("111", "Marta", "12/02/2000"));        
        coleccionClie.add(new Cliente("115", "Jorge", "16/03/1999"));        
        coleccionClie.add(new Cliente("112", "Carlos", "01/10/2002"));        

        // coleccionClie
        Collection<Cliente> otrosClientes = new ArrayList<>();        
        otrosClientes.add(new Cliente("111", "Marta", "12/02/2000"));        
        otrosClientes.add(new Cliente("112", "Carlos", "01/10/2002"));       

        // containsAll
        System.out.println(coleccionClie.containsAll(otrosClientes)); // true

        otrosClientes.add(new Cliente("211", "Ana", "07/12/2001"));    
        
        System.out.println(coleccionClie.containsAll(otrosClientes)); // false

        // addAll
        coleccionClie.addAll(otrosClientes);
        System.out.println(coleccionClie);

        // removeAll
        otrosClientes.remove(new Cliente("111", "", ""));
        coleccionClie.removeAll(otrosClientes);

        // retainAll
        otrosClientes.add(new Cliente("111", "Marta", "12/02/2000"));
        coleccionClie.retainAll(otrosClientes);


        // toArray
        Object[] array = coleccionClie.toArray();

        // <T> toArray
        Cliente[] arrayClie = coleccionClie.toArray(new Cliente[0]);

        // asList
        Arrays.asList(arrayClie);















    }    
}
