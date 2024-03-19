package ud6.coleccionesapuntes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AP1205 {
    public static void main(String[] args) {
        Set<Cliente> conjuntoClientes = new TreeSet<>();

        // add
        Cliente cliente = new Cliente("111", "Marta", "12/02/2000");        
        conjuntoClientes.add(cliente);        
        conjuntoClientes.add(new Cliente("115", "Jorge", "16/03/1999"));        
        conjuntoClientes.add(new Cliente("112", "Carlos", "01/10/2002"));        
        conjuntoClientes.add(new Cliente("117", "Carlos", "01/11/2002"));        
 
        // toString
        System.out.println(conjuntoClientes);    

        // Elementos ordenados por Edad
        Set<Cliente> aux = new TreeSet<>(new Comparator<Cliente>() {

            @Override
            public int compare(Cliente o1, Cliente o2) {
                int cEdad = o1.edad() - o2.edad();
                if (cEdad != 0) 
                    return cEdad;
                else
                    return o1.nombre.compareTo(o2.nombre);
            }
            
          });

          aux.addAll(conjuntoClientes);
          System.out.println("Clientes ordenados por Edad");
          System.out.println(aux + "\n\n");

          List<Cliente> listaOrdenada = new ArrayList<>(conjuntoClientes);

          listaOrdenada.sort(new Comparator<Cliente>() {
  
              @Override
              public int compare(Cliente o1, Cliente o2) {
                  return o1.edad() - o2.edad();
              }
              
            });
            Set<Cliente> cOrdenado = new LinkedHashSet<>(listaOrdenada);
            System.out.println("Conjunto de Clientes ordenados por Edad");
            System.out.println(cOrdenado + "\n\n");

        // Elementos ordenados por Nombre


        
    }
}
