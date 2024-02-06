package ud5.herenciaapuntes;

public class Trompeta extends InstrumentoDeViento{

    public Trompeta(){
        super("METAL");
    }

    @Override
    void interpretar() {
        System.out.print("Melodía de Trompeta (Instrumento de " + tipo + "): ");
        for (Nota n : melodia){
            System.out.print(n + " ");
        }            
    }
    
}
