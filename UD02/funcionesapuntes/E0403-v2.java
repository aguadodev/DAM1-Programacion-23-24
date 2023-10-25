package UD02.funcionesapuntes;

public class E0403-v2 {
    public static void main(String[] args) {
        // Salida
        areaVolumenCilindro(1, 2.5, 3.8);
        areaVolumenCilindro(2, 2.5, 3.8);
        areaVolumenCilindro(3, 2.5, 3.8);
    }
    
    static void areaVolumenCilindro(int opcion, double radio, double altura) {
        // Cuerpo de la función
    
        switch (opcion) {
            case 1 ->
                // Calcular y mostrar area                
                System.out.println("Área = " + areaCilindro(radio, altura));
            case 2 ->
                // Calcular y mostrar volumen
                System.out.println("Volumen = " + volumenCilindro(radio, altura));
            default ->
                // Opción incorrecta
                System.out.println("ERROR: opción incorrecta.");
        }
    }

    static double areaCilindro(double radio, double altura) {
        return 2 * Math.PI * radio * (altura + radio);
    }

    static double volumenCilindro(double radio, double altura){
        return Math.PI * Math.pow(radio, 2) * altura;
    }
        
}
