package model;

/**
 * Item
 */
public class Item {

    String nombre;
    double peso;
    int precio;
    
    public Item() {
    }

    public Item(String nombre, double peso, int precio) {
        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
    }

    public Item(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }



    
    @Override
    public boolean equals(Object obj) {
        Item i = (Item) obj;
        return nombre == i.nombre && peso == i.peso && precio == i.precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return nombre + ", peso: " + peso + " kilos, precio: " + precio + " monedas\n";
    }

    

}