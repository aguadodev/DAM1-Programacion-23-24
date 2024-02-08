package varios.pendentes2324.ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class Cesar {

    File f;

    public static Cesar getDesdeRuta(String ruta) throws FileNotFoundException{
        Cesar c = new Cesar();

        c.f = new File(ruta);
        if (!c.f.exists())
        throw(new FileNotFoundException());

        return c;
    }

    public String encriptar(int desplazamiento){
        File ficheroSalida = new File(f.getAbsolutePath() + ".cesar");
        try {
            ficheroSalida.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        
        try {
            Cesar c = Cesar.getDesdeRuta("d:\\Oscar\\texto.txt");
            c.encriptar(3);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Calcular el hash MD5 (checksum) de un fichero utilizando la clase java.security.MessageDigest
    //filePath es la ruta del fichero.
/*byte[] data = Files.readAllBytes(Paths.get(filePath));
byte[] hash = MessageDigest.getInstance("MD5").digest(data);
String checksum = new BigInteger(1, hash).toString(16);

// Calcular el hash MD5 (checksum) de un texto utilizando la clase java.security.MessageDigest
byte[] data = texto.getBytes());
byte[] hash = MessageDigest.getInstance("MD5").digest(data);
String checksum = new BigInteger(1, hash).toString(16);*/

}
