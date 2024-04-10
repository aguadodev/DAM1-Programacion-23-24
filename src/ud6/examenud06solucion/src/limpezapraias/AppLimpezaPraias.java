package limpezapraias;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class AppLimpezaPraias {
    static Praia[] praias;
    static Map<Praia, List<LimpezaPraia>> mapaPlayasLimpiezas;
    static boolean hayNuevasLimpiezas = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Carga las playas desde el fichero JSON en un array de Praias
        praias = Util.importarPraias("praias.json");

        // Carga en un mapa el contenido del fichero limpieza.dat
        mapaPlayasLimpiezas = Util.leerFichero("limpeza.dat",
                new TreeMap<Praia, List<LimpezaPraia>>());

        System.out.println(mapaPlayasLimpiezas);

        do {
            menuPrincipal();
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    // Listado de limpiezas de un equipo concreto, ordenado por fecha
                    // ascendentemente.
                    System.out.print("Introduce el nombre del equipo: ");
                    String equipo = sc.nextLine();
                    listadoLimpiezasEquipo(mapaPlayasLimpiezas, equipo);
                    break;
                case 2:
                    // Listado de limpiezas de una playa concreta, ordenado por fecha
                    // descendentemente.
                    System.out.print("Introduce el id de la playa: ");
                    int idPlaya = sc.nextInt();
                    listadoLimpiezasPlaya(mapaPlayasLimpiezas, idPlaya);
                    break;
                case 3:
                    // 10 últimas limpiezas realizadas en cualquier playa.
                    ultimasLimpiezas(mapaPlayasLimpiezas);
                    break;
                case 4:
                    // 10 playas con más kilos de basura recogidos.
                    playasMasKilos(mapaPlayasLimpiezas);
                    break;
                case 5:
                    // 10 primeros equipos con más limpiezas realizadas
                    equiposMasLimpiezas(mapaPlayasLimpiezas);
                    break;
                case 6:
                    // 10 primeros equipos con más kilos recogidos
                    // equiposMasKilos(mapaPlayasLimpiezas);
                    break;
                case 7:
                    // Añadir Limpieza de playa
                    anadirLimpieza(mapaPlayasLimpiezas, praias);
                    break;
                case 8:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 8);

        // Escribir el mapa de playas y limpiezas en el fichero limpeza.dat
        if (hayNuevasLimpiezas)
            Util.escribirFichero(mapaPlayasLimpiezas, "limpeza.dat");

    }

    private static void equiposMasLimpiezas(Map<Praia, List<LimpezaPraia>> mapaPlayasLimpiezas) {
        List<LimpezaPraia> limpiezas = getListaLimpiezas(mapaPlayasLimpiezas);
        List<String> equipos = new ArrayList<>();
        for (LimpezaPraia limpieza : limpiezas) {
            if (!equipos.contains(limpieza.equipo)) {
                equipos.add(limpieza.equipo);
            }
        }

        equipos.sort((a, b) -> limpiezasPorEquipo(b, limpiezas) - limpiezasPorEquipo(a, limpiezas));

        System.out.println("\nEquipos con más limpiezas realizadas");
        System.out.println("-------------------------------------");

        for (int i = 0; i < 10 && i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i) + " - " + limpiezasPorEquipo(equipos.get(i), limpiezas)
                    + " limpiezas");
        }
        System.out.println();
    }

    private static int limpiezasPorEquipo(String equipo, List<LimpezaPraia> limpiezas) {
        int limpiezasEquipo = 0;
        for (LimpezaPraia limpieza : limpiezas) {
            if (limpieza.equipo.equals(equipo)) {
                limpiezasEquipo++;
            }
        }
        return limpiezasEquipo;
    }

    /**
     * Calcula el número de limpiezas realizadas por un equipo
     * @param mapaPlayasLimpiezas
     */
    private static void playasMasKilos(Map<Praia, List<LimpezaPraia>> mapaPlayasLimpiezas) {
        List<Praia> playas = new ArrayList<>(mapaPlayasLimpiezas.keySet());

        playas.sort((a, b) -> 
            kilosPorPlaya(b, mapaPlayasLimpiezas) - kilosPorPlaya(a, mapaPlayasLimpiezas)
        );

        System.out.println("\nPlayas con más kilos de basura recogidos");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < 10 && i < playas.size(); i++) {
            System.out.println((i + 1) + ". " + playas.get(i).getNome() + " (" + playas.get(i).getId() + ") - "
                    + kilosPorPlaya(playas.get(i), mapaPlayasLimpiezas) + " kilos");
        }
        System.out.println();
    }

    /**
     * Calcula el número de limpiezas realizadas por un equipo
     * @param playa
     * @param mapaPlayasLimpiezas
     * @return
     */
    private static int kilosPorPlaya(Praia playa, Map<Praia, List<LimpezaPraia>> mapaPlayasLimpiezas) {
        int kilos = 0;
        for (LimpezaPraia limpeza : mapaPlayasLimpiezas.get(playa)) {
            kilos += limpeza.kilosBasura;
        }
        return kilos;
    }

    /**
     * Calcula el número de limpiezas realizadas por un equipo
     * @param mapaPlayasLimpiezas
     * @param equipo
     */
    private static void listadoLimpiezasEquipo(Map<Praia, List<LimpezaPraia>> mapaPlayasLimpiezas, String equipo) {
        List<LimpezaPraia> limpiezas = getListaLimpiezas(mapaPlayasLimpiezas);
        List<LimpezaPraia> limpiezasEquipo = new ArrayList<>();
        for (LimpezaPraia limpeza : limpiezas) {
            if (limpeza.equipo.equals(equipo)) {
                limpiezasEquipo.add(limpeza);
            }
        }

        if (limpiezasEquipo.size() > 0) {
            System.out.println("\nLimpiezas del equipo " + equipo);
            System.out.println("-----------------------------");
            limpiezasEquipo.sort((l1, l2) -> l1.fecha.compareTo(l2.fecha));
            for (int i = 0; i < limpiezasEquipo.size(); i++) {
                System.out.println((i + 1) + ". " + limpiezasEquipo.get(i));
            }
            System.out.println();
        } else {
            System.out.println("\nNo hay limpiezas para ese equipo\n");
        }
    }

    /**
     * Calcula el número de limpiezas realizadas por un equipo
     * @param mapaPlayasLimpiezas
     * @param idPlaya
     */
    private static void listadoLimpiezasPlaya(Map<Praia, List<LimpezaPraia>> mapaPlayasLimpiezas, int idPlaya) {
        Praia playa = buscarPlaya(praias, idPlaya);
        List<LimpezaPraia> limpiezas = mapaPlayasLimpiezas.get(playa);
        if (limpiezas != null) {
            limpiezas.sort((l1, l2) -> l2.fecha.compareTo(l1.fecha));
            System.out.println("\nLimpiezas de la playa " + playa.getNome() + " (" + playa.getId() + ")");
            System.out.println("---------------------------------");
            for (int i = 0; i < limpiezas.size(); i++) {
                System.out.println((i + 1) + ". " + limpiezas.get(i));
            }
            System.out.println();
        } else {
            System.out.println("\nNo hay limpiezas para esa playa o la playa no existe\n");
        }

    }

    /**
     * Muestra las 10 últimas limpiezas realizadas
     * @param mapaPlayasLimpiezas
     */
    private static void ultimasLimpiezas(Map<Praia, List<LimpezaPraia>> mapaPlayasLimpiezas) {
        List<LimpezaPraia> limpiezas = getListaLimpiezas(mapaPlayasLimpiezas);

        limpiezas.sort((l1, l2) -> l2.fecha.compareTo(l1.fecha));

        if (limpiezas.size() > 0) {
            System.out.println("\nÚltimas 10 limpiezas realizadas:");
            System.out.println("-------------------------------");
            for (int i = 0; i < 10 && i < limpiezas.size(); i++) {
                System.out.println((i + 1) + ". " + limpiezas.get(i));
            }
            System.out.println();
        } else {
            System.out.println("\nAún no hay limpiezas realizadas\n");
        }
    }

    /**
     * Obtiene una lista de todas las limpiezas realizadas
     * @param mapaPlayasLimpiezas
     * @return Lista de limpiezas
     */
    private static List<LimpezaPraia> getListaLimpiezas(Map<Praia, List<LimpezaPraia>> mapaPlayasLimpiezas) {
        List<LimpezaPraia> limpiezas = new ArrayList<>();
        for (List<LimpezaPraia> limpezasPraia : mapaPlayasLimpiezas.values()) {
            limpiezas.addAll(limpezasPraia);
        }
        return limpiezas;
    }

    /**
     * Añade una limpieza a una playa
     * 
     * @param mapaPlayas
     * @param praias
     */
    public static void anadirLimpieza(Map<Praia, List<LimpezaPraia>> mapaPlayas, Praia[] praias) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el id de la playa: ");
        int nombrePlaya = sc.nextInt();
        sc.nextLine();
        Praia playa = buscarPlaya(praias, nombrePlaya);
        if (playa != null) {
            System.out.print("Introduce el nombre del equipo: ");
            String equipo = sc.nextLine();
            System.out.print("Introduce la fecha (aaaa-mm-dd): ");
            LocalDate fecha = LocalDate.parse(sc.nextLine());
            System.out.print("Introduce los kilos recogidos: ");
            int kilos = sc.nextInt();
            sc.nextLine();
            LimpezaPraia limpieza = new LimpezaPraia(equipo, fecha, kilos, playa);
            hayNuevasLimpiezas = true;
            if (mapaPlayas.containsKey(playa)) {
                // Si la playa ya tiene limpiezas, añadimos la nueva limpieza a la lista
                mapaPlayas.get(playa).add(limpieza);
            } else {
                // Si la playa no tiene limpiezas, creamos una nueva lista y añadimos la entrada
                // al mapa
                List<LimpezaPraia> limpezas = new ArrayList<>();
                limpezas.add(limpieza);
                mapaPlayas.put(playa, limpezas);
            }
            List<LimpezaPraia> limpezas = mapaPlayas.get(playa);
            if (limpezas == null) {
                limpezas = new ArrayList<>();
                mapaPlayas.put(playa, limpezas);
            }

        } else {
            System.out.println("No se ha encontrado la playa");
        }
    }

    /**
     * Busca una playa en un array de playas
     * 
     * @param praias  Array de playas
     * @param idPlaya Id de la playa a buscar
     * @return La playa si la encuentra, null en caso contrario
     */
    public static Praia buscarPlaya(Praia[] praias, int idPlaya) {
        for (Praia praia : praias) {
            if (praia.getId() == idPlaya) {
                return praia;
            }
        }
        return null;
    }

    /**
     * Muestra el menú principal
     */
    static void menuPrincipal() {
        System.out.println("\nLIMPIEZA DE PLAYAS - MENÚ PRINCIPAL");
        System.out.println("====================================");
        System.out.println("1. Listado de limpiezas de un equipo concreto, ordenado por fecha ascendentemente.");
        System.out.println("2. Listado de limpiezas de una playa concreta, ordenado por fecha descendentemente.");
        System.out.println("3. 10 últimas limpiezas realizadas en cualquier playa.");
        System.out.println("4. 10 playas con más kilos de basura recogidos.");
        System.out.println("5. 10 primeros equipos con más limpiezas realizadas");
        System.out.println("6. 10 primeros equipos con más kilos recogidos");
        System.out.println("7. Añadir Limpieza de playa");
        System.out.println("8. Salir");
    }

}