
package nita.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//
/**
 *
 * @author Ritika Sahay
 */
public class LoginAuthentication {
    String n;
    String p;


    private PreparedStatement ps;
private ResultSet rs;
private Connection c;


public boolean aut_ad(String u_name,String pass)
{
    try{
    c = new CommonDB().getConnection();
    PreparedStatement ps=(PreparedStatement)c.prepareStatement("select admin_pass,admin_name  from administrator_master where admin_name= '"+ u_name +"' and  admin_pass= '"+ pass +"' ");
    ResultSet r = ps.executeQuery();
  if(!r.next() && r.getRow() == 0) {

return false;}
else
    return true;
    }
    catch(Exception e)
    {
    e.printStackTrace();
    System.out.println("here is the problem");
    return false;


    }
}



public boolean aut_clr(String u_name,String pass)
{
    try{
    c = new CommonDB().getConnection();
    PreparedStatement ps=(PreparedStatement)c.prepareStatement("select clr_pass,clr_name  from clerk_master where clr_name= '"+ u_name +"' and  clr_pass= '"+ pass +"' and clr_valid='Y'");
    ResultSet r = ps.executeQuery();
  if(!r.next() && r.getRow() == 0) {

return false;}
else
    return true;
    }
    catch(Exception e)
    {
    e.printStackTrace();
    System.out.println("here is the problem");
    return false;


    }
}


public boolean aut_stu(String u_roll,String pass)
{
    try{
    c = new CommonDB().getConnection();
    PreparedStatement ps=(PreparedStatement)c.prepareStatement("select st_password,st_roll  from student_master where st_roll= '"+ u_roll +"' and  st_password= '"+ pass +"' and st_valid='Y'");
    ResultSet r = ps.executeQuery();
  if(!r.next() && r.getRow() == 0) {

return false;}
else
    return true;
    }
    catch(Exception e)
    {
    e.printStackTrace();
    System.out.println("here is the problem");
    return false;


    }
}


public boolean auth_fac(String u_name,String pass){
try{
    c = new CommonDB().getConnection();
    PreparedStatement ps=(PreparedStatement)c.prepareStatement("select fac_password,fac_name  from faculty_master where fac_name= '"+ u_name +"' and  fac_password= '"+ pass +"' and fac_valid='Y'");
    ResultSet r = ps.executeQuery();
  if(!r.next() && r.getRow() == 0) {

return false;}
else
    return true;
    }
    catch(Exception e)
    {
    e.printStackTrace();
    System.out.println("here is the problem");
    return false;


    }

}


}
