package varios.proyectoviajecompartido.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import varios.proyectoviajecompartido.Conexion;

public class Viaje {
    private User conductor;
    private LocalDateTime fechaHora; // Fecha y hora de salida
    private PuntoGeografico puntoOrigen;
    private PuntoGeografico puntoDestino;
    private int plazas; // Plazas ofrecidads a pasajeros

    public Viaje(User conductor, LocalDateTime fechaHora, PuntoGeografico puntoOrigen,
            PuntoGeografico puntoDestino, int plazas) {
        this.conductor = conductor;
        this.fechaHora = fechaHora;
        this.puntoOrigen = puntoOrigen;
        this.puntoDestino = puntoDestino;
        this.plazas = plazas;
    }

    public Viaje() {
    }

    @Override
    public String toString() {
        return fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + " - " + conductor.getUsername()
                + " - "
                + puntoOrigen.getNombre() + " >> " + puntoDestino.getNombre();
    }

    public void mostrarDetalle() {
        System.out.println("Conductor: " + conductor);
        System.out.println("Fecha/Hora Salida: " + fechaHora);
        System.out.println("Punto Origen: " + puntoOrigen);
        System.out.println("Punto Destino: " + puntoDestino);
        System.out.println("Plazas Pasajeros: " + plazas);
        System.out.println("Detalle de la ruta: " + urlOpenStreetMaps());
    }

    public String urlOpenStreetMaps() {
        return "https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route="
                + puntoOrigen.getLatitud() + "%2C" + puntoOrigen.getLongitud()
                + "%3B" + puntoDestino.getLatitud() + "%2C" + puntoDestino.getLongitud();
    }

    public static void main(String[] args) {
        Viaje viaje = new Viaje(
                new User("aguado"),
                LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                new PuntoGeografico("IES Chan do Monte", 42.3893981, -8.7102411),
                new PuntoGeografico("Pontevedra", 42.427855645977, -8.64455335556701),
                3);

        System.out.println("\nVIAJE COMPARTIDO\n===========");
        System.out.println(viaje);
        System.out.println();

        viaje.mostrarDetalle();
    }


    
    public static Viaje[] getViajesDisponibles() {
        Viaje[] viajes = new Viaje[0];

        Connection conexion = Conexion.conectar(); // Conectamos con la base de datos

        // Consulta SQL
        String sql = "SELECT * FROM VIAJE";
        try {
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery(sql);
            for (int i = 0; resultado.next(); i++) {
                viajes = Arrays.copyOf(viajes, viajes.length + 1);

                viajes[i] = new Viaje(
                        User.read(resultado.getInt("conductor")),
                        resultado.getTimestamp("fecha_hora").toLocalDateTime(),
                        PuntoGeografico.read(resultado.getInt("punto_salida")),
                        PuntoGeografico.read(resultado.getInt("punto_llegada")),
                        resultado.getInt("plazas"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return viajes;
    }

    public static Viaje[] getViajes(User usuarioLogueado) {
        Viaje[] viajes = new Viaje[0];

        Connection conexion = Conexion.conectar(); // Conectamos con la base de datos

        // Consulta SQL. TODO: Cambiar a consulta parametrizada
        String sql = "SELECT * FROM VIAJE, USER WHERE conductor = USER.id AND USER.username LIKE '"
                + usuarioLogueado.getUsername() + "'";
        try {
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery(sql);
            for (int i = 0; resultado.next(); i++) {
                viajes = Arrays.copyOf(viajes, viajes.length + 1);

                viajes[i] = new Viaje(
                        User.read(resultado.getInt("conductor")),
                        resultado.getTimestamp("fecha_hora").toLocalDateTime(),
                        PuntoGeografico.read(resultado.getInt("punto_salida")),
                        PuntoGeografico.read(resultado.getInt("punto_llegada")),
                        resultado.getInt("plazas"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return viajes;
    }

}
