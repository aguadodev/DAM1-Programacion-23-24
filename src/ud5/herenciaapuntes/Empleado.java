package ud5.herenciaapuntes;

public class Empleado extends Persona {
    double salario;
    String estatura;

    public Empleado(String nombre, byte edad, double estatura, double salario) {
        super(nombre, edad, estatura);
        this.salario = salario;
    }

    public Empleado() {
    }

    void subirSalario(double porcentaje) {
        salario *= (1 + porcentaje);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Salario: " + salario);
        /*
         * System.out.println("Nombre: " + nombre);
         * System.out.println("Estatura: " + super.estatura);
         * System.out.println("Salario: " + salario);
         * System.out.println("Edad: " + getEdad());
         */
    }

}
