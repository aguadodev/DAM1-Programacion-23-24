package ud5.rol;

import java.util.Arrays;
import java.util.Comparator;

public class Personaje implements Comparable {

    final static byte PUNTOS_VIDA_BASE = 50; // 50 puntos de vida base
    final static byte PORCENTAJE_SUBIDA_NIVEL = 5; // 5%
    final static int EXPERIENCIA_SUBIDA_NIVEL = 1000; // 1000 puntos de experiencia

    enum Raza {
        HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL
    }

    /*
     * ATRIBUTOS
     */
    String nombre;
    Raza raza;
    short fuerza;
    short agilidad;
    short constitucion;
    byte nivel;
    int experiencia;
    short puntosVida;

    /*
     * CONSTRUCTORES
     */

    public Personaje(String nombre, Raza raza, int fuerza, int agilidad, int constitucion, int nivel,
            int experiencia, int puntosVida) {

        if (fuerza <= 0 || agilidad <= 0 || constitucion <= 0 || nivel <= 0 || experiencia < 0 || puntosVida <= 0)
            throw new IllegalArgumentException(
                    "Las características físicas del personaje, el nivel y puntos de vida no pueden ser menores que 1, y la experiencia no puede ser menor que 0.");

        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = (short) fuerza;
        this.agilidad = (short) agilidad;
        this.constitucion = (short) constitucion;
        this.nivel = (byte) nivel;
        this.experiencia = experiencia;
        this.puntosVida = (short) puntosVida;
    }

    public Personaje(String nombre, Raza raza, int fuerza, int agilidad, int constitucion) {
        this(nombre, raza, fuerza, agilidad, constitucion, 1, 0, constitucion + PUNTOS_VIDA_BASE);
    }

    public Personaje(String nombre, Raza raza) {
        this(nombre, raza, random(1, 100), random(1, 100), random(1, 100));
    }

    public Personaje(String nombre) {
        this(nombre, Raza.HUMANO);
    }

    public Personaje() {
        this("Desconocido");
    }

    /*
     * MÉTODOS PÚBLICOS: mostrar, toString
     */

    public void mostrar() {
        System.out.println("PERSONAJE: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Agilidad: " + agilidad);
        System.out.println("Constitución: " + constitucion);
        System.out.println("Nivel: " + nivel);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("Puntos de Vida: " + puntosVida);
        System.out.println();
    }

    @Override
    public String toString() {
        return nombre + " (" + puntosVida + "/" + (constitucion + PUNTOS_VIDA_BASE) + ")";
    }

    /*
     * MÉTODOS PÚBLICOS (COMBATE): sumarExperiencia, subirNivel, perderVida,
     * estaVivo, atacar
     */

    /**
     * Sube de nivel al personaje y aumenta sus características físicas.
     */
    public void subirNivel() {
        nivel++;
        fuerza *= 1 + (PORCENTAJE_SUBIDA_NIVEL / 100);
        agilidad *= 1 + (PORCENTAJE_SUBIDA_NIVEL / 100);
        constitucion *= 1 + (PORCENTAJE_SUBIDA_NIVEL / 100);
    }

    /**
     * Suma al personaje la experiencia indicada y sube de nivel si es necesario.
     * 
     * @param puntos Puntos de expericnia a sumar.
     * @return Número de niveles subidos.
     */
    public byte sumarExperiencia(int puntos) {
        int nivelAnterior = 1 + experiencia / EXPERIENCIA_SUBIDA_NIVEL;

        experiencia += puntos;

        int nivelActual = 1 + experiencia / EXPERIENCIA_SUBIDA_NIVEL;

        byte nivelesSubidos = (byte) (nivelActual - nivelAnterior);

        // Subir de nivel si es necesario
        for (int i = 0; i < nivelesSubidos; i++) {
            subirNivel();
        }

        return nivelesSubidos;
    }

