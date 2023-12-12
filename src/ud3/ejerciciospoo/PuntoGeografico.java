package ud3.ejerciciospoo;

public class PuntoGeografico {
    private String nombre;
    private double latitud;
    private double longitud;

    public PuntoGeografico(String nombre, double latitud, double longitud) {
        if (latitud < -90 || latitud > 90 || longitud < -180 || longitud > 180) {
            throw new IllegalArgumentException("Coordenadas no válidas");
        }
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public PuntoGeografico(double latitud, double longitud) {
        this(null, latitud, longitud);
    }

    public PuntoGeografico() {
        this.longitud = 0;
        this.latitud = 0;
    }

    public static PuntoGeografico generarAleatorio() {
        /*
         * PuntoGeografico punto = new PuntoGeografico();
         * punto.latitud = Math.random() * 180 - 90;
         * punto.longitud = Math.random() * 360 - 180;
         * return punto;
         */

        return new PuntoGeografico(Math.random() * 180 - 90, Math.random() * 360 - 180);

    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }


    // MÉTODOS PARA MOSTRAR INFORMACIÓN
    public void mostrarGradosDecimales() {
        System.out.println("Latitud: " + latitud + ", Longitud: " + longitud);
    }

    @Override
    public String toString() {
        return "PuntoGeografico [nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + "]";
    }

    public String urlGoogleMaps() {
        return "https://www.google.es/maps/@" + latitud + "," + longitud + ",12z ";
    }

    public String urlOpenStreetMaps() {
        return "https://www.openstreetmap.org/#map=14/" + latitud + "/" + longitud;
    }

    public String urlNominatimXml(){
        return "https://nominatim.openstreetmap.org/reverse?format=xml&lat=" + latitud + "&lon=" + longitud + "&zoom=14";
    }

    public String urlNominatimJson(){
        return "https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=" + latitud + "&lon=" + longitud;
    }

    public static void main(String[] args) {

        PuntoGeografico centroEducativo = new PuntoGeografico("IES Chan do Monte", 42.3893981, -8.7102411);
            centroEducativo.mostrarGradosDecimales();
            System.out.println(centroEducativo);
            System.out.println(centroEducativo.urlGoogleMaps());
            System.out.println(centroEducativo.urlOpenStreetMaps());
            System.out.println(centroEducativo.urlNominatimXml());
            System.out.println(centroEducativo.urlNominatimJson());
/*
        for(int i = 0; i < 2; i++){
            PuntoGeografico punto = PuntoGeografico.generarAleatorio();
            punto.mostrarGradosDecimales();
            System.out.println(punto);
            System.out.println(punto.urlGoogleMaps());
            System.out.println(punto.urlOpenStreetMaps());
            System.out.println(punto.urlNominatimXml());
            System.out.println(punto.urlNominatimJson());
        }
*/
        System.out.println("Fin del programa");
    }

}
