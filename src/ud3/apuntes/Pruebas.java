package ud3.apuntes;

public class Pruebas {
    public static void main(String[] args) {

        /*Persona p1, p2, p3;

        p1 = new Persona("Pepa", (byte)25, 1.7);

        p2 = new Persona("Juan", (byte)30, 1.8);

        p3 = new Persona();

        p3.mostrar();

        p2.mostrar();

        //p1.nombre = "Pepa";
        //p1.edad = 25;
        //p1.estatura = 1.7;

        p1.saludar();

        p1.saludar("Manuel");

        p2.saludar(p1);

        p1.cumplirAnhos();

        p1.crecer(0.1);

        p1.mostrar();*/

        CuentaCorriente c1 = new CuentaCorriente("xxxxxxxx", -50);
        CuentaCorriente c2 = new CuentaCorriente("zzzzzzzz", 10000);

        c2.transferir(c1, 500);

        CuentaCorriente.transferir(c2, c1, 750);

        if (!c2.transferir(c1, 10000)) {
            System.out.println("No hay saldo suficiente");
        }

        c1.mostrar();
        c2.mostrar();


    }

}
