package model;
public class Orco extends Monstruo {

    public Orco() {
        ataque = rnd(30, 80);
        defensa = rnd(30, 50);
        velocidad = rnd(30, 60);
        puntosVida = rnd(30, 100);
    }

    public Orco(String nombre){
        this();
        this.nombre = nombre;
    }
    
}
