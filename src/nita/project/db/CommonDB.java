/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Anil Bhaskar
 */
public class CommonDB {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection c;

    public Connection getConnection()
    {
    try{
    Class.forName("com.mysql.jdbc.Driver");
    return DriverManager.getConnection("jdbc:mysql://localhost:3310/library_beta","root","admin");
    }
    catch(Exception e)
    {
    e.printStackTrace();
    return null;
    }
    }
}
