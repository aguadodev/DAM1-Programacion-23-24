package model;
public class Dragon extends Monstruo {

    public Dragon() {
        ataque = rnd(100, 200);
        defensa = rnd(60, 100);
        velocidad = rnd(80, 120);
        puntosVida = rnd(120, 250);
    }

    public Dragon(String nombre){
        this();
        this.nombre = nombre;
    }
    
}
