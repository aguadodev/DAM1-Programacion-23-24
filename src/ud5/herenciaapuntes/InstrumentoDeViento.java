package ud5.herenciaapuntes;

public abstract class InstrumentoDeViento extends Instrumento{
    Tipo tipo;
    enum Tipo {METAL, MADERA}

    public InstrumentoDeViento(String tipo) {
        this.tipo = Tipo.valueOf(tipo);
    }

    
    
}
