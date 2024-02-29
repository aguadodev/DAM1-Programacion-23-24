package ud5.rol.extra2;

public class App1Inventario {

    public static void main(String[] args) {
        System.out.println("\n1. Inventario de personaje");
        System.out.println("==========================\n");

        PersonajeEx arturo = new PersonajeEx("Arturo", "HUMANO");
        
        arturo.setMonedas(1500);

        arturo.addToInventario(new Item("Cota de Malla", 10, 2000));
        arturo.addToInventario(new Item("Espada larga", 3, 10000));
        arturo.addToInventario(new Item("Espadón a dos manos", 5, 1000));
        arturo.addToInventario(new Item("Pan", 1, 1));
        arturo.addToInventario(new Item("Agua", 2, 1));
        arturo.addToInventario(new Item("Daga", 0.5, 200));
        arturo.addToInventario(new Item("Antorcha", 0.75, 10));

        arturo.mostrarInventario();

        System.out.println();
        System.out.println("Carga total transportada: " + arturo.getCargaActual() 
        + "/" + arturo.getCargaMaxima() + " kilos");
        
    }
}