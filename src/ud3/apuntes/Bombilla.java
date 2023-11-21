package ud3.apuntes;

public class Bombilla {
    
    private boolean interruptor;
    static boolean interruptorGeneral;

    public static void encenderInterruptorGeneral(){
        interruptorGeneral = true;
    }

    public static void apagarInterruptorGeneral(){
        interruptorGeneral = false;
    }
    public void encender(){
        interruptor = true;
    }

    public void apagar(){
        interruptor = false;
    }

    public void estado(){
        if (interruptor && interruptorGeneral)
            System.out.println("Encendida");
        else
            System.out.println("Apagada");            
    }

    public static void main(String[] args) {
        Bombilla bCocina, bSalon, bDormitorio;

        // Crea las bombillas
        bCocina = new Bombilla();
        bSalon = new Bombilla();
        bDormitorio = new Bombilla();

        // Enciende el interruptor general
        Bombilla.encenderInterruptorGeneral();

        // Enciende y apaga bombillas
        bCocina.encender();
        bSalon.apagar();
        bDormitorio.encender();

        // Muestra el estado de las bombillas
        System.out.print("Cocina: ");
        bCocina.estado();
        System.out.print("Salón: ");
        bSalon.estado();
        System.out.print("Dormitorio: ");
        bDormitorio.estado();

        // Apaga el interruptor general
        Bombilla.apagarInterruptorGeneral();

        // Muestra el estado de las bombillas
        System.out.print("Cocina: ");
        bCocina.estado();
        System.out.print("Salón: ");
        bSalon.estado();
        System.out.print("Dormitorio: ");
        bDormitorio.estado();
    }
}
