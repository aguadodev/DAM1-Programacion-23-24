package ud5.rol;

public class Aranha extends Monstruo{

    public Aranha(String nombre) {
        this.nombre = nombre;
        ataque = random(10, 50);
        defensa = random(20, 40);
        velocidad = random(40, 70);
        puntosVida = random(30, 80);
    }

    public Aranha() {
        this(null);
    }
    
}
