package ud6.coleccionesapuntes;

import ud3.apuntes.Persona;

public class Contenedor<T> {
    private T objeto;

    public Contenedor() {
    }

    public T extraer() {
        T res = objeto;
        objeto = null;
        return res;
    }

    public void guardar(T objeto) {
        this.objeto = objeto;
    }






    public static void main(String[] args) {
        Contenedor<Integer> cInt = new Contenedor<>();
        cInt.guardar(5);

        Contenedor<Double> cDou = new Contenedor<>();
        cDou.guardar(5.5);

        Contenedor<Persona> cPer = new Contenedor<>();
        cPer.guardar(new Persona("Oscar"));

        Contenedor c = new Contenedor<>();
        c.guardar(7);
        c.guardar("Piedra");

        Double d = (Double) c.extraer();

        Double dd = (Double) cInt.extraer();


    }
    
}
