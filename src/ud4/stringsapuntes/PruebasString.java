package ud4.stringsapuntes;

import ud3.apuntes.Persona;

public class PruebasString {
    public static void main(String[] args) {
        Persona p = new Persona("Óscar", "234234234");
        String cad = String.valueOf(p);
        String cad2 = "Óscar";
        String cad3 = "óscar";
        System.out.println(cad);
        System.out.println(cad2);
        System.out.println(cad == cad2);
        System.out.println(cad2 == cad3);
        System.out.println(cad2.equalsIgnoreCase(cad3));
        System.out.println(cad2.compareToIgnoreCase(cad3));
        System.out.println(cad.concat(cad3));
        System.out.println(cad);
    }
}
