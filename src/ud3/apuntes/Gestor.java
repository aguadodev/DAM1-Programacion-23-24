package ud3.apuntes;

public class Gestor {

    public String nombre;
    final public String telefono;
    double importeMaximo;


    public Gestor(String nombre, String telefono) {
        this(nombre, telefono, 10000);
    }

    public Gestor(String nombre, String telefono, double importeMaximo) {
        this.nombre = nombre;
        this.telefono = telefono;
        setImporteMaximo(importeMaximo);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getImporteMaximo() {
        return importeMaximo;
    }

    public void setImporteMaximo(double importeMaximo) {
        this.importeMaximo = importeMaximo < 0 ? 0 : importeMaximo;
    }       

    
    public void mostrar(){
        System.out.println("GESTOR: " + nombre + ". Teléfono: " + telefono + ". Importe máximo: " + importeMaximo + " euros");
    }

}
