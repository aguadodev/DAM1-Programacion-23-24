package ud5.interfacesejercicios.ep0935;

public class Persona implements Cliente, Empleado {
    final String dni;
    String nombre;
    boolean esCliente;
    boolean esEmpleado;
    private int horasTrabajadas;
    private double saldo;

    public Persona(String dni, String nombre, boolean esCliente, boolean esEmpleado) {
        this.dni = dni;
        this.nombre = nombre;
        this.esCliente = esCliente;
        this.esEmpleado = esEmpleado;
    }

    
    public Persona(String dni, String nombre) {
        this(dni, nombre, false, false);
    }



    @Override
    public int getHorasTrabajadas() {
        if (esEmpleado){
            return horasTrabajadas;
        } else {
            throw new IllegalArgumentException("Esta Persona no es Empleado");
        }
    }

    @Override
    public void setHorasTrabajadas(int horas) {
        if (esEmpleado)
            horasTrabajadas = horas;
    }

    @Override
    public void incrementarHorasTrabajadas(int horas) {
        if (esEmpleado)
            horasTrabajadas += horas;        
    }

    @Override
    public double getSaldo() {
        if (esCliente){
            return saldo;
        } else {
            throw new IllegalArgumentException("Esta Persona no es Cliente");
        }        
    }

    @Override
    public void setSaldo(double saldo) {
        if (esCliente)
            this.saldo = saldo;        
    }

    @Override
    public void incrementarSaldo(int cantidad) {
        if (esCliente)
            this.saldo += cantidad;  
    }
    
    @Override
    public String toString() {
        String str = "Persona: dni=" + dni + ", nombre=" + nombre;
        if (esCliente)
            str += "\nSaldo de cliente = " + saldo;
        if (esEmpleado)
            str += "\nHoras Trabajadas de Empleado = " + horasTrabajadas;
        return str;
    }

    public static void main(String[] args) {
        Persona p = new Persona("3434343434X", "Pepe", true, true);
        p.incrementarHorasTrabajadas(20);
        p.incrementarSaldo(1000);

        System.out.println(p);  

        Empleado p2 = new Persona("3434343434X", "Alba");

        System.out.println(p2.getHorasTrabajadas());



    } 

}
