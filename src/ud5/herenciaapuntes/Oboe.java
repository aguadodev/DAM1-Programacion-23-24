package ud5.herenciaapuntes;

public class Oboe extends InstrumentoDeViento{

    public Oboe(){
        super("MADERA");
    }

    @Override
    void interpretar() {
        System.out.print("Melodía de Oboe (Instrumento de " + tipo + "): ");
        for (Nota n : melodia){
            System.out.print(n + " ");
        }           
     }
    
}
