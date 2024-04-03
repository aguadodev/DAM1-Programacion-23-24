package ud6.streamapuntes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class E1301 {
    public static void main(String[] args) {
        String nombre = "Pepe";

        Cliente cliente = new Cliente("1111", "Marta", 27);

        Saludo<String> saludoString = (n) -> "Hola " + n;

        System.out.println(saludoString.saludar(nombre));

        Saludo<Cliente> saludoCliente = c -> "Estimado/a " + c.nombre;

        System.out.println(saludoCliente.saludar(cliente));



        String[] nombres = {"Pepa", "Pepe", "Juan"};

        System.out.println(saludar(nombres, n -> "¿Cómo estás, " + n + "?"));

        Cliente[] clientes = { 
            new Cliente("1111", "Pepa", 24),
            new Cliente("2222", "Pepe", 29),
            new Cliente("3333", "Juan", 18)
        };        

        System.out.println(saludar(clientes, saludoCliente));

        System.out.println("Cliente de mayor edad: " + max(clientes, (a, b) -> a.edad - b.edad));

        System.out.println("Nombre alfabético descendente: " + max(nombres, (a, b) -> b.compareTo(a)));




    }



    static <T> T max(T[] t, Comparator<T> c){
        T max = null;

        if (t != null && t.length > 0) {
            max = t[0];
            for(T e : t){
                if (c.compare(max, e) < 0)
                    max = e;
            }
        }

        return max;
    }



    static <T> List<String> saludar(T[] t, Saludo<T> saludo) {
        List<String> saludar = new ArrayList<>();

        for(T e : t){
            saludar.add(saludo.saludar(e));
        }

        return saludar;
    }


}




interface Saludo <T> {
    String saludar(T t);
}
