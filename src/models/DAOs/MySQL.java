package models.DAOs;

import java.sql.*;

// source de : http://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
public class MySQL {
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/projet";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";// Dans le cas UwAmp
   
    public MySQL() {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, username, password, statut FROM utilisateur";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String statut = rs.getString("statut");

                //Display values
                //System.out.println("Voici les instances que j'ai trouvé :");
                System.out.println("\nid = " + id);
                System.out.println("username = " + username);
                System.out.println("password = " + password);
                System.out.println("statut = " + statut);
                System.out.println();// espacement
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
    }//end MySQL
}