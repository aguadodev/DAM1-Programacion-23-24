package varios.json;

/**
 * Programa de ejemplo de acceso URLs y servicios web en formato JSON: OPEN FOOD FACTS, OPEN STREET MAPS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class EjemplosJSON {

    /**
     * Recibe una URL en forma de cadena de caracteres,
     * Devuelve un String con el contenido del JSON o null.
     */
    public static String getJson(String textoURL) {
        
        URL url;

        System.out.println(textoURL);

        try {
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


    public static String obtenerContenidoURL(String urlString) throws IOException {
        // Crear la URL
        URL url = new URL(urlString);

        // Abrir la conexión
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

        // Configurar la solicitud GET
        conexion.setRequestMethod("GET");

        // Obtener la respuesta
        int respuestaCodigo = conexion.getResponseCode();

        if (respuestaCodigo == HttpURLConnection.HTTP_OK) {
            // Leer el contenido de la respuesta
            BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = lector.readLine()) != null) {
                contenido.append(linea);
            }

            lector.close();
            return contenido.toString();
        } else {
            // Manejar el error si la respuesta no es OK
            return "Error al obtener el contenido. Código de respuesta: " + respuestaCodigo;
        }
    }




    /*
     * ***************
     * OPEN FOOD FACTS
     * ***************
     */
    public static void mostrarProductoOpenFoodFacts(String codigo) {
        // Obtiene el JSON a partir de la URL de la API que incluye el código de barras
        String json = getJson("https://world.openfoodfacts.org/api/v0/product/" + codigo + ".json");

        // Código de producto: 8424523060914

        // Muestra todo el contenido del JSON
        // System.out.println("JSON COMPLETO: " + json);

        // Obtiene y muestra algunos campos del JSON
        JSONObject objeto = new JSONObject(json);
        String code = objeto.getString("code");
        System.out.println("Código: " + code);
        JSONArray keywords = objeto.getJSONObject("product").getJSONArray("_keywords");
        String marca = objeto.getJSONObject("product").getString("brands");
        String nombre = objeto.getJSONObject("product").getString("generic_name_es");
        System.out.println(nombre + ". Marca: " + marca);
        System.out.println("Palabras clave: " + keywords);
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

    public static void main(String[] args) {
        System.out.println("EJEMPLOS JSON:");
        System.out.println("##############");
        try {
            System.out.println(obtenerContenidoURL("https://jsonplaceholder.typicode.com/posts/1"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("EJEMPLO OPEN FOOD FACTS");
        System.out.println("=======================");
        final String CODIGO_EJEMPLO = "8424523060914";
        String codigo;

        System.out.print("Introduce un código de producto para ver su información básica ["
                + CODIGO_EJEMPLO + "]: ");

        Scanner sc = new Scanner(System.in);
        codigo = sc.nextLine();
        if (codigo == "")
            codigo = CODIGO_EJEMPLO;
        mostrarProductoOpenFoodFacts(codigo);
        sc.close();

        System.out.println("-------------------------------------------------------------");
        System.out.println();

        System.out.println("EJEMPLO OPEN STREET MAP");
        System.out.println("=======================");
        // Obtiene la distancia entre dos direcciones en formato String
        final String ORIGEN_EJEMPLO = "IES Chan do Monte, Marin";
        final String DESTINO_EJEMPLO = "Praza de Ferraria 1, Pontevedra";
        String direccionOrigen;
        String direccionDestino;

        Scanner sc2 = new Scanner(System.in);
        System.out.print("Introduce la dirección del punto de origen [" + ORIGEN_EJEMPLO + "]: ");
        direccionOrigen = sc2.nextLine();
        if (direccionOrigen == "")
            direccionOrigen = ORIGEN_EJEMPLO;

        System.out.print("Introduce la dirección del punto de destino [" + DESTINO_EJEMPLO + "]: ");
        direccionDestino = sc2.nextLine();
        if (direccionDestino == "")
            direccionDestino = DESTINO_EJEMPLO;

        double distanciaCoche = distanciaCoche(direccionOrigen, direccionDestino);
        System.out.println("Distancia: " + distanciaCoche + " metros (" + (int) (distanciaCoche / 1000) + " km)");
        sc2.close();

        System.out.println("-------------------------------------------------------------");
        System.out.println();
    }

}
