package models.classes;

public class Utilisateur {
        // attribut(s)
    private int id;
    private String username;
    private String password;
    private String statut; 
        //methode(s)
    // constructeur(s)
    public Utilisateur() {
        this(1, "NoUsername", "NoPassword", "NoStatut");
    }
    public Utilisateur(String username, String password) {
        this(1, username, password, "none");
    }
    public Utilisateur(int id, String username, String password, String statut) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.statut = statut;
    }
    // accesseur(s)
    public int getId() {
        return this.id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getStatut() {
        return this.statut;
    }
    // mutateur(s)
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
    // autre(s)    
    
}
