package models.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableUtilisateur {
        // attribut(s)
    ArrayList<Utilisateur> listeDesUtilisateurs = new ArrayList<Utilisateur>();
        // methode(s)
    // constructeur()
    public TableUtilisateur() {
        File maTable = new File("TableUtilisateurs.txt");
        if(maTable.exists()) {
            try {
                Scanner pointeurVersTable = new Scanner(maTable);
                while( pointeurVersTable.hasNext() ) {
                    int id = Integer.parseInt( pointeurVersTable.next() );
                    String username = pointeurVersTable.next();
                    String password = pointeurVersTable.next();
                    String statut = pointeurVersTable.next();
                    listeDesUtilisateurs.add( new Utilisateur(id, username, password, statut) );
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TableUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("ERREUR ! Le fichier « TableUtilisateurs.txt » est introuvale.");
        }
    }
    // accesseur(s)
    public ArrayList<Utilisateur> getListeDesUtilisateurs() {
        return this.listeDesUtilisateurs;
    }
    // mutateur(s)
    
    // autre(s)
}
