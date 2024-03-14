package ud6.coleccionesapuntes;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class AppConjuntosClie {
    public static void main(String[] args) {
        Set<Cliente> conjuntoClientes = new TreeSet<>();

        // add
        Cliente cliente = new Cliente("111", "Marta", "12/02/2000");
        conjuntoClientes.add(cliente);

        // remove
        conjuntoClientes.remove(new Cliente ("111", "", ""));
        conjuntoClientes.remove(cliente);

        //clear
        conjuntoClientes.add(cliente);
        conjuntoClientes.clear();

        // size
        conjuntoClientes.add(cliente);        
        conjuntoClientes.add(new Cliente("115", "Jorge", "16/03/1999"));        
        conjuntoClientes.add(new Cliente("112", "Carlos", "01/10/2002"));        
        System.out.println(conjuntoClientes.size());

        // isEmpty
        System.out.println(conjuntoClientes.isEmpty());

        // contains
        System.out.println(conjuntoClientes.contains(cliente));
        // La siguiente sentencia también permite buscar por dni
        System.out.println(conjuntoClientes.contains(new Cliente("111"))); 

        // Se puede conjuntoClientes.contains("111");

        // toString
        System.out.println(conjuntoClientes);

        // Sin repetidos
        conjuntoClientes.add(new Cliente("115", "Jorge", "16/03/1999"));        
        conjuntoClientes.add(new Cliente("112", "Carlos", "01/10/2002"));   
        
        // toString
        System.out.println(conjuntoClientes);    


        // Iterar - iterador
        Iterator<Cliente> it = conjuntoClientes.iterator();
        while (it.hasNext()) {
            Cliente c = it.next();
            System.out.println(c);
            if (c == new Cliente("112","",""))
                it.remove();
        }   

        // Iterar - bucle for-each
        for (Cliente c : conjuntoClientes) {
            System.out.println(c);
        }





    }    
}
