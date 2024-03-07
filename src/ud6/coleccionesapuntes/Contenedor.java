package ud6.coleccionesapuntes;

import java.util.Arrays;

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
        /*Contenedor<Integer> cInt = new Contenedor<>();
        cInt.guardar(5);

        Contenedor<Double> cDou = new Contenedor<>();
        cDou.guardar(5.5);

        Contenedor<Persona> cPer = new Contenedor<>();
        cPer.guardar(new Persona("Oscar"));

        Contenedor c = new Contenedor<>();
        c.guardar(7);
        c.guardar("Piedra");

        Double d = (Double) c.extraer();

        Double dd = (Double) cInt.extraer();*/


        Integer[] tInt = {5, null, 3, null, 5, 7, null};
        Integer[] tInt2 = {null, 38, null, 50, 47, null};

        System.out.println(Arrays.toString(Util.concatenar(tInt, tInt2)));


        String[] tStr = {"Hola", null, "Adiós", null, "A", "Fin", null, null};
        String[] tStr2 = {"Programación", null, "Marcas", "BD", null, null};
        System.out.println(Arrays.toString(Util.concatenar(tStr, tStr2)));

/*
        System.out.println(Util.numeroNulos(tInt));
        System.out.println(Util.numeroNulos(tStr));

        tInt = Util.add(7, tInt);
        tInt = Util.add(null, tInt);
        tStr = Util.add("7", tStr);
        tStr = Util.add(null, tStr);

        System.out.println(Arrays.toString(tInt));
        System.out.println(Arrays.toString(tStr));*/

    }
    
}
