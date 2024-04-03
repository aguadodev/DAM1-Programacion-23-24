package ud6.streamapuntes;

import java.util.function.Consumer;

public class E1306 {
    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente("12345678A", "Pepe"),  
            new Cliente("87654321B", "Ana"),
            new Cliente("12348765C", "Luis"),
            new Cliente("87651234D", "María")
        };

        // Rellena la tabla con datos......

        // Imprime el nombre y el dni de todos los clientes
        paraCada(clientes, c -> System.out.println(c.nombre + " (" + c.dni + ")"));
    }

    static <T> void paraCada(T[] t, Consumer<T> c){
        for(T e : t)
            c.accept(e);
    }
}
