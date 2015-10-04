package models.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TableAdministrateur {
        // attribut(s)
    private ArrayList<Administrateur> listeDesAdministrateurs = new ArrayList<Administrateur>();
        // methode(s)
    // constructeur(s)
    public TableAdministrateur() {
        try {
            File maTable = new File("TableAdministrateurs.txt");
            if(maTable.exists()) {
                try (Scanner pointeurVersTable = new Scanner(maTable)) {
                    Administrateur temp = new Administrateur();
                    while(pointeurVersTable.hasNext()) {
                        temp.setId( Integer.parseInt(pointeurVersTable.next()) );
                        //System.out.println( temp.getId() );
                        temp.setUsername( pointeurVersTable.next() );
                        //System.out.println( temp.getUsername());
                        temp.setPassword( pointeurVersTable.next() );
                        //System.out.println( temp.getPassword() );
                        temp.setEmail( pointeurVersTable.next() );
                        //System.out.println( temp.getEmail() );
                        listeDesAdministrateurs.add(temp);
                    }
                }
            } else {
                System.out.println("ERREUR ! Le fichier 'TableAdministrateurs.txt' est introuvable.");
            }
        } catch(FileNotFoundException e) {
            
        }
    }
    // accesseur(s)
    public ArrayList<Administrateur> getListeDesAdministrateurs() {
        return this.listeDesAdministrateurs;
    }
    // mutateur(s)
    
    // autre(s)
}
