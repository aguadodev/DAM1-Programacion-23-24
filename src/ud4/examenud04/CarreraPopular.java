package ud4.examenud04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class CarreraPopular {
    public static void main(String[] args) {
        String[] participantes = new String[0];
        Scanner sc = new Scanner(System.in, "UTF-8"); // ISO-8859-1
        System.out.println("\nCarrera Popular");
        System.out.println("===============\n");
        System.out.println(
                "Introduce los nombres de los participantes de la carrera en el formato \"Apellidos, Nombre\" (sin las comillas). "
                        + "La entrada de datos terminará al introducir la cadena \"===\"");

        // Lee los participantes
        String participante = sc.nextLine();
        while (!participante.equals("===")) {
            participantes = Arrays.copyOf(participantes, participantes.length + 1);
            participantes[participantes.length - 1] = participante;
            participante = sc.nextLine();
        }
        sc.close();

        // Ordena y muestra los participantes
        Arrays.sort(participantes);
        for (int i = 0; i < participantes.length; i++)
            System.out.println(i + 1 + ". " + participantes[i]);

        System.out.println("Total de participantes: " + participantes.length);
        int participantesConHermanos = participantesHermanos(participantes);
        System.out.println("Número de participantes con hermanos en la carrera: " + participantesConHermanos);

    }

    static int participantesHermanos2(String[] participantes) {
        // Importante! Presupone el array ordenado, por tanto los hermanos estarán en
        // posiciones consecutivas. Pero y las mayúsculas/minúsculas? No es Case Insensitive
        int contarHermanos = 0;

        if (participantes != null && participantes.length > 1) {
            boolean hermanosAnteriores = false;
            for (int i = 1; i < participantes.length; i++) {
                String apellidosAnterior = participantes[i - 1].substring(0, participantes[i - 1].indexOf(','));
                String apellidosActual = participantes[i].substring(0, participantes[i].indexOf(','));
                if (apellidosActual.equalsIgnoreCase(apellidosAnterior)) {
                    if (hermanosAnteriores)
                        contarHermanos++;
                    else
                        contarHermanos += 2;
                    hermanosAnteriores = true;
                } else {
                    hermanosAnteriores = false;
                }
            }
        }

        return contarHermanos;
    }

    static int participantesHermanos(String[] participantes) {
        int contarHermanos = 0;

        if (participantes != null && participantes.length > 1) {
            // Genera un array auxiliar con los apellidos caseInsensitive y los ordena
            String[] apellidos = new String[participantes.length];
            for (int i = 0; i < participantes.length; i++){
                apellidos[i] = participantes[i].substring(0, participantes[i].indexOf(',')).toUpperCase();   
            }
            Arrays.sort(apellidos);
            
            // Cuenta y acumula las repeticiones de cada apellido
            boolean hermanosAnteriores = false;
            for (int i = 1; i < apellidos.length; i++) {
                String apellidosAnterior = apellidos[i - 1];
                String apellidosActual = apellidos[i];
                if (apellidosActual.equalsIgnoreCase(apellidosAnterior)) {
                    if (hermanosAnteriores)
                        contarHermanos++;
                    else
                        contarHermanos += 2;
                    hermanosAnteriores = true;
                } else {
                    hermanosAnteriores = false;
                }
            }
        }

        return contarHermanos;
    }    


    // TESTS JUNIT 5
    @Test
    void participantesHermanos_DeberiaRetornarCeroCuandoNoHayHermanos() {
        String[] participantes = {"Doe, John", "Smith, Alice", "Johnson, Bob"};
        Arrays.sort(participantes);
        int resultado = participantesHermanos(participantes);
        assertEquals(0, resultado);
    }

    @Test
    void participantesHermanos_DeberiaContarHermanosCorrectamente() {
        String[] participantes = {"Doe, John", "Smith, Alice", "Doe, Jane", "Johnson, Bob", "Doe, Jim"};
        Arrays.sort(participantes);
        int resultado = participantesHermanos(participantes);
        assertEquals(3, resultado);
    }

    @Test
    void participantesHermanos_DeberiaSerCaseInsensitive() {
        String[] participantes = {"Doe, John", "Smith, Alice", "doe, Jane", "johnson, Bob", "Doe, Jim"};
        Arrays.sort(participantes);
        int resultado = participantesHermanos(participantes);
        assertEquals(3, resultado);
    }

    @Test
    void participantesHermanosTest1() {
        String[] participantes = {
            "Núñez, Óscar",
            "López, Marta" ,
            "Álvarez, Javier" ,
            "López, Juan",
            "Núñez, Pablo",
            "Núñez, María"
            };
        Arrays.sort(participantes);
        int resultado = participantesHermanos(participantes);
        assertEquals(5, resultado);
    }
    
    @Test
    void participantesHermanosTest2() {
        String[] participantes = {
            "Méndez, Óscar",
            "López, Marta" ,
            "Álvarez, Javier" ,
            "López, Juan",
            "Núñez, Pablo",
            "Núñez, María"
            };        
            Arrays.sort(participantes);
        int resultado = participantesHermanos(participantes);
        assertEquals(4, resultado);
    }

    @Test
    void participantesHermanosTest3() {
        String[] participantes = {
            "Núñez, Óscar",
            "López, Marta" ,
            "Álvarez, Javier" ,
            "López, Juan",
            "Núñez, Pablo",
            "Méndez, María"
            };        
        Arrays.sort(participantes);
        int resultado = participantesHermanos(participantes);
        assertEquals(4, resultado);
    }

    @Test
    void participantesHermanosTest4() {
        String[] participantes = {
            "Núñez, Óscar",
            "López, Marta" ,
            "Álvarez, Javier" ,
            "Gómez, Juan",
            "Núñez, Pablo",
            "Núñez, María"
            };        
        Arrays.sort(participantes);
        int resultado = participantesHermanos(participantes);
        assertEquals(3, resultado);
    }

    @Test
    void participantesHermanosTest5() {
        String[] participantes = {
            "Núñez, Óscar",
            "Núñez, Marta" ,
            "Álvarez, Javier" ,
            "Núñez, Juan",
            "Núñez, Pablo",
            "Núñez, María"
            };        
        Arrays.sort(participantes);
        int resultado = participantesHermanos(participantes);
        assertEquals(5, resultado);
    }

    @Test
    void participantesHermanos_DeberiaManejarArrayVacio() {
        String[] participantes = {};
        int resultado = participantesHermanos(participantes);
        assertEquals(0, resultado);
    }    

}
