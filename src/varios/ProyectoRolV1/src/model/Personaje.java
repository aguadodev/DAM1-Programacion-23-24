package model;

import java.io.Serializable;
import java.util.Arrays;

public class Personaje implements Serializable{

    // Puntos de experiencia necesarios para subia nivel 2, 3, 4, 5, 6, ...
    public int[] PX_NIVEL = {100, 250, 450, 700, 1000, 1400, 1900, 2500};

    protected String nombre;

    public enum Raza {
        HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL
    }

    protected Raza raza;
    protected int fuerza;
    protected int agilidad;
    protected int constitucion;
    protected int nivel;
    protected int experiencia;
    protected int puntosVida;

    // Atributos Inventario
    protected int monedas;
    protected Item[] inventario = new Item[0];

    protected Item itemManoIzq;
    protected Item itemManoDch;
    protected Armadura armaduraCabeza;
    protected Armadura armaduraCuerpo;



    // Este constructor puede lanzar una excepción si los parámetros no són válidos
    public Personaje(String nombre, String raza, int fuerza, int agilidad, int constitucion,
            int nivel, int experiencia, int puntosVida) throws IllegalArgumentException {
        this.nombre = nombre;

        try {
            // Capturo la posible excepción de valueOf si el valor de raza no es válido
            this.raza = Raza.valueOf(raza);
        } catch (IllegalArgumentException e) {
            // Personalizo y lanzo una excepción de tipo IllegalArgumentException
            throw new IllegalArgumentException("Personaje no válido");
        }

        this.fuerza = fuerza >= 1 ? fuerza : 1;
        this.agilidad = agilidad >= 1 ? agilidad : 1;
        this.constitucion = constitucion >= 1 ? constitucion : 1;
        this.nivel = nivel >= 1 ? nivel : 1;
        this.experiencia = experiencia >= 0 ? experiencia : 0;
        this.puntosVida = puntosVida >= 1 ? puntosVida : 1;
    }

    public Personaje() {
    }

    public Personaje(String nombre, String raza, int fuerza, int agilidad, int constitucion) {
        this(nombre, raza, fuerza, agilidad, constitucion, 1, 0, constitucion + 50);
    }

    public Personaje(String nombre, String raza) {
        this(nombre, raza, rnd1a100(), rnd1a100(), rnd1a100());
    }



    static int rnd1a100() {
        return (int) (Math.random() * 100 + 1);
    }



    public void mostrar() {
        System.out.println("PERSONAJE: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Agilidad: " + agilidad);
        System.out.println("Constitución: " + constitucion);
        System.out.println("Nivel: " + nivel);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("Puntos de Vida: " + puntosVida);
    }

    public String fichaPersonaje() {
        String str = "FICHA DE PERSONAJE: \n\n";
        str += "Nombre: " + nombre + "\n";
        str += "Raza: " + raza + "\n";
        str += "Fuerza: " + fuerza + "\n";
        str += "Agilidad: " + agilidad + "\n";
        str += "Constitución: " + constitucion + "\n";
        str += "Nivel: " + nivel + "\n";
        str += "Experiencia: " + experiencia + "\n";
        str += "Puntos de Vida: " + puntosVida + " / " + (constitucion + 50) + "\n";
        return str;
    }

    @Override
    public String toString() {
        return nombre + " (" + puntosVida + "/" + (constitucion + 50) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Personaje otro = (Personaje) obj;
        return nombre.equals(otro.nombre)
                && raza.equals(otro.raza)
                && fuerza == otro.fuerza
                && agilidad == otro.agilidad
                && constitucion == otro.constitucion;
    }




    public boolean sumarExperiencia(int puntos) {
        int nivelAnterior = experiencia / 1000;

        experiencia += puntos;

        int nivelActual = experiencia / 1000;

        return nivelAnterior != nivelActual;
    }

    public void subirNivel() {
        nivel++;
        fuerza = (int) Math.round(fuerza * 1.05);
        agilidad = (int) Math.round(agilidad * 1.05);
        constitucion = (int) Math.round(constitucion * 1.05);
        puntosVida += (int) Math.round(constitucion * .05);
    }


    public int getNivelSegunPX(){
        // Recorre la tabla de puntos de experiencia por nivel para obtener el nivel
        // que corresponde al personaje según los puntos actuales.
        int i = 0;
        while (i < PX_NIVEL.length && experiencia > PX_NIVEL[i]){
            i++;
        }
        i++;
        return i;
    }


    public void curar() {
        if (puntosVida < constitucion + 50)
            puntosVida = constitucion + 50;
    }

