package ud5.rol.rolex;

import java.util.Arrays;

public class Tienda {

    String nombre;
    Item[] inventario;
    int monedas;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.inventario = new Item[0];
        this.monedas = 0;
    }

    public boolean addToInventario(Item item) {
        boolean anhadido = false;
        if (item != null /* && item no existe en el stock */) {
            for (int i = 0; i < inventario.length; i++) {
                if (inventario[i].equals(item)) {
                    inventario = Arrays.copyOf(inventario, inventario.length + 1);
                    inventario[inventario.length - 1] = item;
                    anhadido = true;
                }
            }
        }
        return anhadido;
    }

    /**
     * Muestra el inventario de la tienda.
     */
    public void mostrarInventario() {
        System.out.println("Inventario de " + nombre + ":");
        for (int i = 1; i <= inventario.length; i++)
            System.out.print(i + ". " + inventario[i - 1]);
    }

    public Item getItem(int i) {
        return inventario[i];
    }

    /**
     * Elimina un item del inventario.
     * 
     * @param i Índice del item a eliminar.
     * @return true si se ha eliminado el item.
     */
    public boolean eliminarItem(int i) {
        boolean eliminado = false;
        if (i >= 0 && i < inventario.length) {
            for (int j = i; j < inventario.length - 1; j++)
                inventario[j] = inventario[j + 1];
            inventario = Arrays.copyOf(inventario, inventario.length - 1);
            eliminado = true;
        }
        return eliminado;
    }

    /**
     * Elimina un item del inventario.
     * 
     * @param item Item a eliminar.
     * @return true si se ha eliminado el item.
     */
    public boolean eliminarItem(Item item) {
        boolean eliminado = false;
        if (item != null) {
            for (int i = 0; i < inventario.length; i++) {
                if (inventario[i].equals(item)) {
                    for (int k = i; k < inventario.length - 1; k++)
                        inventario[k] = inventario[k + 1];
                    inventario = Arrays.copyOf(inventario, inventario.length - 1);
                    eliminado = true;
                    break;
                }
            }
        }
        return eliminado;
    }

    /*
     * 
     * public boolean vender()
     */
}
