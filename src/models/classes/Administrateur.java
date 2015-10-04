package models.classes;

public class Administrateur {
            // attribut(s)
    private int id;
    private String username;
    private String password;
    private String email;
            // methode(s)
    // constructeur(s)
    public Administrateur() {
        this(1, "username", "password", "test@email.com");
    }       
    public Administrateur(String username, String password) {
        this(1, username, password, "test@email.com");
    }
    public Administrateur(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }    
    // accesseur(s)
    public int getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getEmail() {
        return this.email;
    }
    // mutateur(s)
    public boolean setId(int id) {
        this.id = id;
        return true;
    }
    public boolean setUsername(String username) {
        this.username = username;
        return true;
    }
    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }
    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }
    // autre(s)
    public String toString() {
        return "[" + this.id + ":" + this.username + ":" + this.password + ":" + this.email + "]";
    }
    public boolean equal(Administrateur x) {
        return  this.id == x.getId() &&
                this.username.equalsIgnoreCase(x.getUsername()) &&
                this.password.equalsIgnoreCase(x.getPassword()) &&
                this.email.equalsIgnoreCase(x.getEmail());
    }
}