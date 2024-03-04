package ud5.rol;
import java.util.Scanner;

import ud5.rol.Personaje.Raza;

public class AppCreaPersonaje {
    public static void main(String[] args) throws Exception {
        System.out.println("JUEGO DE ROL: Creación de Personaje");

        Personaje p = Util.importarJson();
        if (p != null) {
            System.out.println("Personaje cargado actualmente:");
            p.mostrar();
        }   
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Cómo quieres crear el personaje? ");
        System.out.println("1.- Indicar sólo el nombre");
        System.out.println("2.- Indicar el nombre y la raza");
        System.out.println("3.- Indicar el nombre, la raza y los atributos físicos");
        System.out.println("4.- Indicar todos los atributos");
        int opcion = sc.nextInt();
        sc.nextLine(); // captura el [ENTER] de la entrada anterior

        Personaje personaje;

        switch (opcion){
            case 1: /*.. */             
                break;
            case 2: 
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();        
        
                System.out.println("Raza: ");
                String raza = sc.nextLine();
                        
                try {
                   personaje = new Personaje(nombre, Raza.valueOf(raza));
                   // Mostrar el personaje
                   personaje.mostrar();
                   System.out.println(personaje);
                   Util.exportarJson(personaje);
                   
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }            
                break;
            case 3: /*.. */ 
                break;
            case 4: /*.. */ 
                break;
        }


        


        // Opcional: guardar en fichero de texto JSON.



        
        //Personaje aragorn = new Personaje("Aragorn", "fassadad", 98, 87, 67,15, 15785, 150);

    }
}
