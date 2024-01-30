package ud5.clasesapuntes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Texto {

    String cadena; 
    final int LONGITUD_MAXIMA;
    LocalDate fechaCreacion;
    LocalDateTime fechaModificacion;

    public Texto(int longitudMaxima) {
        LONGITUD_MAXIMA = longitudMaxima;
        cadena = "";
        fechaCreacion = LocalDate.now();
        fechaModificacion = LocalDateTime.now();
    }

    public boolean anhadirInicio(char ch){
        if (cadena.length() < LONGITUD_MAXIMA) {
            cadena = ch + cadena;
            fechaModificacion = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public boolean anhadirFinal(char ch){
        if (cadena.length() < LONGITUD_MAXIMA) {
            cadena = cadena + ch;
            fechaModificacion = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public boolean anhadirInicio(String str){
        if (cadena.length() + str.length() <= LONGITUD_MAXIMA) {
            cadena = str + cadena;
            fechaModificacion = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public boolean anhadirFinal(String str){
        if (cadena.length() + str.length() <= LONGITUD_MAXIMA) {
            cadena = cadena + str;
            fechaModificacion = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public int contarVocales(){
        String vocales = "aeiouáéíóúüAEIOUÁÉÍÓÚÜ";
        int contarVocales = 0;
        for (int i = 0; i < cadena.length(); i++)
            if (vocales.indexOf(cadena.charAt(i)) != -1)
                contarVocales++;
        return contarVocales;
    }

    public void mostrar(){
        System.out.println("TEXTO = " + cadena);
        System.out.println("longitud Máxima: " + LONGITUD_MAXIMA);
        System.out.println("Creado en " + fechaCreacion);
        System.out.println("Modificado en " + fechaModificacion);
        System.out.println("Número de vocales: " + contarVocales());
    }

    public static void main(String[] args) {
        Texto texto = new Texto(100);
        texto.anhadirFinal("Diseña la clase Texto que gestiona una cadena de caracteres con algunas características");
        texto.anhadirInicio("0706. ");
        texto.anhadirInicio('E');
        texto.anhadirFinal(':');
        texto.mostrar();

    }
    
}
