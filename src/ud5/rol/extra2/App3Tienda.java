package ud5.rol.extra2;

public class App3Tienda {

    public static void main(String[] args) {
        System.out.println("\n1. Tienda");
        System.out.println("===========\n");

        PersonajeEx arturo = new PersonajeEx("Arturo", "HUMANO");
        
        arturo.setMonedas(1500);

        arturo.addToInventario(new Item("Cota de Malla", 10, 2000));
        arturo.addToInventario(new Item("Espada larga", 3, 10000));
        arturo.addToInventario(new Item("Espadón a dos manos", 5, 1000));
        arturo.addToInventario(new Item("Pan", 1, 1));
        arturo.addToInventario(new Item("Agua", 2, 1));
        arturo.addToInventario(new Item("Daga", 0.5, 200));
        arturo.addToInventario(new Item("Antorcha", 0.5, 10));

        arturo.mostrarInventario();


       /* Tienda t = new Tienda("El bazar de Lilo");
        Item[] stock = {
            new Item("Coraza", 15, 3000),
            new Item("Espada corta", 2, 500),
            new Item("Arco largo", 1.5, 1000),
            new Item("Ganzúas", 0.25, 20),
            new Item("Pan", 1, 1),
            new Item("Pan", 1, 1),
            new Item("Pan", 1, 1),
            new Item("Pan", 1, 1),
            new Item("Agua", 2, 1),
            new Item("Agua", 2, 1),
            new Item("Agua", 2, 1),
            new Item("Cuerda", 3, 20),
            new Item("Antorcha", 0.5, 10)            
        };

        t.setStock(stock);

        t.mostrar();

        arturo.comprar(t, 2);*/

    }
}