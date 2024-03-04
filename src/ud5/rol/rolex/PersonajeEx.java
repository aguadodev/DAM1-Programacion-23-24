package ud5.rol.rolex;

import java.util.Arrays;

import ud5.rol.Personaje;

public class PersonajeEx extends Personaje {

    protected final static int CARGA_BASE = 50;

    protected int monedas;
    protected Item[] inventario;
    protected Item itemManoIzq;
    protected Item itemManoDch;
    protected Armadura armaduraCabeza;
    protected Armadura armaduraCuerpo;

    public PersonajeEx(String nombre, String raza) {
        super(nombre, Raza.valueOf(raza));
        inventario = new Item[0];
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public Item[] getInventario() {
        return inventario;
    }

    public void setInventario(Item[] inventario) {
        this.inventario = inventario;
    }

    /**
     * Añade un item al inventario del personaje.
     * Si el peso total al añadir el item supera la carga máxima, no se añade.
     * @param item Item a añadir.
     * @return true si se ha añadido el item.
     */
    public boolean addToInventario(Item item) {
        boolean anhadido = false;
        if (getCargaActual() + item.peso <= getCargaMaxima()) {
            inventario = Arrays.copyOf(inventario, inventario.length + 1);
            inventario[inventario.length - 1] = item;
            anhadido = true;
        }
        return anhadido;
    }

    /**
     * Muestra el inventario del personaje.
     */
    public void mostrarInventario() {
        System.out.println("Inventario de " + nombre + ":");
        for (int i = 1; i <= inventario.length; i++)
            System.out.print(i + ". " + inventario[i - 1]);
    }

    /*
     * TODO public void deleteFromInventario(Item item) {
     * this.inventario = inventario;
     * }
     */

    public Item getItemManoIzq() {
        return itemManoIzq;
    }

    public void setItemManoIzq(Item itemManoIzq) {
        this.itemManoIzq = itemManoIzq;
    }

    public Item getItemManoDch() {
        return itemManoDch;
    }

    public void setItemManoDch(Item itemManoDch) {
        this.itemManoDch = itemManoDch;
    }

    /**
     * Devuelve la carga actual del personaje.
     * @return Carga actual en kilos con decimales.
     */
    public double getCargaActual() {
        double peso = 0;
        for (Item i : inventario)
            peso += i.peso;
        return peso;
    }

    /**
     * Devuelve la carga máxima que puede soportar el personaje.
     * @return Carga máxima en kilos.
     */
    public int getCargaMaxima() {
        return CARGA_BASE + constitucion * 2;
    }

    /**
     * Equipa una armadura en la cabeza, cuerpo o escudo.
     * 
     * @param armadura Armadura a equipar.
     * @return true si se ha equipado la armadura.
     */
    public boolean equipar(Armadura armadura) {
        boolean equipado = false;
        switch (armadura.tipo) {
            case YELMO:
                if (armaduraCabeza == null) {
                    armaduraCabeza = armadura;
                    equipado = true;
                }
                break;
            case ARMADURA:
                if (armaduraCuerpo == null) {
                    armaduraCuerpo = armadura;
                    equipado = true;
                }
                break;
            case ESCUDO:
                if (itemManoDch == null) {
                    itemManoDch = armadura;
                    equipado = true;
                } else if (itemManoIzq == null) {
                    itemManoIzq = armadura;
                    equipado = true;
                }
                break;
        }
        return equipado;
    }

    /**
     * Equipa un arma en la mano derecha o en ambas manos si es de dos manos.
     * 
     * @param arma Arma a equipar.
     * @return true si se ha equipado el arma.
     */
    public boolean equipar(Arma arma) {
        boolean equipado = false;
        if (arma.dosManos) {
            if (itemManoDch == null && itemManoIzq == null) {
                itemManoDch = arma;
                itemManoIzq = arma;
                equipado = true;
            }
        } else {
            if (itemManoDch == null) {
                itemManoDch = arma;
                equipado = true;
            } else if (itemManoIzq == null) {
                itemManoIzq = arma;
                equipado = true;
            }
        }
        return equipado;
    }

    /**
     * Muestra el equipo de combate del personaje.
     * Muestra la armadura equipada y las armas en las manos.
     */
    public void mostrarEquipo() {
        System.out.println("Equipo de combate de " + nombre + ":");
        System.out.println("- " + (armaduraCabeza != null ? armaduraCabeza : "Yelmo no equipado"));
        System.out.println("- " + (armaduraCuerpo != null ? armaduraCuerpo : "Sin armadura"));
        if (itemManoDch == itemManoIzq)
            System.out.println("- " + (itemManoDch != null ? itemManoDch : "Manos vacías"));
        else {
            System.out.println("- " + (itemManoDch != null ? itemManoDch : "Mano derecha vacía"));
            System.out.println("- " + (itemManoIzq != null ? itemManoIzq : "Mano izquierda vacía"));
        }
        System.out.println();

    }

}
