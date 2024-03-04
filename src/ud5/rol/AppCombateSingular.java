package ud5.rol;

import java.util.Scanner;

import ud5.rol.Personaje.Raza;

public class AppCombateSingular {
    public static void main(String[] args) {
        System.out.println("JUEGO DE ROL: Combate singular");

        // Se crean y muestran las fichas de los personajes
        Personaje pj1 = new Personaje("Aragorn");
        Personaje pj2 = new Personaje("Legolas", Raza.ELFO);

        System.out.println("CONTENDIENTES: ");
        System.out.println();
        pj1.mostrar();
        pj2.mostrar();

        // Se decide el primer turno según la agilidad
        boolean turnoPj1;
        if (pj1.agilidad > pj2.agilidad)
            turnoPj1 = true;
        else if (pj1.agilidad < pj2.agilidad)
            turnoPj1 = false;
        else // Si tienen la misma agilidad se decide el primer turno aleatoriamente
            turnoPj1 = Math.random() > 0.5;

        System.out.println("Empieza atacando " + (turnoPj1 ? pj1 : pj2) + "\n");

        System.out.println("Pulsa [ENTER] para empezar el combate");
        new Scanner(System.in).nextLine();

        // Los personajes se atacan alternativamente mientras ambos sigan vivos
        do {
            if (turnoPj1)
                ataque(pj1, pj2);
            else
                ataque(pj2, pj1);
            // Cambia el turno
            turnoPj1 = !turnoPj1;
        } while (pj1.estaVivo() && pj2.estaVivo());

        // Muestra el ganador
        System.out.print("\nVENCEDOR/A: ");
        if (pj1.estaVivo())
            System.out.println(pj1);
        else
            System.out.println(pj2);
    }

    private static void ataque(Personaje pj1, Personaje pj2) {
        System.out.print(pj1 + " ataca a " + pj2);
        int danho = pj1.atacar(pj2);
        if (danho > 0)
            System.out.println(" => " + pj2 + " pierde " + danho + " PV");
        else
            System.out.println(" => " + pj2 + " esquiva o para el ataque");
    }

}
