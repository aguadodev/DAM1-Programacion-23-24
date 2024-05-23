package ud8.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AppJPA {

    public static void main(String[] args) {
        // Este código cargará la unidad de persistencia ubicade en src/META-INF
        // conectará con la base de datos remota y, si no existe,
        // creará el esquema definido por las clases persistentes.
        // Creará la tabla Persona mapeada con la clase Persona.
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        EntityManager em;
        em = emf.createEntityManager();

        
    }
}
