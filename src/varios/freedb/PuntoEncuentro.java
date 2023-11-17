package varios.freedb;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class PuntoEncuentro {
    private String nombre;
    private double latitud;
    private double longitud;

    public PuntoEncuentro(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public PuntoEncuentro(String nombre) {
        this.nombre = nombre;

        double[] coordenadas = getCoordenadas(nombre);

        if (coordenadas != null) {
            latitud = coordenadas[1];
            longitud = coordenadas[0];
        }

    }

    public PuntoEncuentro() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "PuntoEncuentro [nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + "]";
    }

    public static void main(String[] args) {
        PuntoEncuentro centroEducativo = new PuntoEncuentro("IES Chan do Monte");

        System.out.println(centroEducativo);

        System.out.print("Destino? ");

        String nombreDestino = new Scanner(System.in).nextLine();

        PuntoEncuentro destino = new PuntoEncuentro(nombreDestino);

        System.out.println(destino);

        System.out.println(urlRutaCoche(centroEducativo, destino));
    }

    /*
     * Recibe dos pares de coordenadas que representan un origen y un destino
     * Devuelve la URL de OSM para obtener la ruta en coche o null
     */
    public static String urlRutaCoche(PuntoEncuentro origen, PuntoEncuentro destino) {
        return "https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route="
                + origen.latitud + "," + origen.longitud + ";"
                + destino.latitud + "," + destino.longitud;
    }

    /*
     * ****************
     * OPEN STREET MAPS
     * ****************
     */

    /*
     * Recibe una dirección geográfica
     * Devuelve una URL en forma de cadena de caracteres para obtener el JSON o null
     */
    public static String urlDireccionJson(String direccion) {
        /*
         * - Sustituimos espacios " " por símbolos "+"
         * - Los acentos generan una excepción al construir el objeto URL, los
         * cambiamos?
         * - Alguna forma mejor de construir las urls?
         */
        return "https://nominatim.openstreetmap.org/search?q="
                + direccion.replace(" ", "+")
                + "&format=geojson";
    }

    /*
     * Recibe una dirección geográfica
     * Devuelve un array de dos datos double (longitud, latitud) o null
     */
    public static double[] getCoordenadas(String direccion) {
        double[] coordenadas = null;

        String url = urlDireccionJson(direccion);

        String json = getJson(url);

        if (json != null) {
            coordenadas = new double[2];
            JSONArray coordinates = new JSONObject(json).getJSONArray("features").getJSONObject(0)
                    .getJSONObject("geometry").getJSONArray("coordinates");
            coordenadas[0] = coordinates.getDouble(0);
            coordenadas[1] = coordinates.getDouble(1);
        }

        return coordenadas;
    }

    /*
     * Recibe dos pares de coordenadas que representan un origen y un destino
     * Devuelve la URL de OSM para obtener la ruta en coche o null
     */
    public static String urlRutaCoche(double latitudInicio, double longitudInicio, double latitudFin,
            double longitudFin) {
        return "https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route="
                + latitudInicio + "," + longitudInicio + ";"
                + latitudFin + "," + longitudFin;
    }

    /*
     * Recibe dos pares de coordenadas que representan un origen y un destino
     * Devuelve la distancia en metros de la ruta en coche entre los dos puntos.
     */
    public static double distanciaCoche(double latitudInicio, double longitudInicio, double latitudFin,
            double longitudFin) {
        double distancia = -1;
        String tipoRuta = "driving";
        String url = "https://router.project-osrm.org/route/v1/" + tipoRuta + "/"
                + longitudInicio + "," + latitudInicio + ";"
                + longitudFin + "," + latitudFin + "?overview=false";

        String json = getJson(url);
        if (json != null) {
            JSONObject objeto = new JSONObject(json);
            JSONArray array = objeto.getJSONArray("routes");
            objeto = array.getJSONObject(0);
            distancia = objeto.getDouble("distance");
        }

        return distancia;
    }

    /*
     * Recibe dos direcciones geográficas que representan un origen y un destino
     * Devuelve la distancia en metros de la ruta en coche entre los dos puntos.
     */
    public static double distanciaCoche(String origen, String destino) {
        double distancia = -1;

        double[] coordenadasOrigen = getCoordenadas(origen);
        double[] coordenadasDestino = getCoordenadas(destino);

        String tipoRuta = "driving";
        String url = "https://router.project-osrm.org/route/v1/" + tipoRuta + "/"
                + coordenadasOrigen[0] + "," + coordenadasOrigen[1] + ";"
                + coordenadasDestino[0] + "," + coordenadasDestino[1] + "?overview=false";

        String json = getJson(url);
        if (json != null) {
            distancia = new JSONObject(json).getJSONArray("routes").getJSONObject(0).getDouble("distance");
        }

        return distancia;
    }

    /**
     * Recibe una URL en forma de cadena de caracteres,
     * Devuelve un String con el contenido del JSON o null.
     */
    public static String getJson(String textoURL) {

        URL url;

        try {
            // Utiliza el proxy del sistema
            System.setProperty("java.net.useSystemProxies", "true");

            url = new URL(textoURL);
            try (InputStream input = url.openStream()) {
                InputStreamReader isr = new InputStreamReader(input);
                BufferedReader reader = new BufferedReader(isr);
                StringBuilder json = new StringBuilder();
                int c;
                while ((c = reader.read()) != -1) {
                    json.append((char) c);
                }
                return json.toString();
            } catch (Exception e) {
                return null;
            }

        } catch (MalformedURLException e) {
            // textoURL no
            return null;
        }

    }

}
