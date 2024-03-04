package ud5.rol;

public class Monstruo {
    String nombre;
    int ataque;
    int defensa;
    int velocidad;
    int puntosVida;

    public Monstruo(String nombre, int ataque, int defensa, int velocidad, int puntosVida) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.puntosVida = puntosVida;
    }

    public Monstruo(int ataque, int defensa, int velocidad, int puntosVida) {
        this(null, ataque, defensa, velocidad, puntosVida);
    }

    public Monstruo(String nombre) {
        this(nombre, random(1, 100), random(1, 100), random(1, 100), random(1, 100));
    }

    public Monstruo() {
    }

    /**
     * Resta puntos de vida al monstruo y devuelve true si ha muerto.
     * 
     * @param puntos Puntos de vida a restar.
     * @return true si el monstruo ha muerto.
     */
    public boolean perderVida(int puntos) {
        boolean muerto = false;
        puntosVida -= puntos;
        if (puntosVida <= 0) {
            muerto = true;
        }
        return muerto;
    }

    /**
     * Devuelve si el monstruo está vivo.
     * 
     * @return true si el monstruo está vivo.
     */
    public boolean estaVivo() {
        return puntosVida > 0;
    }

    /**
     * Ataca a un enemigo y devuelve el daño hecho.
     * 
     * @param enemigo Personaje enemigo al que atacar.
     * @return Daño hecho.
     */
    public int atacar(Personaje enemigo) {
        int ataque = this.ataque + random(1, 100);
        int defensa = enemigo.agilidad + random(1, 100);
        int danho = ataque - defensa;

        // No puede hacer daño negativo
        if (danho < 0)
            danho = 0;
        else {
            // No puede hacer más daño de los puntos de vida que le quedan al enemigo
            if (danho > enemigo.puntosVida) {
                danho = enemigo.puntosVida;
            }
            enemigo.sumarExperiencia(danho);
            enemigo.perderVida(danho);
        }

        return danho;
    }

    public void mostrar() {
        System.out.println("MONSTRUO: " + nombreMostrar());
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Puntos de Vida: " + puntosVida);
        System.out.println();
    }

    @Override
    public String toString() {
        return nombreMostrar() + " (" + puntosVida + ")";
    }



    private String nombreMostrar() {
        String clase = this.getClass().getSimpleName();
        return nombre != null ? nombre + "(" + clase + ")" : clase + " común";        
    }

    /**
     * Genera un monstruo aleatorio.
     * @return Monstruo aleatorio.
     */
    public static Monstruo generaMonstruoAleatorio() {
        switch (random(1, 10)) {
            case 1:
                return new Dragon();
            case 2, 3:
                return new Troll();
            case 4, 5, 6:
                return new Aranha();
            case 7, 8, 9, 10:
                return new Orco();
            default:
                return new Dragon();
        }
    }

    /*
     * MÉTODOS PRIVADOS
     */
    protected static int random(int i, int f) {
        return (int) (Math.random() * (f - i + 1) + i);
    }

    public static void main(String[] args) {
        Monstruo m = generaMonstruoAleatorio();
        Personaje p = new Personaje("Aragorn");

        p.mostrar();
        m.mostrar();

        System.out.println("El monstruo ataca al personaje con " + m.atacar(p) + " puntos de daño.");
        System.out.println("El personaje ataca al monstruo con " + p.atacar(m) + " puntos de daño.");
        System.out.println();

        p.mostrar();
        m.mostrar();
    }

}
