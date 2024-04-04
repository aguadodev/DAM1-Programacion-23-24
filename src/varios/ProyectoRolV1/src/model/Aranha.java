package model;
public class Aranha extends Monstruo {

    public Aranha() {
        ataque = rnd(10, 50);
        defensa = rnd(20, 40);
        velocidad = rnd(40, 70);
        puntosVida = rnd(30, 80);
    }

    public Aranha(String nombre){
        this();
        this.nombre = nombre;
    }
    
}
