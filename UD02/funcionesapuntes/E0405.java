package UD02.funcionesapuntes;

public class E0405 {
    public static void main(String[] args) {
        // Proceso
        System.out.println(esVocal('á'));
        System.out.println(esVocal('é'));
        System.out.println(esVocal('í'));
        System.out.println(esVocal('ó'));
        System.out.println(esVocal('ú'));
        System.out.println(esVocal('Á'));
        System.out.println(esVocal('É'));
        System.out.println(esVocal('Í'));
        System.out.println(esVocal('Ó'));
        System.out.println(esVocal('Ú'));
        System.out.println(esVocal('f'));
    
        // Salida
    }
    
    static boolean esVocal(char letra) {
        boolean vocal = false;
    
        // Si es una vocal..
        switch (letra) {
            case 'A': ;
            case 'E': ;
            case 'I': ;
            case 'O': ;
            case 'U': ;
            case 'a': ;
            case 'e': ;
            case 'i': ;
            case 'o': ;
            case 'u': ;
            case 'á': ;
            case 'é': ;
            case 'í': ;
            case 'ó': ;
            case 'ú': ;
            case 'Á': ;
            case 'É': ;
            case 'Í': ;
            case 'Ó': ;
            case 'Ú':
                vocal = true;
        }
    
        return vocal;
    }
        
}
