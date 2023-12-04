package ud3.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ObtenerPaisDesdeCoordenadas {

    public static void main(String[] args) {
        double latitud = 27.9380;  // Reemplaza con la latitud de tu ubicación
        double longitud = -15.6294;  // Reemplaza con la longitud de tu ubicación

        String pais = obtenerPaisDesdeCoordenadas(latitud, longitud);

        System.out.println("El país es: " + pais);
    }

    public static String obtenerPaisDesdeCoordenadas(double latitud, double longitud) {
        String url = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + latitud + "&lon=" + longitud;
        System.out.println(url);
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("Accept-Language", "es");
            conn.setRequestMethod("GET");

            InputStream inputStream = conn.getInputStream();

            Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
            String response = scanner.hasNext() ? scanner.next() : "";
            System.out.println(response);
            // Parsear el JSON para obtener el nombre del país
            // Aquí puedes usar una biblioteca como Gson o simplemente manipular la cadena JSON manualmente.

            // En este ejemplo, asumimos que el nombre del país está dentro de la propiedad "country".
            int startIndex = response.indexOf("country") + 10;
            int endIndex = response.indexOf(",", startIndex);

            return response.substring(startIndex, endIndex).replaceAll("\"", "").trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al obtener el país";
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            return "Error al obtener el país";            
        }
    }
}

