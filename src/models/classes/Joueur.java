package models.classes;

public class Joueur extends Utilisateur {
            // attribut(s)
    /*private int id;
    private String username;
    private String password;
    private String email;*/
    private boolean isActive;
    private String image;
    private String description;
    private int ferraille;
    private int prestige;
            // methode(s)    
    // constructeur(s)
    public Joueur(  int id, String username, String password, String email, boolean isActive, 
                    String image, String description, int ferraille, int prestige) {
       /* this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;*/
        super(id, username, password, email);
        this.isActive = isActive;
        this.image = image;
        this.description = description;
        this.ferraille = ferraille;
        this.prestige = prestige;
    }
    // accesseur(s)
    /*
       public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }*/
    public boolean isIsActive() {
        return isActive;
    }
    public String getImage() {
        return image;
    }
    public String getDescription() {
        return description;
    }
    public int getFerraille() {
        return ferraille;
    }
    public int getPrestige() {
        return prestige;
    }
    // mutateur(s)
    /*public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }*/
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setFerraille(int ferraille) {
        this.ferraille = ferraille;
    }
    public void setPrestige(int prestige) {
        this.prestige = prestige;
    }
    // autre(s)
    
}
