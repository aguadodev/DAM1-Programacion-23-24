package varios.proyectoviajecompartido;

public class App {
    public static void main(String[] args) {
        PuntoGeografico puntoGeografico1 = new PuntoGeografico("Madrid", 40.4167, -3.70325);   
        PuntoGeografico puntoGeografico2 = new PuntoGeografico("Barcelona", 41.3825, 2.17694);
        try {
            PuntoGeografico puntoErroneo = new PuntoGeografico("Error", 91, -5.97694);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        PuntoGeografico chanDoMonte = new PuntoGeografico("Chan do Monte", 42.3895784, -8.7099882);
        chanDoMonte.mostrarGradosDecimales();
        System.out.println(chanDoMonte.urlGoogleMaps());
        System.out.println(chanDoMonte.urlOpenStreetMaps());
        System.out.println(chanDoMonte.urlNominatimXml());
        System.out.println(chanDoMonte.urlNominatimJson());

        System.out.println(CifradoBcrypt.generarHash2YString("abc123.,"));

        // Crea el usuario de la aplicación si los datos de login son correctos.
        User user = User.loginUsuario("mcostcruz", "mcostcruz");
        System.out.println(user);
    }

}
