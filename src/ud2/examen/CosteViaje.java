package ud2.examen;

public class CosteViaje {
    public static void main(String[] args) {
        double km = 20; // Cambia este valor por la cantidad de kilómetros de tu viaje.
        byte combustible = 2; // 0 = Gasolina, 1 = Diesel, 2 = Electricidad
        double consumoMedio = 15.0; // Cambia este valor por el consumo medio de tu coche.

        double coste = costeViaje(km, combustible, consumoMedio);
        System.out.println("El coste del viaje es: " + coste + " euros.");
    }


    public static double costeViaje(double km, byte combustible, double consumoMedio) {
        final double PRECIO_LITRO_GASOLINA = 1.638;
        final double PRECIO_LITRO_DIESEL = 1.626;
        final double PRECIO_KWH = 0.1692;

        double costeTotal = 0.0;

        switch (combustible) {
            case 0: // Gasolina
                costeTotal = (km / 100.0) * consumoMedio * PRECIO_LITRO_GASOLINA;
                break;
            case 1: // Diesel
                costeTotal = (km / 100.0) * consumoMedio * PRECIO_LITRO_DIESEL;
                break;
            case 2: // Electricidad
                costeTotal = (km / 100.0) * consumoMedio * PRECIO_KWH;
                break;
            default:
                System.out.println("Tipo de combustible no válido.");
        }

        return costeTotal;
    }




}
