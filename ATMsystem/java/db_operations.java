/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edson Casimiro
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;

class db_par {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Connection con = null;
    private int currentUser=0;
   

    public db_par(int x) throws Exception {
        this.currentUser = x;
        try {
            //this.currentUser = x;

            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby://localhost:1527/banhatm", "edsoncasimiro", "javadb" );
            PreparedStatement statement = connect
                    .prepareStatement("SELECT * from KULLANICI");
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while(rs.next()){
                System.out.println("edson casimiro");
                System.out.println(rs.getString("NAME"));
            }

            
        } catch (Exception e) {
            throw e;
        } finally {
            //close();
        }

    }
    
  
    
    public void assignUser(int i){
        this.currentUser = i;
    }
    public int getUser(){
        return currentUser;
    }
    
    
    
    
    
    public boolean logUser(String s) throws SQLException{
        
        PreparedStatement statement = connect
                    .prepareStatement(s);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            if(rs.next()){
                currentUser = rs.getInt("KIMLIK");
                return true;
            }
               
                
                /*System.out.println("Geting something");
                System.out.println(rs.getString("NAME"));*/
            
        
        return false;
    } 
    
        /*public int getKimlik(String s) throws SQLException{
        int userKimlik=0;
        PreparedStatement statement = connect
                    .prepareStatement(s);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            if(rs.next()){
               userKimlik = rs.getInt("KIMLIK");
                
            }

                /*System.out.println("Geting something");
                System.out.println(rs.getString("NAME"));/
            
        
        return userKimlik;
    } */
    
    
    
    public void insert(String s) throws SQLException{
        PreparedStatement statement = connect
                    .prepareStatement(s);
            statement.execute();
            //ResultSet rs = statement.getResultSet();

                /*System.out.println("Geting something");
                System.out.println(rs.getString("NAME"));*/

    }
    
    
    public String GetSomething(String s, String t) throws SQLException{
        String tt="";
        PreparedStatement statement = connect
                    .prepareStatement(s);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            if(rs.next()){
                System.out.println("Geting something");
                System.out.println(rs.getString(t));
                tt= rs.getString(t);
            }
            
        
        return tt;
    } 
    
    }