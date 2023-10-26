package ud02.buclesejercicios;

public class NumerosEnTexto {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int numero;
        int unidades, decenas;        
        String textoUnidades = " ";
        String textoDecenas = " ";
        String textoNumero = " ";
    
        for(numero = 1; numero <= 99; numero++) {           
            // Proceso
            unidades = numero % 10;
            decenas = numero / 10;
    
            // Pasamos a texto las unidades
            switch (unidades) {
                case 1: textoUnidades = "uno"; break;
                case 2: textoUnidades = "dos"; break;
                case 3: textoUnidades = "tres"; break;
                case 4: textoUnidades = "cuatro"; break;
                case 5: textoUnidades = "cinco"; break;
                case 6: textoUnidades = "seis"; break;
                case 7: textoUnidades = "siete"; break;
                case 8: textoUnidades = "ocho"; break;
                case 9: textoUnidades = "nueve"; break;
            }       
    
            // Pasamos a texto las decenas
            switch (decenas) {
                case 1: textoDecenas = "diez"; break;
                case 2: textoDecenas = "veinte"; break;
                case 3: textoDecenas = "treinta"; break;
                case 4: textoDecenas = "cuarenta"; break;
                case 5: textoDecenas = "cincuenta"; break;
                case 6: textoDecenas = "sesenta"; break;
                case 7: textoDecenas = "setenta"; break;
                case 8: textoDecenas = "ochenta"; break;
                case 9: textoDecenas = "noventa"; break;
            }         
    
            // Evaluamos las decenas para generalizar los casos posibles
            if (decenas == 0) {
                // Si el número es menor que 10 el resultado son sólo las unidades
                textoNumero = textoUnidades;
            } else if (decenas == 1) {
                // Casos especiales del 10 al 19
                switch (numero) {
                case 10: textoNumero = "diez"; break;
                case 11: textoNumero = "once"; break;
                case 12: textoNumero = "doce"; break;
                case 13: textoNumero = "trece"; break;
                case 14: textoNumero = "catorce"; break;
                case 15: textoNumero = "quince"; break;
                case 16: textoNumero = "dieciseis"; break;
                case 17: textoNumero = "diecisiete"; break;
                case 18: textoNumero = "dieciocho"; break;
                case 19: textoNumero = "diecinueve"; break;
                } 
            } else if (decenas == 2) {
                // Recoge los casos de la veintena
                if (numero == 20)
                    textoNumero = "veinte";
                else 
                    textoNumero = "veinti" + textoUnidades;
            } else {
                // Recoge los casos desde el 30 hasta el 99
                if (unidades == 0) 
                    textoNumero = textoDecenas;
                else
                    textoNumero = textoDecenas + " y " + textoUnidades;
            }
            // Salida
            System.out.println(numero + ". " + textoNumero);            
        }      
    }
        
}
