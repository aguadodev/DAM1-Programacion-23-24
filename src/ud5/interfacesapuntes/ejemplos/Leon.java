package ud5.interfacesapuntes.ejemplos;

public class Leon extends Animal implements Sonido{

    @Override
    public void voz() {
        System.out.println("¡GRRRR!");
    }

    @Override
    public void vozDurmiendo() {
        voz();
    }

    
    
}
