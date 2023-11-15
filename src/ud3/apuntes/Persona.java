package ud3.apuntes;

import java.time.LocalDate;

public class Persona {

    // Atributos
    private String nombre;
    private byte edad;
    private double estatura; // metros
    private String dni;


    /* CONSTRUCTORES */
    public Persona(String nombre, byte edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad < 0? 0 : edad;
        this.estatura = estatura;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona() {
        this("Fulano", (byte) 18, 1.7);
        if (LocalDate.now().getMonthValue() == 11)
            edad = 20;            
    }


    /* GETTERS Y SETTERS */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }    


    // Métodos de instancia
    public void saludar() {
        System.out.println("Hola, me llamo " + nombre);
    }

    public void saludar(String nombre) {
        System.out.println("Hola " + nombre + ", me llamo " + this.nombre);
    }

    public void saludar(Persona p) {
        System.out.println("Hola " + p.nombre + ", me llamo " + nombre);

    }

    public void cumplirAnhos() {
        edad++;
    }

    public void crecer(double metros) {
        estatura += metros;
    }

    public void mostrar() {
        System.out.println(nombre + " tiene " + edad
                + " años y mide "
                + estatura + " metros.");
    }

}
