package ud5.herenciaapuntes;

public class Persona {
    public String nombre;
    private byte edad;
    protected double estatura;

    public Persona(String nombre, byte edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad < 0 ? 0 : edad;
        this.estatura = estatura;
    }

    public Persona() {
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Estatura: " + estatura);
        System.out.println("Edad: " + edad);
    }


    


    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + "]";
    }

    public byte getEdad() {
        return edad;
    }

    

}
