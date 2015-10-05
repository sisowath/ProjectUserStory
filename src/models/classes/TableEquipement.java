package models.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableEquipement {
            // attribut(s)
    private ArrayList<Equipement> listeDesEquipements = new ArrayList<Equipement>();
            // methode(s)
    // constructeur(s)
    public TableEquipement() {
        File maTable = new File("TableEquipements.txt");
        if(maTable.exists()) {
            try {
                Scanner pointeurVersTable = new Scanner(maTable);
                while( pointeurVersTable.hasNext() ) {
                    int id = Integer.parseInt( pointeurVersTable.next() );
                    String type = pointeurVersTable.next();
                    int tier = Integer.parseInt( pointeurVersTable.next() );
                    int level = Integer.parseInt( pointeurVersTable.next() );
                    int hp = Integer.parseInt( pointeurVersTable.next() );
                    int exp = Integer.parseInt( pointeurVersTable.next() );
                    String element = pointeurVersTable.next();
                    String typeRarete = pointeurVersTable.next();
                    listeDesEquipements.add( new Equipement(id, type, tier, level, hp, exp, element, typeRarete ) );
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TableUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("ERREUR ! Le fichier « TableUtilisateurs.txt » est introuvale.");
        }
    }
    // accesseur(s)
    public ArrayList<Equipement> getListeDesEquipements() {
        return this.listeDesEquipements;
    }
}
