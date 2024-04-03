package ud6.streamapuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Interfaz Saludo
 */
public interface Saludo<T> {
    public String saludar(T t);

}

/**
 * Ejemplos
 */
class Ejemplos {
    public static void main(String[] args) {
        // Saludo para nombres
        Saludo<String> saludo = nombre -> "Hola " + nombre;
        
        System.out.println(saludo.saludar("Juan"));
        
        // Saludo para clientes
        Saludo<Cliente> saludoCliente = cliente -> "Estimado/a cliente " + cliente.nombre;

        System.out.println(saludoCliente.saludar(new Cliente("123", "Marta")));


        // Saludo a un grupo de nombres
        String[] nombres = {"Juan", "Marta", "Pedro"};
        System.out.println(saludar(nombres, saludo));

        Cliente[] clientes = {new Cliente("123", "Marta"), new Cliente("456", "Pedro")};
        System.out.println(saludar(clientes, c -> "Querido/a cliente " + c.nombre));


        // Obtiene el máximo de una tabla
        System.out.println(max(nombres, Comparator.reverseOrder()));
        System.out.println(max(clientes, (a,b) -> a.dni.compareTo(b.dni)));

    }

    /**
     * Saluda a un grupo de elementos
     * @param <T> 
     * @param grupo
     * @param saludo
     * @return List<String> 
     */
    static <T> List<String> saludar(T[] grupo, Saludo<T> saludo) {
        List<String> saludos = new ArrayList<>();
        for (T e : grupo) {
            saludos.add(saludo.saludar(e));
        }
        return saludos;
    }


    static <T> T max(T[] t, Comparator<T> c){
        T max = null;
        if (t != null && t.length > 0) {
            max = t[0];
            for (T e : t) {
                if (c.compare(e, max) > 0)
                    max = e;
            }
        }
        return max;
    }


}


/**
 * Clase Cliente
 */ 
class Cliente {
    String dni;
    String nombre;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", nombre=" + nombre + "]";
    }
    
}