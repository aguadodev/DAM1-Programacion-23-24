package ud6.streamapuntes;

import java.util.Arrays;
import java.util.Comparator;

public class EjemploLambda {
    public static void main(String[] args) {
        Cliente[] clientes = { 
                new Cliente("1111", "Pepa", 24),
                new Cliente("2222", "Pepe", 29),
                new Cliente("3333", "Juan", 18)
            };

        Arrays.sort(clientes, new CompClienteNombre());

        System.out.println("Ordenar por Nombre: " + Arrays.toString(clientes));


        Arrays.sort(clientes, new Comparator<>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.edad - o2.edad;
            }            
        });

        System.out.println("Ordenar por Edad: " + Arrays.toString(clientes));


        Arrays.sort(clientes, (o1, o2) -> o1.dni.compareTo(o2.dni));
        
        System.out.println("Ordenar por Dni: " + Arrays.toString(clientes));




    }
}

/**
 * Cliente
 */
class Cliente {
    String dni;
    String nombre;
    int edad;

    public Cliente(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
    }



}