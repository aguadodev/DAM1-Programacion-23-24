package model;

public class Arma extends Item {
    
    int ataque;
    boolean dosManos;


    public Arma(String nombre, double peso, int ataque) {
        super(nombre, peso);
        this.ataque = ataque;
    }


    public Arma(String nombre, double peso, int precio, int ataque, boolean dosManos) {
        super(nombre, peso, precio);
        this.ataque = ataque;
        this.dosManos = dosManos;
    }


    @Override
    public String toString() {
        return nombre + " (+" + ataque + " ataque)";
    }

}
