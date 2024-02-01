package ud5.herenciaapuntes;

public class Estudiante extends Persona{
    int nota1av, nota2av, nota3av;

    public Estudiante(String nombre, int nota1av, int nota2av, int nota3av) {
        this.nombre = nombre;
        this.nota1av = nota1av;
        this.nota2av = nota2av;
        this.nota3av = nota3av;
    }

    double notaMedia(){
        return (nota1av + nota2av + nota3av) / 3.0;
    }

    


    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", nota media=" + notaMedia() + "]";
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Nombre Estudiante: " + nombre);
        System.out.println("Nota Media: " + notaMedia());
    }

    



}
