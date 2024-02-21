package ud5.rol;

import java.util.Arrays;

public class Personaje implements Comparable {

    final static byte PUNTOS_VIDA_BASE = 50;

    String nombre;

    enum Raza {
        HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL
    }

    Raza raza;
    short fuerza;
    short agilidad;
    short constitucion;
    byte nivel;
    int experiencia;
    short puntosVida;

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
        this(nombre, raza, random(1,100), random(1,100), random(1,100));
    }

    public Personaje(String nombre) {
        this(nombre, Raza.HUMANO);
    }

    public Personaje(){
        this("Desconocido");
    }


    private static int random(int i, int f) {
        return (int) (Math.random() * (f - i + 1) + i);
    }

    public void mostrar() {
         System.out.println("Personaje [nombre=" + nombre + ", raza=" + raza + ", fuerza=" + fuerza + ", agilidad=" + agilidad
                + ", constitucion=" + constitucion + ", nivel=" + nivel + ", experiencia=" + experiencia
                + ", puntosVida=" + puntosVida + "]");
    }

    @Override
    public String toString() {
        return nombre + " (" + puntosVida + "/" +  (constitucion + PUNTOS_VIDA_BASE) + ")";
    }


    /**
     * Suma al personaje la experiencia indicada y sube de nivel si es necesario.
     * @param puntos
     * @return número de niveles subidos.
     */
    byte sumarExperiencia(int puntos){
        int uExpAntes = experiencia / 1000;
        experiencia += puntos;
        int uExpDespues = experiencia / 1000;

        byte nivelesQueSube = (byte) (uExpDespues - uExpAntes);

        nivel += nivelesQueSube;
            
        return nivelesQueSube;
    }



    @Override
    public int compareTo(Object o) {
        Personaje otro = (Personaje) o;

        return nombre.compareTo(otro.nombre);
    }

















    public static void main(String[] args) {

        System.out.println("Puntos de vida base de los personajes: " + Personaje.PUNTOS_VIDA_BASE);

        Personaje p01 = new Personaje("Aragorn", Raza.HUMANO, 90, 90, 90, 10, 16252, 125);
        p01.sumarExperiencia(2500);

        Personaje p02 = new Personaje("Mara", Raza.ELFO, 100, 100, 100);

        Personaje p03 = new Personaje("Dodol Bazbal", Raza.ENANO);

        Personaje p04 = new Personaje("Lady Jet");

        Personaje p05 = new Personaje();
        Personaje p06 = new Personaje();

        System.out.println(p01.compareTo(p02));
        System.out.println(p02.compareTo(p01));
        System.out.println(p05.compareTo(p06));




        Personaje[] banda = {p01, p02, p03, p04, p05, p06};

        for (Personaje p : banda){
            System.out.println(p);
        }
        System.out.println();

        ComparadorPV comparador = new ComparadorPV();
        Arrays.sort(banda, comparador);

        for (Personaje p : banda){
            System.out.println(p);
        }        
    }


}
