package model;
public class Troll extends Monstruo {
    public Troll() {
        ataque = rnd(60, 120);
        defensa = rnd(50, 70);
        velocidad = rnd(20, 40);
        puntosVida = rnd(100, 200);
    }

    public Troll(String nombre){
        this();
        this.nombre = nombre;
    }
    
    
}
