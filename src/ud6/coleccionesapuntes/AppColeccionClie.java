package ud6.coleccionesapuntes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AppColeccionClie {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();

        Collection<Cliente> coleccionClie = listaClientes;

        // add
        Cliente cliente = new Cliente("111", "Marta", "12/02/2000");
        coleccionClie.add(cliente);

        // remove
        coleccionClie.remove(cliente);

        //clear
        coleccionClie.add(cliente);
        coleccionClie.clear();

        // size
        coleccionClie.add(cliente);        
        coleccionClie.add(new Cliente("115", "Jorge", "16/03/1999"));        
        coleccionClie.add(new Cliente("112", "Carlos", "01/10/2002"));        
        System.out.println(coleccionClie.size());

        // isEmpty
        System.out.println(coleccionClie.isEmpty());

        // contains
        System.out.println(coleccionClie.contains(cliente));
        // La siguiente sentencia también permite buscar por dni
        // coleccionClie.remove(new Cliente("111", "", ""));        

        // toString
        System.out.println(coleccionClie);

        // Iterar - iterador
        Iterator<Cliente> it = coleccionClie.iterator();
        while (it.hasNext()) {
            Cliente c = it.next();
            System.out.println(c);
            if (c == new Cliente("112","",""))
                it.remove();
        }   

        // Iterar - bucle for-each
        for (Cliente c : coleccionClie) {
            System.out.println(c);
        }





    }    
}
