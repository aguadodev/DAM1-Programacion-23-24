package ud5.rol.rolex;

public class App3Tienda {

    public static void main(String[] args) {
        System.out.println("\n1. Tienda");
        System.out.println("===========\n");

        PersonajeEx arturo = new PersonajeEx("Arturo", "HUMANO");
        
        arturo.setMonedas(1500);

        arturo.addToInventario(new Armadura("Cota de Malla", 10, 2000, 20, "ARMADURA"));
        arturo.addToInventario(new Arma("Espada larga", 3, 10000, 60, false));
        arturo.addToInventario(new Arma("Espadón a dos manos", 5, 1000, 40, true));
        arturo.addToInventario(new Item("Pan", 1, 1));
        arturo.addToInventario(new Item("Agua", 2, 1));
        arturo.addToInventario(new Item("Daga", 0.5, 200));
        arturo.addToInventario(new Item("Antorcha", 0.5, 10));

        arturo.mostrarInventario();
        System.out.println();


        Tienda t = new Tienda("El bazar de Lilo");
        t.addToInventario(new Armadura("Coraza", 15, 3000, 20, "ARMADURA"));
        t.addToInventario(new Arma("Espada corta", 2, 500, 30, false));
        t.addToInventario(new Arma("Arco largo", 1.5, 1000, 45, true));
        t.addToInventario(new Item("Ganzúas", 0.25, 20));
        t.addToInventario(new Item("Pan", 1, 1));
        t.addToInventario(new Item("Pan", 1, 1));
        t.addToInventario(new Item("Pan", 1, 1));
        t.addToInventario(new Item("Pan", 1, 1));
        t.addToInventario(new Item("Agua", 2, 1));
        t.addToInventario(new Item("Agua", 2, 1));
        t.addToInventario(new Item("Cuerda", 3, 20));
        t.addToInventario(new Item("Antorcha", 0.5, 10));

        t.mostrarInventario();

        //t.vender(t.getItem(5), arturo); // La tienda vende un item a Arturo
        //arturo.comprar(t.getItem(1), t); // Arturo compra un item a la tienda

    }
}