    /**
     * Resta puntos de vida al personaje y devuelve si ha muerto.
     * 
     * @param puntos Puntos de vida a restar.
     * @return true si el personaje ha muerto.
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
     * Devuelve si el personaje está vivo.
     * 
     * @return true si el personaje está vivo.
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
        int ataque = fuerza + random(1, 100);
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
            sumarExperiencia(danho);
            enemigo.sumarExperiencia(danho);
            enemigo.perderVida(danho);
        }

        return danho;
    }


    /**
     * Ataca a un mostruo enemigo y devuelve el daño hecho.
     * 
     * @param enemigo Monstruo enemigo al que atacar.
     * @return Daño hecho.
     */
    public int atacar(Monstruo enemigo) {
        int ataque = fuerza + random(1, 100);
        int defensa = enemigo.defensa + random(1, 100);
        int danho = ataque - defensa;

        // No puede hacer daño negativo
        if (danho < 0)
            danho = 0;
        else {
            // No puede hacer más daño de los puntos de vida que le quedan al enemigo
            if (danho > enemigo.puntosVida) {
                danho = enemigo.puntosVida;
            }
            sumarExperiencia(danho);
            enemigo.perderVida(danho);
        }

        return danho;
    }    






    // MÉTODOS DE CLASE
    /**
     * Ordena un array de personajes por puntos de vida de forma descendente usando el algoritmo de la burbuja.
     * @param personajes Array de personajes a ordenar.
     * @return Array de personajes ordenado.
     */
    static Personaje[] sortPuntosVidaDesc(Personaje[] personajes){
        Personaje[] A = Arrays.copyOf(personajes, personajes.length);

        int i, j;
        Personaje aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {                                                              
                if (A[j + 1].puntosVida > A[j].puntosVida) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }        
        return A;
    }    

    /*
     * MÉTODO DE LA INTERFAZ COMPARABLE
     */
    @Override
    public int compareTo(Object o) {
        Personaje otro = (Personaje) o;

        return nombre.compareTo(otro.nombre);
    }

    /*
     * MÉTODOS PRIVADOS
     */
    private static int random(int i, int f) {
        return (int) (Math.random() * (f - i + 1) + i);
    }

    /*
     * MAIN: para probar la clase
     */

    public static void main(String[] args) {

        System.out.println("Puntos de vida base de los personajes: " + Personaje.PUNTOS_VIDA_BASE);

        Personaje p01 = new Personaje("Aragorn", Raza.HUMANO, 90, 90, 90, 10, 16252, 125);
        p01.sumarExperiencia(2500);

        Personaje p02 = new Personaje("Mara", Raza.ELFO, 100, 100, 100);

        Personaje p03 = new Personaje("Dodol Bazbal", Raza.ENANO);

        Personaje p04 = new Personaje("Lady Jet");

        Personaje p05 = new Personaje();
        Personaje p06 = new Personaje();

        Personaje p07 = new Personaje("Mara2", Raza.ELFO, 100, 100, 80);

        System.out.println(p01.compareTo(p02));
        System.out.println(p02.compareTo(p01));
        System.out.println(p05.compareTo(p06));

        Personaje[] banda = { p01, p02, p03, p04, p05, p06, p07 };

        for (Personaje p : banda) {
            System.out.println(p);
        }
        System.out.println();

        ComparadorPVDesc comparadorPV = new ComparadorPVDesc();
        // ComparadorNivelPX comparador = new ComparadorNivelPX();
        Arrays.sort(banda, comparadorPV);

        Comparator comparadorFuerza = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Personaje) o1).fuerza - ((Personaje) o2).fuerza;
            }

        };

        Arrays.sort(banda, comparadorFuerza.reversed().thenComparing(comparadorPV.reversed()));

        for (Personaje p : banda) {
            p.mostrar();
            // System.out.println(p);
        }

        System.out.println(Arrays.binarySearch(banda, new Personaje(null, null, 77, 1, 1), comparadorFuerza));

    }

}
