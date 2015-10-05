package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DAOs.AdministrateurDAO;
import models.DAOs.UtilisateurDAO;
import models.classes.Administrateur;
import models.classes.Utilisateur;

public class ProjectUserStory {
                // attribut(s) ou variable(s) globale(s)
        private String message;
        private static Utilisateur visiteur = new Utilisateur();
        
        public static void main(String[] args) {     
            // initialiser un utilisateur
            try {
                File unFichier = new File("TableUtilisateurs.txt");            
                PrintWriter pointeurVersFichier = new PrintWriter(unFichier);
                pointeurVersFichier.println("1 samnang suon admin");
                pointeurVersFichier.close();
                System.out.println("Le fichier « TableUtilisateurs.txt » a été créé.");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProjectUserStory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Scanner cin = new Scanner(System.in);        
            boolean isConnected = false;
            int choixMenu;
            System.out.println("*** B I E N V E N U E   A U   S I T E - THE GAME ***");
            do {                
                System.out.println("[1] S'authentifier");
                System.out.println("[2] S'inscrire");
                System.out.print("Veuillez saisir votre choix : ");
                choixMenu = cin.nextInt();
                clearConsole(5);
                switch( choixMenu ) {
                    case 1 :
                        isConnected = loginAction();
                        break;
                    case 2 :
                        signInAction();
                        clearConsole(5);
                        break;
                }
            } while(!isConnected);
            
// page d'accueil
            //visiteur = fabriqueSession();
            System.out.println("[1] Téléporter au PvE");
            System.out.println("[2] Téléporter au PvP");
            System.out.println("[3] Téléporter au Magasin");
            System.out.println("[4] Téléporter au Inventory");
            System.out.println("[5] Recherche un joueur");
            System.out.println("[6] Consulter LeaderBoard");
            System.out.println("[7] Gérer profile");
            System.out.println("[8] Envoyer un message publique");
            System.out.print("Votre choix : ");
            choixMenu = cin.nextInt();
            switch(choixMenu) {
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
        UtilisateurDAO temp = new UtilisateurDAO();
        boolean isFound = false;
        do {                        
            System.out.println("Statut actuel : " + visiteur.getStatut() );
            System.out.print("Nom utilisateur : ");
            nomUtilisateur = cin.nextLine();
            System.out.print("Mot de passe : ");
            motDePasse = cin.nextLine();      
            clearConsole(5);
            visiteur.setUsername(nomUtilisateur);// visiteur doit être STATIC !
            visiteur.setPassword(motDePasse);
            if( temp.find( visiteur ) ) {
                    System.out.println("BRAVO ! Vous êtes connecté !");
                    isFound = true;
                    System.out.println("Nouveau statut : " + visiteur.getStatut() );
            } else {
                System.out.println("Attention ! Il y a une erreur dans le username ou le password.");                            
            }
            clearConsole(5);
        } while( !isFound );        
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
    /*public static Utilisateur fabriqueSession() {
        UtilisateurDAO temp = new UtilisateurDAO();
        switch( temp.findStatut( visiteur ) ){
            case "player" :
                
                break;
            case "modo" :
                
                break;
            case "admin" :
                
                break;
        }
    }*/
}