    public boolean perderVida(int puntos) {
        boolean muerto = false;
        puntosVida -= puntos;
        if (puntosVida <= 0) {
            muerto = true;
            puntosVida = 0;
        }
        return muerto;
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public int atacar(Personaje enemigo) {
        int ataque = fuerza + rnd1a100();
        int defensa = enemigo.agilidad + rnd1a100();
        int resultado = ataque - defensa;

        if (resultado > enemigo.puntosVida) {
            resultado = enemigo.puntosVida;
        } else if (resultado < 0)
            resultado = 0;

        sumarExperiencia(resultado);
        enemigo.sumarExperiencia(resultado);
        enemigo.perderVida(resultado);

        return resultado;
    }

    public int atacar(Monstruo enemigo) {
        int ataque = fuerza + rnd1a100();
        int defensa = enemigo.defensa + rnd1a100();
        int resultado = ataque - defensa;

        if (resultado > enemigo.puntosVida) {
            resultado = enemigo.puntosVida;
        } else if (resultado < 0)
            resultado = 0;

        sumarExperiencia(resultado);
        enemigo.perderVida(resultado);

        return resultado;
    }

    public static Personaje[] sortPuntosVidaDesc(Personaje[] personajes) {
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

    public static Personaje[] sortPuntosVidaAsc(Personaje[] personajes) {
        Personaje[] A = Arrays.copyOf(personajes, personajes.length);

        int i, j;
        Personaje aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1].puntosVida < A[j].puntosVida) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
        return A;
    }



    /* INVENTARIO */
    public double getCargaActual() {
        double peso = 0;
        for (Item i: inventario)
            peso += i.peso;
        return peso;
    }

    public int getCargaMaxima() {
        return 50 + constitucion * 2;
    }

    public boolean addToInventario(Item item) {
        boolean anhadido = false;
        if (getCargaActual() + item.peso <= getCargaMaxima()){
            inventario = Arrays.copyOf(inventario,inventario.length + 1);
            inventario[inventario.length - 1] = item;
            anhadido = true;
        }            
        return anhadido;
    }

    public void mostrarInventario() {
        System.out.println("Inventario de " + nombre + ":");
        for(int i = 1; i <= inventario.length; i++)
            System.out.print(i + ". " + inventario[i - 1]);
    }

    public void deleteFromInventario(Item item) {
        this.inventario = inventario;
    }    

    public boolean equipar(Armadura armadura) {
        boolean equipado = false;
        switch (armadura.tipo){
            case YELMO: if (armaduraCabeza == null) {
                            armaduraCabeza = armadura;
                            equipado = true;
                        }
                        break;
            case ARMADURA: if (armaduraCuerpo == null) {
                armaduraCuerpo = armadura;
                equipado = true;
            }
            break;
            case ESCUDO: 
            if (itemManoDch == null) {
                itemManoDch = armadura;
                equipado = true;
            } else if (itemManoIzq == null) {
                itemManoIzq = armadura;
                equipado = true;
            }
            break;
        }
        return equipado;
    }

    public boolean equipar(Arma arma) {
        boolean equipado = false;
        if (arma.dosManos) {
            if (itemManoDch == null && itemManoIzq == null){
                itemManoDch = arma;
                itemManoIzq = arma;
                equipado = true;
            }
        } else {
            if (itemManoDch == null) {
                itemManoDch = arma;
                equipado = true;
            } else if (itemManoIzq == null) {
                itemManoIzq = arma;
                equipado = true;
            }
        }
        return equipado;                
    }
    
    
    public void mostrarEquipo() {
        System.out.println("Equipo de combate de " + nombre + ":");
        System.out.println("- " + (armaduraCabeza != null ? armaduraCabeza:"Yelmo no equipado"));
        System.out.println("- " + (armaduraCuerpo != null ? armaduraCuerpo:"Sin armadura"));
        if (itemManoDch == itemManoIzq)
            System.out.println("- " + (itemManoDch != null ? itemManoDch:"Manos vacías"));
        else {
            System.out.println("- " + (itemManoDch != null ? itemManoDch:"Mano derecha vacía"));
            System.out.println("- " + (itemManoIzq != null ? itemManoIzq:"Mano izquierda vacía"));
        }
        System.out.println();
    }    













    /* GETTERS & SETTERS */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public Item[] getInventario() {
        return inventario;
    }

    public void setInventario(Item[] inventario) {
        this.inventario = inventario;
    }

    public Item getItemManoIzq() {
        return itemManoIzq;
    }

    public void setItemManoIzq(Item itemManoIzq) {
        this.itemManoIzq = itemManoIzq;
    }

    public Item getItemManoDch() {
        return itemManoDch;
    }

    public void setItemManoDch(Item itemManoDch) {
        this.itemManoDch = itemManoDch;
    }

    public Armadura getArmaduraCabeza() {
        return armaduraCabeza;
    }

    public void setArmaduraCabeza(Armadura armaduraCabeza) {
        this.armaduraCabeza = armaduraCabeza;
    }

    public Armadura getArmaduraCuerpo() {
        return armaduraCuerpo;
    }

    public void setArmaduraCuerpo(Armadura armaduraCuerpo) {
        this.armaduraCuerpo = armaduraCuerpo;
    }



}
