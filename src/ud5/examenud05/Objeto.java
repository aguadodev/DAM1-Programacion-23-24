package ud5.examenud05;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class Objeto implements Comparable {
    protected String nombre;
    protected String descripcion;
    protected String ubicacion;
    protected User usuarioPublicacion;
    protected LocalDateTime fechaHoraPublicacion;
    protected User usuarioRecogida;
    protected LocalDateTime fechaHoraRecogida;
    protected boolean recogido;

    /* CONSTRUCTOR */
    public Objeto(String nombre, String descripcion, String ubicacion, User usuarioPublicacion,
            LocalDateTime fechaHoraPublicacion, User usuarioRecogida, LocalDateTime fechaHoraRecogida,
            boolean recogido) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.usuarioPublicacion = usuarioPublicacion;
        this.fechaHoraPublicacion = fechaHoraPublicacion;
        this.usuarioRecogida = usuarioRecogida;
        this.fechaHoraRecogida = fechaHoraRecogida;
        this.recogido = recogido;
    }

    public Objeto() {
        //TODO Auto-generated constructor stub
    }

    /**
     * Devuelve el nombre del objeto y su clase
     */
    @Override
    public String toString() {
        return nombre + " - (" + getClass().getSimpleName() + ")";
    }

    /**
     * Muestra los detalles del objeto en la consola
     */
    public void mostrarDetalles() {
        String str = "Nombre: " + nombre +
                "\nDescripción: " + descripcion +
                "\nUbicación: " + ubicacion +
                "\nFecha y Hora de Publicación: " + fechaHoraPublicacion;

        // Muestra el usuario de publicación si existe
        str += usuarioPublicacion != null ? "\nUsuario Publicación: " + usuarioPublicacion : "";

        // Muestra si el objeto fue recogido
        str += "\nRecogido: " + (recogido ? "Sí" : "No");

        // Si fue recogido muestra la fecha y hora de recogida y el usuario de recogida
        // si existe
        if (recogido) {
            str += fechaHoraRecogida != null ? "\nFecha y Hora de Recogida: " + fechaHoraRecogida : "";
            str += usuarioRecogida != null ? "\nUsuario Recogida: " + usuarioRecogida : "";
        }
        str += "\n\n";

        System.out.println(str);
    }

    /**
     * Muestra los objetos en la consola
     * 
     * @param objetos Array de objetos a mostrar
     */
    static public void mostrarObjetos(Objeto[] objetos) {
        System.out.println("N. Nombre\tRecog.\tUsuario\tFecha Publicación");
        System.out.println("---------\t------\t-------\t-----------------");
        for (int i = 0; i < objetos.length; i++) {
            System.out.println((i + 1) + ". " + objetos[i].nombre + "\t" + objetos[i].recogido + "\t"
                    + objetos[i].usuarioPublicacion + "\t" + objetos[i].fechaHoraPublicacion);
        }
    }

    /**
     * Muestra los objetos en la consola (añadiendo FechaRecogida)
     * 
     * @param objetos Array de objetos a mostrar
     */
    static public void mostrarObjetos2(Objeto[] objetos) {
        System.out.println("N. Nombre\tRecog.\tUsuario\tFecha Publicación\tFecha Recogida");
        System.out.println("---------\t------\t-------\t-----------------\t--------------");
        for (int i = 0; i < objetos.length; i++) {
            System.out.println((i + 1) + ". " + objetos[i].nombre + "\t" + objetos[i].recogido + "\t"
                    + objetos[i].usuarioPublicacion + "\t" + objetos[i].fechaHoraPublicacion + "\t"
                    + objetos[i].fechaHoraRecogida);
        }
    }

    /*
     * CRITERIO DE ORDENACIÓN NATURAL
     */
    @Override
    public int compareTo(Object o) {
        return nombre.compareTo(((Objeto) o).nombre);
    }

    /*
     * MÉTODOS DE ORDENACIÓN
     */
    public static Objeto[] sortFechaPublicacion(Objeto[] objetos) {
        Comparator compFechaPublicado = new CompFechaPublicado();
        Arrays.sort(objetos, compFechaPublicado);
        return objetos;
    }

    public static Objeto[] sortFechaRecogidaPublicacion(Objeto[] objetos) {
        Comparator compFechaRecogido = new CompFechaRecogido();

        Comparator compFechaPublicado = new CompFechaPublicado();

        Arrays.sort(objetos, compFechaRecogido.thenComparing(compFechaPublicado));

        return objetos;
    }

    public static Objeto[] sortRecogidosUsuariosFecha(Objeto[] objetos) {
        // Ordenar objetos por recogido, usuario de publicación y fecha de publicación
        Comparator compRecogido = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Objeto obj1 = (Objeto) o1;
                Objeto obj2 = (Objeto) o2;

                if (obj1.recogido && !obj2.recogido)
                    return 1;
                else if (!obj1.recogido && obj2.recogido)
                    return -1;
                else
                    return 0;
            }
        };

        Comparator compUserPublicado = new CompUsuarioPublicacion();

        Comparator compFechaPublicado = new CompFechaPublicado();

        Arrays.sort(objetos, compRecogido.thenComparing(compUserPublicado).thenComparing(compFechaPublicado.reversed()));

        return objetos;
    }

}
