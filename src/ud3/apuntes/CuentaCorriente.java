package ud3.apuntes;

public class CuentaCorriente {

    /* ATRIBUTOS */
    private String dni;
    private String nombre;
    private double saldo;
    private static String banco;
    private Gestor gestor;

    /* CONSTRUCTORES */

    public CuentaCorriente(String dni, String nombre) {
        this(dni, nombre, 0);
    }

    public CuentaCorriente(String dni, double saldo) {
        this(dni, "", saldo);
    }

    public CuentaCorriente(String dni, String nombre, double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.saldo = saldo < 0 ? 0 : saldo;
    }

    /* GETTERS Y SETTERS */

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            this.saldo = 0;
        } else if (saldo > 10000) {
            this.saldo = 10000;
        } else {
            this.saldo = saldo;
        }
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public static String getBanco() {
        return banco;
    }

    public static void setBanco(String banco) {
        CuentaCorriente.banco = banco;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    /* MÉTODOS DE INSTANCIA */

    public boolean sacarDinero(double importe) {
        boolean sacarDinero = false;

        if (importe <= saldo) {
            saldo -= importe;
            sacarDinero = true;
        }

        return sacarDinero;
    }

    public void ingresarDinero(double importe) {
        saldo += importe;
    }

    public void mostrar() {
        System.out.println("\nCuenta Corriente:");
        System.out.println("- Titular: " + nombre + ", DNI: " + dni);
        System.out.println("- Saldo: " + saldo);
        if (gestor != null) {
            gestor.mostrar();
        }

    }

    // transferir() Método de instancia
    // Ejemplo de llamada: c1.transferir(c2, 1000)
    public boolean transferir(CuentaCorriente cuentaDestino, double importe) {
        boolean transferir = false;
        if (saldo >= importe) {
            saldo -= importe;
            cuentaDestino.saldo += importe;
            transferir = true;
        }
        return transferir;
    }

    // transferir() Método estático
    // Ejemplo de llamada: CuentaCorriente.transferir(c1, c2, 1000);
    public static boolean transferir(CuentaCorriente cuentaOrigen, CuentaCorriente cuentaDestino, double importe) {
        boolean transferir = false;
        if (cuentaOrigen.saldo >= importe) {
            cuentaOrigen.saldo -= importe;
            cuentaDestino.saldo += importe;
            transferir = true;
        }
        return transferir;
    }

    public static void main(String[] args) {
        CuentaCorriente c1 = new CuentaCorriente("Paco", "33333333Z");
        Gestor g1 = new Gestor("Gestoría Uno", "666666666");

        c1.gestor = g1;

        c1.mostrar();

        CuentaCorriente c2 = new CuentaCorriente("44444444Y", -56);
        c2.mostrar();

        System.out.println("Puedo sacar 10 euros? " + c1.sacarDinero(10));

        c1.ingresarDinero(100);
        c1.mostrar();

        System.out.println("Puedo sacar 10 euros? " + c1.sacarDinero(10));
        c1.mostrar();
    }

}