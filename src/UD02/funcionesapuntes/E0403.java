package ud02.funcionesapuntes;

public class E0403 {
    public static void main(String[] args) {
        // Salida
        areaVolumenCilindro(1, 2.5, 3.8);
        areaVolumenCilindro(2, 2.5, 3.8);
        areaVolumenCilindro(3, 2.5, 3.8);
    }
    
    static void areaVolumenCilindro(int opcion, double radio, double altura) {
        // Cuerpo de la función
    
        switch (opcion) {
            case 1: 
                // Calcular y mostrar area
                double area = 2 * Math.PI * radio * (altura + radio);
                System.out.println("Área = " + area);
                break;
            case 2:
                // Calcular y mostrar volumen
                double volumen = Math.PI * Math.pow(radio, 2) * altura;
                System.out.println("Volumen = " + volumen);
                break;
            default:
                // Opción incorrecta
                System.out.println("ERROR: opción incorrecta.");
        }
    }
        
}
