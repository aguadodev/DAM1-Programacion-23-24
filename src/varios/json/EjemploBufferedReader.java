package varios.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class EjemploBufferedReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://world.openfoodfacts.org/api/v0/product/8424523060914.json");
            // Configuración del proxy del sistema
            System.setProperty("java.net.useSystemProxies", "true");       
                 
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            
            String json = content.toString();
            // Aquí puedes procesar el contenido JSON como desees
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
