package ud3.otropaquete;

import ud3.apuntes.CuentaCorriente;
import ud3.apuntes.Persona;

public class Pruebas {
    public static void main(String[] args) {
        Persona p;

        p = new Persona("Pepe");

        p.cumplirAnhos();

        p.mostrar();

        /*CuentaCorriente c1 = new CuentaCorriente("xxxxxxxx", -50);
        
        c1.mostrar();

        c1.setSaldo(12312312);

        c1.mostrar();*/

        CuentaCorriente.setBanco("Banco DAM");

        System.out.println(CuentaCorriente.getBanco());

    }
}
