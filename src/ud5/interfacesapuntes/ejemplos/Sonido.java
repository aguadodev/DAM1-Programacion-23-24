package ud5.interfacesapuntes.ejemplos;

public interface Sonido {
    int version = 1;
    void voz(); 

    default void vozDurmiendo() {
        System.out.println("zzzzz");
    }

    static void bostezo(){
        System.out.println("!Auuuuuuh!");
    }

}
