package ud5.interfacesapuntes.ejemplos;

public class Gato extends Animal implements Sonido{

    @Override
    public void voz() {
        System.out.println("Miau, miau");
    }

    public void bufar() {
        System.out.println("FFFFFFFFFFFFFF");
    }
    
}
