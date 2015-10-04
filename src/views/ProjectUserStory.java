package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DAOs.AdministrateurDAO;
import models.classes.Administrateur;
import models.classes.TableAdministrateur;

public class ProjectUserStory {

    public static void main(String[] args) {     
            // initialiser un administrateur
            File unFichier = new File("TableAdministrateurs.txt");
            try {
                PrintWriter pointeurVersFichier = new PrintWriter(unFichier);
                pointeurVersFichier.println("1 samnang suon samnang@test.com");
                pointeurVersFichier.close();
                System.out.println("Le fichier « TableAdministrateurs.txt » a été créé.");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProjectUserStory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Scanner cin = new Scanner(System.in);        
            boolean isConnected = false;
            int choix;
            System.out.println("*** B I E N V E N U E   A U   S I T E - THE GAME ***");
            do {                
                System.out.println("[1] S'authentifier");
                System.out.println("[2] S'inscrire");
                System.out.print("Veuillez saisir votre choix : ");
                choix = cin.nextInt();
                switch( choix ) {
                    case 1 :
                        isConnected = loginAction();
                        break;
                    case 2 :
                        signInAction();
                        break;
                }
            } while(!isConnected);
            
// Menu Principal            
            clearConsole();
            System.out.println("[1] Téléporter au PvE");
            System.out.println("[2] Téléporter au PvP");
            System.out.println("[3] Téléporter au Magasin");
            System.out.println("[4] Téléporter au Inventory");
            System.out.println("[5] Recherche un joueur");
            System.out.println("[6] Consulter LeaderBoard");
            System.out.println("[7] Gérer profile");
            System.out.println("[8] Envoyer un message publique");
            System.out.print("Votre choix : ");
            choix = cin.nextInt();
            switch(choix) {
                case 1 : 
                    pveAction();
                    break;
                case 2 :
                    pvpAction();
                    break;
                case 3 :
                    
                    break;
                    
                case 4 :
                    
                    break;
                case 5 :
                    
                    break;
                case 6 :
                    
                    break;
                case 7 :
                    
                    break;               
                case 8 :
                    
                    break;
            }
    }
// listes des actions possibles    
    public static boolean loginAction() {
        Scanner cin = new Scanner(System.in);
        String nomUtilisateur;
        String motDePasse;        
        AdministrateurDAO temp = new AdministrateurDAO();
        do {
            clearConsole();
            System.out.print("Nom utilisateur : ");
            nomUtilisateur = cin.nextLine();
            System.out.print("Mot de passe : ");
            motDePasse = cin.nextLine();            
        } while( !temp.find(new Administrateur(nomUtilisateur, motDePasse) ) );
            //System.out.println("Vous êtes connecté !");  
            return true;
    }
    public static boolean signInAction() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Veuillez saisir un nom d'utilisateur : ");
        String username = cin.next();
        System.out.print("Veuillez saisir un mot de passe : ");
        String password = cin.next();
        System.out.print("Veuillez saisir votre email : ");
        String email = cin.next();
        System.out.println("Un message de confirmation a été envoyé à " + email);
        return true;
    }
    public static boolean pveAction() {
        
        return true;
    }
    public static boolean pvpAction() {
        return true;
    }
// Autre(s)    
    public static void clearConsole() {
        clearConsole(50);
    }
    public static void clearConsole(int x) {
        for(int i=0; i < x; i++)
            System.out.println();
    }
}