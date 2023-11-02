
package ud1.holamundo;

public class HolaMundo {

    public static void main(String[] args) {
        System.out.println("Hola Mundo!!");

        double importe = 80.27;
        byte numPersonas = 5;
        double importePersona; //

        importePersona = importe / numPersonas;

        System.out.print("El importe de la cena fue de ");
        System.out.println(importe + "€");

        System.out.println("Número de personas: " + numPersonas);

        System.out.println("Cada persona debe pagar " 
                            + importePersona + "€");

        System.out.println("Programa realizado por Oscar");
    }
    
}
