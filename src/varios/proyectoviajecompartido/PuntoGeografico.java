package varios.proyectoviajecompartido;

public class PuntoGeografico {
    private String nombre;
    private double latitud;
    private double longitud;

    public PuntoGeografico(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        if (latitud < -90 || latitud > 90) {
            throw new IllegalArgumentException("La latitud debe estar entre -90 y 90");
        }
        this.latitud = latitud;
        if (longitud < -180 || longitud > 180) {
            throw new IllegalArgumentException("La longitud debe estar entre -180 y 180");
        }
        this.longitud = longitud;
    }

    public PuntoGeografico() {
        this.nombre = "";
        this.latitud = 0;
        this.longitud = 0;
    }

    public PuntoGeografico generarAleatorio() {
        PuntoGeografico puntoGeografico = new PuntoGeografico();
        puntoGeografico.nombre = "Aleatorio";
        puntoGeografico.latitud = Math.random() * 180 - 90;
        puntoGeografico.longitud = Math.random() * 360 - 180;
        return puntoGeografico;
    }

    public void mostrarGradosDecimales() {
        System.out.println("Latitud: " + this.latitud);
        System.out.println("Longitud: " + this.longitud);
    }

    public String urlGoogleMaps() {
        return "https://www.google.com/maps/search/?api=1&query=" + this.latitud + "," + this.longitud;
    }

    public String urlOpenStreetMaps() {
        return "https://www.openstreetmap.org/#map=14/" + this.latitud + "/" + this.longitud;
    }

    public String urlNominatimXml() {
        return "https://nominatim.openstreetmap.org/reverse?format=xml&lat=" + this.latitud + "&lon=" + this.longitud;
    }

    public String urlNominatimJson() {
        return "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + this.latitud + "&lon=" + this.longitud;
    }


    // RUTAS
    public String urlOsrmJson(PuntoGeografico puntoGeograficoDestino) {
        return "http://router.project-osrm.org/route/v1/driving/" + this.longitud + "," + this.latitud + ";"
                + puntoGeograficoDestino.longitud + "," + puntoGeograficoDestino.latitud
                + "?overview=false&geometries=geojson";
    }

    public static String urlOsrmJson(PuntoGeografico puntoGeograficoOrigen, PuntoGeografico puntoGeograficoDestino,
            PuntoGeografico... puntosIntermedios) {
        String url = "http://router.project-osrm.org/route/v1/driving/" + puntoGeograficoOrigen.longitud + ","
                + puntoGeograficoOrigen.latitud;
        for (PuntoGeografico puntoGeografico : puntosIntermedios) {
            url += ";" + puntoGeografico.longitud + "," + puntoGeografico.latitud;
        }
        url += ";" + puntoGeograficoDestino.longitud + "," + puntoGeograficoDestino.latitud
                + "?overview=false&geometries=geojson";
        return url;
    }
    


}
