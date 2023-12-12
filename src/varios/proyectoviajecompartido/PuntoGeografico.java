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

    public void mostrarGradosDMS() {
        int grados = (int) Math.abs(latitud);
        double minutosDecimal = (Math.abs(latitud) - grados) * 60;
        int minutos = (int) minutosDecimal;
        double segundos = (int) ((minutosDecimal - minutos) * 60);
        System.out.println("Latitud: " + grados + "° " + minutos + "' " + segundos + "\" " + ((latitud >= 0) ? "Norte" : "Sur"));

        grados = (int) Math.abs(longitud);
        minutosDecimal = (Math.abs(longitud) - grados) * 60;
        minutos = (int) minutosDecimal;
        segundos = (int) ((minutosDecimal - minutos) * 60);
        System.out.println("Latitud: " + grados + "° " + minutos + "' " + segundos + "\" " + ((longitud >= 0) ? "Este" : "Oeste"));
    }


    /* URLs OSM Y GMAPS */
    public String urlGoogleMaps() {
        return "https://www.google.com/maps/search/?api=1&query=" + this.latitud + "," + this.longitud;
    }

    public String urlOpenStreetMaps() {
        return "https://www.openstreetmap.org/#map=14/" + this.latitud + "/" + this.longitud;
    }

    /* API OSM NOMINATIN */
    public String urlNominatimXml() {
        return "https://nominatim.openstreetmap.org/reverse?format=xml&lat=" + this.latitud + "&lon=" + this.longitud;
    }

    public String urlNominatimJson() {
        return "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + this.latitud + "&lon=" + this.longitud;
    }


    /* API OSM OSRM */
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

    public boolean esMar() {
        boolean esMar = true;
        String url = this.urlNominatimJson();
        String json = Utilidades.leerUrl(url);
        if (json.contains("country")) {
            esMar = false;
        }
        return esMar;
    }

    public String getCountry() {
        String url = this.urlNominatimJson();
        String json = Utilidades.leerUrl(url);
        String country = null;
        int index = json.indexOf("\"country\":");
        if (index != -1) {
            int index2 = json.indexOf("\"", index + 11);
            country = json.substring(index + 11, index2);
        }
        return country;
    }
    


}