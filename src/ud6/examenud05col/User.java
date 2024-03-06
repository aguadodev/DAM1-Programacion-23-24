package ud6.examenud05col;

public class User {

    private String username;
    private String password;

    /* Listado de usuarios válidos */
    private static User[] usuarios = {
            new User("aguado", "aguado"),
            new User("acainrodr", "acainrodr"),
            new User("mbarrpere", "mbarrpere"),
            new User("avegavida", "avegavida"),
            new User("aameneste", "aameneste"),
            new User("bcastextr", "bcastextr"),
            new User("dperesert", "dperesert"),
            new User("dsancpeso", "dsancpeso"),
            new User("dpazoargi", "dpazoargi"),
            new User("erodapere", "erodapere"),
            new User("grodragui", "grodragui"),
            new User("agutivill", "agutivill"),
            new User("hmartfern", "hmartfern"),
            new User("jigleacun", "jigleacun"),
            new User("mcostcruz", "mcostcruz"),
            new User("cfuenbesa", "cfuenbesa"),
            new User("mpiedsant", "mpiedsant"),
            new User("pucedcorn", "pucedcorn"),
            new User("nrosalemo", "nrosalemo"),
            new User("ofernpast", "ofernpast"),
            new User("operdbarr", "operdbarr"),
            new User("apazoamoe", "apazoamoe"),
            new User("plealfern", "plealfern"),
            new User("rpazobarc", "rpazobarc"),
            new User("vruagome", "vruagome"),
            new User("jiglesamp", "jiglesamp"),
            new User("dsobrpine", "dsobrpine"),
            new User("svilapere", "svilapere"),
            new User("igarcrodr", "igarcrodr"),
            new User("salvafont", "salvafont")
    };

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this(username, null);
    }

    @Override
    public String toString() {
        return username;
    }

    /**
     * Dos objetos User se consideran iguales si tienen el mismo username.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    /*
     * Getters y Setters
     */
    public String getUsername() {
        return username;
    }

    /**
     * Obtiene los datos de un usuario válido a partir de su nombre de usuario y contraseña
     * 
     * @param username
     * @param password
     * @return Si el usuario y la contraseña son válidos devuelve el objeto User correspondiente. En otro caso devuelve null.
     */
    public static User loginUsuario(String username, String password) {
        User user = null;
        if (username != null && password != null) {
            // Buscar en el array de usuarios
            for (User u : usuarios) {
                if (u.username.equals(username) && u.password.equals(password)) {
                    return u;
                }
            }
        }
        return user;
    }

}
