package models.DAOs;

import models.classes.Administrateur;
import models.classes.TableUtilisateur;
import models.classes.Utilisateur;

public class UtilisateurDAO {
    public static boolean find(Utilisateur u) {
        TableUtilisateur temp = new TableUtilisateur();
        for(int i=0; i < temp.getListeDesUtilisateurs().size(); i++)
            if( u.getUsername().equalsIgnoreCase( temp.getListeDesUtilisateurs().get(i).getUsername() ) &&
                u.getPassword().equalsIgnoreCase( temp.getListeDesUtilisateurs().get(i).getPassword() ) ) {                
                return true;
            }                
        return false;
    }
    public static String findStatut(Utilisateur u) {
        TableUtilisateur temp = new TableUtilisateur();
        for(int i=0; i < temp.getListeDesUtilisateurs().size(); i++)
            if( u.getUsername().equalsIgnoreCase( temp.getListeDesUtilisateurs().get(i).getUsername() ) &&
                u.getPassword().equalsIgnoreCase( temp.getListeDesUtilisateurs().get(i).getPassword() ) ) 
                return temp.getListeDesUtilisateurs().get(i).getStatut();
        return null;
    }
}
