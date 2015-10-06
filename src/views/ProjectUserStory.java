package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DAOs.MySQL;
import models.DAOs.UtilisateurDAO;
import models.classes.Utilisateur;

public class ProjectUserStory {
                // attribut(s) ou variable(s) globale(s)
        private String message;
        private static Utilisateur visiteur = new Utilisateur();
        private static Scanner cin = new Scanner(System.in);
        
        public static void main(String[] args) {     
            // test de l'utilisation d'une BD MySQL        
            System.out.println("Je suis en train de tester la BD « Projet » de PhpMyAdmin...");
            MySQL test = new MySQL();
            clearConsole(5);
            // initialiser un utilisateur pour TEST                       
            /*try {
                File unFichier = new File("TableUtilisateurs.txt");            
                PrintWriter pointeurVersFichier = new PrintWriter(unFichier);
                pointeurVersFichier.println("1 alex caumartin admin");
                pointeurVersFichier.println("2 maxime morin admin");
                pointeurVersFichier.println("3 nicolas blier admin");
                pointeurVersFichier.println("4 samnang suon admin");
                pointeurVersFichier.println("5 weird bizarre ban");
                pointeurVersFichier.close();
                System.out.println("Le fichier « TableUtilisateurs.txt » a été créé.");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProjectUserStory.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            // Nous n'avons plus besoin du code ci-haut, car la connexion à la BD fonctionne ! (Samnang)   
            
            boolean isConnected = false;
            int choixMenu;
            System.out.println("*** B I E N V E N U E   A U   S I T E - THE GAME ***");
            do {                
                System.out.println("[1] S'authentifier");
                System.out.println("[2] S'inscrire");
                System.out.println("[3] Mot de passe oublié");
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
                    case 3 :
                        passwordForgotAction();
                        break;
                }
            } while(!isConnected);
            
// page d'accueil selon le « statut » de la personne connectée
            switch( visiteur.getStatut() ) {
                case "player" :
                    redirectPageJoueur();
                    break;
                case "modo" :
                    redirectPageModerateur();
                    break;
                case "admin" :
                    redirectPageAdministrateur();
                    break;
            }            
    }
// listes des actions de base    
    public static boolean loginAction() {
        String nomUtilisateur;
        String motDePasse;        
        UtilisateurDAO temp = new UtilisateurDAO();
        boolean isFound = false;
        do {                        
            //System.out.println("Statut actuel : " + visiteur.getStatut() );
            System.out.print("Nom utilisateur : ");
            nomUtilisateur = cin.next();
            System.out.print("Mot de passe : ");
            motDePasse = cin.next();      
            clearConsole(5);
            visiteur.setUsername(nomUtilisateur);// visiteur doit être STATIC !
            visiteur.setPassword(motDePasse);
            if( temp.find( visiteur ) ) {
                    if( visiteur.getStatut().equalsIgnoreCase("ban") ) {
                        System.out.println("*** Message des administrateurs ***");
                        System.out.println("Attention ! Votre compte a été banni.");                        
                        System.out.println("Vous devez attendre 24h avant de pouvoir vous connecter.");                        
                    } else {
                        System.out.println("BRAVO ! Vous êtes connecté !");
                        isFound = true;
                        System.out.println("Nouveau statut : " + visiteur.getStatut() );
                    }
            } else {
                System.out.println("Attention ! Il y a une erreur dans le username ou le password.");                            
            }
            clearConsole(5);
        } while( !isFound );        
        return true;
    }
    public static boolean signInAction() {        
        System.out.print("Veuillez saisir un nom d'utilisateur : ");
        String username = cin.next();
        System.out.print("Veuillez saisir un mot de passe : ");
        String password = cin.next();
        System.out.print("Veuillez saisir votre email : ");
        String email = cin.next();
        System.out.println("Un message de confirmation a été envoyé à " + email);
        return true;
    }
    public static boolean passwordForgot() {
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
            
            /*** Les différentes pages selon le « statut » de la personne connectée ***/
// Section pour les joueurs
    public static void redirectPageJoueur() {        
        System.out.println("[1] Téléporter au PvE");
        System.out.println("[2] Téléporter au PvP");
        System.out.println("[3] Téléporter au Magasin");
        System.out.println("[4] Téléporter au Inventory");
        System.out.println("[5] Recherche un joueur");
        System.out.println("[6] Consulter LeaderBoard");
        System.out.println("[7] Gérer profile");
        System.out.println("[8] Envoyer un message publique");
        System.out.print("Votre choix : ");
        int choixMenu = cin.nextInt();
        switch(choixMenu) {
            case 1 : 
                pveAction();
                break;
            case 2 :
                pvpAction();
                break;
            case 3 :
                magasinAction();
                break;
            case 4 :
                inventoryAction();
                break;
            case 5 :
                searchPlayerAction();
                break;
            case 6 :
                showLeaderBoardAction();
                break;
            case 7 :

                break;               
            case 8 :

                break;
        }
    }
    public static boolean pveAction() {
        
        return true;
    }
    public static boolean pvpAction() {
    
        return true;
    }
// DÉBUT DE MAGASIN
    public static boolean magasinAction() {
        System.out.println("*** B I E N V E N U E    A U    M A G A S I N ***");
        System.out.println("[1] Acheter un casque");
        System.out.println("[2] Acheter un bras droit");
        System.out.println("[3] Acheter un bras gauche");
        System.out.println("[4] Acheter une chenille");
        System.out.println("Veuillez saisir votre choix : ");
        int choix = cin.nextInt();
        switch( choix ) {
            case 1 :
                requestHelmetAction();
                break;
            case 2 :
                
                break;
            case 3 :
                
                break;
            case 4 :
                
                break;
        }
        return true;        
    }
    public static boolean requestHelmetAction() {
            //HelmetDAO temp = new HelmetDAO();
            return true;
        }
// FIN DE MAGASIN    
    public static boolean inventoryAction() {
        return true;
    }
    public static boolean searchPlayerAction() {
        System.out.println("Veuillez saisir le nom du joueur à trouver: ");
        String nomJoueur = cin.next();
        return true;
    }
    public static boolean showLeaderBoardAction() {
        return true;
    }
// Section pour les modérateurs
    public static void redirectPageModerateur() {
        System.out.println("[1] Appliquer une sourdine");
        System.out.println("[2] Enlever une sourdine");
        System.out.println("Veuillez saisir votre choix : ");
        int choix = cin.nextInt();
        switch( choix ) {
            case 1 :
                
                break;
            case 2 :
                
                break;
        }
    }    
// Section pour les administrateurs
    public static void redirectPageAdministrateur() {
        System.out.println("[1] Gérer le compte d'un joueur");
        System.out.println("[2] Gérer un Event");
        System.out.println("[3] Consulter les statistiques");
        System.out.println("Veuillez saisir votre choix : ");
        int choix = cin.nextInt();
        switch( choix ) {
            case 1 :
                gererCompteJoueur();
                break;
            case 2 :
                gererEvent();
                break;
            case 3 :    
                consulterStatistiques();
                break;
        }
    }
    public static void gererCompteJoueur() {
        System.out.println("[1] Bannir le compte d'un joueur");
        System.out.println("[2] Réactiver le compte d'un joueur");
        System.out.print("Veuillez saisir votre choix : ");
        int choix = cin.nextInt();
        switch( choix ) {
            case 1 :
                
                break;
            case 2 :
                
                break;
        }
    }
    public static void gererEvent() {
        
    }
    public static void consulterStatistiques() {
        
    }
}