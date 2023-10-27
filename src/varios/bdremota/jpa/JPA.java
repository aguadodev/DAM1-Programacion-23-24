package varios.bdremota.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPA {

    public static void main(String[] args) {
        // Este código cargará la unidad de persistencia, conectará con la base de datos remota y
        // creará, si no existe, el esquema definido por las clases persistentes, es decir,
        // Creará la tabla Persona mapeada con la clase Persona.
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        EntityManager em;
        em = emf.createEntityManager();              
    }    
}
