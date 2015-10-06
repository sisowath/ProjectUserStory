package models.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.classes.Administrateur;
import models.classes.TableUtilisateur;
import models.classes.Utilisateur;

public class UtilisateurDAO {
    public static boolean find(Utilisateur u) {
        TableUtilisateur temp = new TableUtilisateur();
        for(int i=0; i < temp.getListeDesUtilisateurs().size(); i++)
            if( u.getUsername().equalsIgnoreCase( temp.getListeDesUtilisateurs().get(i).getUsername() ) &&
                u.getPassword().equalsIgnoreCase( temp.getListeDesUtilisateurs().get(i).getPassword() ) ) {                
                u.setStatut( temp.getListeDesUtilisateurs().get(i).getStatut() );
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
    public static boolean findEmail(String emailRecu) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost/projectuserstory";
        String USER = "root";
        String PASS = "root";// Dans le cas UwAmp
        Connection conn = null;
        Statement stmt = null;
        boolean isFound = false;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT email FROM utilisateur";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                if( rs.getString("email").equalsIgnoreCase(emailRecu) ) {
                    isFound = true;
                    System.out.println("BRAVO ! Votre email existe.");
                    break;
                }
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                stmt.close();
            }catch(SQLException se2){

            }// nothing we can do
            try{
                if(conn!=null)
                conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Fin des instances de la table « utilisateur »");
        return isFound;
    }
}