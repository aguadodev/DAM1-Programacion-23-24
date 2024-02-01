package ud5.herenciaapuntes;

public class Cliente extends Persona{
    int id;

    public Cliente(String nombre, byte edad, double estatura, int id) {
        super(nombre, edad, estatura);
        this.id = id;
    }


    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Código de cliente: " + id);
    }


    @Override
    public boolean equals(Object obj) {
        Cliente otroCliente = (Cliente) obj;
        return id == otroCliente.id;
    }

    

    
    
}
