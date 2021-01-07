/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edson Casimiro
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;


class DerbyTest {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    DerbyTest() throws Exception {
        try {

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

    /*private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }*/
    }


public class dbconection{

    public static void main(String[] args) throws Exception {
        DerbyTest db = new DerbyTest();
         
    }

}

