package ud5.interfacesapuntes.ejemplos;

public class App {


public static void main(String[] args) {
    Perro perro = new Perro();
    Gato gato = new Gato();
    Caracol caracol = new Caracol(); 
    Leon leon = new Leon();
    
    perro.voz();
    gato.voz();
    leon.voz();
    System.out.println(Sonido.version);

    perro.vozDurmiendo();
    gato.vozDurmiendo();
    leon.vozDurmiendo();

    Sonido.bostezo();

    
    
}       

}
