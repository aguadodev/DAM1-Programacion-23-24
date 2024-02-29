package ud5.rol.extra2;

import java.util.Arrays;

import ud5.rol.Personaje;


public class PersonajeEx extends Personaje {

    int monedas;
    Item[] inventario;

    Item itemManoIzq;
    Item itemManoDch;
    Armadura armaduraCabeza;
    Armadura armaduraCuerpo;
    

    public PersonajeEx(String nombre, String raza) {
        super(nombre, raza);
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

    public boolean addToInventario(Item item) {
        boolean anhadido = false;
        if (getCargaActual() + item.peso <= getCargaMaxima()){
            inventario = Arrays.copyOf(inventario,inventario.length + 1);
            inventario[inventario.length - 1] = item;
            anhadido = true;
        }            
        return anhadido;
    }

    public void mostrarInventario() {
        System.out.println("Inventario de " + nombre + ":");
        for(int i = 1; i <= inventario.length; i++)
            System.out.print(i + ". " + inventario[i - 1]);
    }

    public void deleteFromInventario(Item item) {
        this.inventario = inventario;
    }    

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

    public double getCargaActual() {
        double peso = 0;
        for (Item i: inventario)
            peso += i.peso;
        return peso;
    }

    public int getCargaMaxima() {
        return 50 + constitucion * 2;
    }

    public boolean equipar(Armadura armadura) {
        boolean equipado = false;
        switch (armadura.tipo){
            case YELMO: if (armaduraCabeza == null) {
                            armaduraCabeza = armadura;
                            equipado = true;
                        }
                        break;
            case ARMADURA: if (armaduraCuerpo == null) {
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

    public boolean equipar(Arma arma) {
        boolean equipado = false;
        if (arma.dosManos) {
            if (itemManoDch == null && itemManoIzq == null){
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

    public void mostrarEquipo() {
        System.out.println("Equipo de combate de " + nombre + ":");
        System.out.println("- " + (armaduraCabeza != null ? armaduraCabeza:"Yelmo no equipado"));
        System.out.println("- " + (armaduraCuerpo != null ? armaduraCuerpo:"Sin armadura"));
        if (itemManoDch == itemManoIzq)
            System.out.println("- " + (itemManoDch != null ? itemManoDch:"Manos vacías"));
        else {
            System.out.println("- " + (itemManoDch != null ? itemManoDch:"Mano derecha vacía"));
            System.out.println("- " + (itemManoIzq != null ? itemManoIzq:"Mano izquierda vacía"));
        }
        System.out.println();


    }



}
