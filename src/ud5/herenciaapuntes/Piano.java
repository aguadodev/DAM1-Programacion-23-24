package ud5.herenciaapuntes;

public class Piano extends Instrumento {

    @Override
    void interpretar() {
        System.out.print("Melodía de Piano: ");
        for (Nota n : melodia){
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Piano piano = new Piano();

        piano.add(Nota.DO);
        piano.add(Nota.MI);
        piano.add(Nota.FA);

        Guitarra guitarra = new Guitarra();
        guitarra.add(Nota.SOL);
        guitarra.add(Nota.DO);
        guitarra.add(Nota.RE);
        
        Trompeta trompeta = new Trompeta();
        trompeta.add(Nota.SOL);
        trompeta.add(Nota.DO);
        trompeta.add(Nota.RE);

        Oboe oboe = new Oboe();
        oboe.add(Nota.SOL);
        oboe.add(Nota.DO);
        oboe.add(Nota.RE);

        Instrumento[] orquesta = {
            piano,
            guitarra,
            trompeta,
            oboe
        };

        System.out.println("CONCIERTO EN REm:");
        for(Instrumento instrumento : orquesta){
            instrumento.interpretar();
            System.out.println();
        }

    }
    
}
