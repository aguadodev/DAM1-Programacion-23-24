package varios.proyectoviajecompartido;

import java.nio.charset.StandardCharsets;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class CifradoBcrypt {

    /*
     * FUNCIONES BCRYPT: generar hash y validar hash
     */

    public static boolean validarHash2Y(String password, byte[] hash2y) {
        return BCrypt.verifyer(BCrypt.Version.VERSION_2Y)
                .verifyStrict(password.getBytes(StandardCharsets.UTF_8), hash2y).verified;
    }

    public static boolean validarHash2Y(String password, String hash2y) {
        return BCrypt.verifyer(BCrypt.Version.VERSION_2Y)
                .verifyStrict(password.getBytes(StandardCharsets.UTF_8),
                        hash2y.getBytes(StandardCharsets.UTF_8)).verified;
    }

    public static byte[] generarHash2YByte(String password) {
        return BCrypt.with(BCrypt.Version.VERSION_2Y).hash(13, password.getBytes(StandardCharsets.UTF_8));
    }

    public static String generarHash2YString(String password) {
        char[] bcryptChars = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToChar(13, password.toCharArray());
        return String.valueOf(bcryptChars);
    }    

}
