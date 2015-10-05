package models.classes;

public class Equipement {
        // attribut(s)
    private int id;
    private String type;
    private int tier;
    private int level;
    private int hp;   
    private int exp;
    private String element;
    private String typeRarete;// WHAT IF THIS ?? de : Samnang
        // methode(s)
    // constructeur(s)
    public Equipement(int id, String type, int tier, int level, int hp, int exp, String element, String typeRarete) {
        this.id = id;
        this.type = type;
        this.tier = tier;
        this.level = level;
        this.hp = hp;
        this.exp = exp;
        this.element = element;
        this.typeRarete = typeRarete;
    }
    // accesseur(s)
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public int getTier() {
        return tier;
    }
    public int getLevel() {
        return level;
    }
    public int getHp() {
        return hp;
    }
    public int getExp() {
        return exp;
    }
    public String getElement() {
        return element;
    }
    public String getTypeRarete() {
        return typeRarete;
    }
    // mutateur(s)
    public void setId(int id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setTier(int tier) {
        this.tier = tier;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public void setElement(String element) {
        this.element = element;
    }
    public void setTypeRarete(String typeRarete) {
        this.typeRarete = typeRarete;
    }
    // autre(s)        
}
