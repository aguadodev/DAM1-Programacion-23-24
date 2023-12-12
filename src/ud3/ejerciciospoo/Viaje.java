package ud3.ejerciciospoo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Viaje {
    private User conductor;
    private LocalDateTime fechaHoraSalida;
    private PuntoGeografico puntoOrigen;
    private PuntoGeografico puntoDestino;
    private int plazasPasajeros;

    public Viaje(User conductor, LocalDateTime fechaHoraSalida, PuntoGeografico puntoOrigen,
            PuntoGeografico puntoDestino, int plazasPasajeros) {
        this.conductor = conductor;
        this.fechaHoraSalida = fechaHoraSalida;
        this.puntoOrigen = puntoOrigen;
        this.puntoDestino = puntoDestino;
        this.plazasPasajeros = plazasPasajeros;
    }

    public Viaje(){ }

    @Override
    public String toString() {
        return fechaHoraSalida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + " - " + conductor + " - " + puntoOrigen.getNombre() + " >> " + puntoDestino.getNombre();
    }

    public void mostrarDetalle() {
        System.out.println("Conductor: " + conductor);
        System.out.println("Fecha/Hora Salida: " + fechaHoraSalida);
        System.out.println("Punto Origen: " + puntoOrigen);
        System.out.println("Punto Destino: " + puntoDestino);
        System.out.println("Plazas Pasajeros: " + plazasPasajeros);
        System.out.println("Detalle de la ruta: " + urlOpenStreetMaps());
    }

    public String urlOpenStreetMaps(){
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

}
