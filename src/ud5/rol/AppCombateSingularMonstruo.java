package ud5.rol;

import java.util.Scanner;

public class AppCombateSingularMonstruo {
    public static void main(String[] args) {
        System.out.println("JUEGO DE ROL: Combate singular con un monstruo");

        // Se crean y muestran las fichas de los personajes
        Personaje pj1 = new Personaje("Aragorn");
        //Monstruo monstruo = new Monstruo("GRRR", 70, 60, 50, 40);
        Monstruo monstruo = Monstruo.generaMonstruoAleatorio();

        System.out.println("CONTENDIENTES: ");
        System.out.println();
        pj1.mostrar();
        monstruo.mostrar();

        // Se decide el primer turno según la agilidad
        boolean turnoPj1; 
        if (pj1.agilidad > monstruo.defensa)
            turnoPj1 = true;
        else if (pj1.agilidad < monstruo.defensa)
            turnoPj1 = false;
        else // Si agilidad y velocidad coinciden se decide el primer turno aleatoriamente
            turnoPj1 = Math.random() > 0.5;

        System.out.println("Empieza atacando " + (turnoPj1 ? pj1 : monstruo) + "\n");

        System.out.println("Pulsa [ENTER] para empezar el combate");
        new Scanner(System.in).nextLine();

        // Los personajes se atacan alternativamente mientras ambos sigan vivos
        do {
            if (turnoPj1){
                System.out.print(pj1 + " ataca a " + monstruo);
                int danho = pj1.atacar(monstruo);
                if (danho > 0)
                    System.out.println(" => " + monstruo + " pierde " + danho + " PV");
                else
                    System.out.println(" => " + monstruo + " esquiva o para el ataque");
            }                
            else {
                System.out.print(monstruo + " ataca a " + pj1);
                int danho = monstruo.atacar(pj1);

                if (danho > 0)
                    System.out.println(" => " + pj1 + " pierde PV");
                else
                    System.out.println(" => " + pj1 + " esquiva o para el ataque");
            }
            turnoPj1 = !turnoPj1;
        } while(pj1.estaVivo() && monstruo.estaVivo());

        // Muestra el ganador
        System.out.print("\nVENCEDOR/A: ");
        if(pj1.estaVivo())
            System.out.println(pj1);
        else
            System.out.println(monstruo);
    }
}
