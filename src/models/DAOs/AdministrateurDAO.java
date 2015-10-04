package models.DAOs;

import java.io.File;
import java.io.IOException;
import models.classes.Administrateur;// correspond aux « include() » de PHP
import models.classes.TableAdministrateur;

public class AdministrateurDAO {
    public static boolean create(Administrateur a) {
        
        return true;
    }
    public static boolean find(Administrateur record) {
        TableAdministrateur temp = new TableAdministrateur();
        for(int i=0; i < temp.getListeDesAdministrateurs().size(); i++) {
            //if(temp.getListeDesAdministrateurs().get(i).equals(record))
            if( temp.getListeDesAdministrateurs().get(i).getUsername().equalsIgnoreCase(record.getUsername()) &&
                temp.getListeDesAdministrateurs().get(i).getPassword().equalsIgnoreCase(record.getPassword()) )
                return true;
        }
        return false;
    }
    public static boolean createFile() {
        try{
             File file = new File("TableAdministrateur.txt");
             if(file.createNewFile()) {
                System.out.println("Success!");
                return true;
             } else {
                System.out.println("Error, file already exists.");
                return false;
             }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return false;
    }
}
