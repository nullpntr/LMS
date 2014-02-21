
package nita.project.db;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.util.ArrayList;
import nita.project.objects.Author;
import nita.project.objects.Branch;

/**
 *
 * @author Ritika Sahay
 */
public class RecoverPass {
    private PreparedStatement ps;
private ResultSet rs;
private PreparedStatement pm;
private Connection c;

public String rec_p_ad(String s){
    try{
    c=(Connection) new CommonDB().getConnection();
    PreparedStatement smt= (PreparedStatement) c.prepareStatement("select sec_ques from administrator_master where admin_name='"+s+"'");
    ResultSet rs=smt.executeQuery();
   
   // System.out.print(q+"");
    if(!rs.next() && rs.getRow() == 0) {

return "no string found here";}
else{
     String q=rs.getString("sec_ques");
    return q;
}
    }
    catch(Exception e){
    return "no string found";
    }
}


public boolean auth_ad(String u,String q,String a)
{

    try{
         c=(Connection) new CommonDB().getConnection();
         PreparedStatement smt=(PreparedStatement) c.prepareStatement("select admin_name, sec_ques, sec_ans from administrator_master where admin_name='"+u+"' and sec_ques='"+q+"' and sec_ans='"+a+"'");
          ResultSet r = smt.executeQuery();
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


public boolean update_ad(String n,String p)
{
   c =(Connection) new CommonDB().getConnection();
    try{

        PreparedStatement smt=(PreparedStatement) c.prepareStatement("update administrator_master set admin_pass='"+p+"' where admin_name='"+n+"'");
        //ResultSet rs=smt.executeUpdate();
        //if(!rs.next() && rs.getRow() == 0) {

//return false;}
//else
        smt.executeUpdate();
    return true;
    }
    catch(Exception e)
    {
    e.printStackTrace();
    System.out.println("here is the problem");
    return false;


    }

}




public String rec_p_clr(String s){
    try{
    c=(Connection) new CommonDB().getConnection();
    PreparedStatement smt= (PreparedStatement) c.prepareStatement("select sec_ques from clerk_master where clr_name='"+s+"'");
    ResultSet rs=smt.executeQuery();

   // System.out.print(q+"");
    if(!rs.next() && rs.getRow() == 0) {

return "no string found here";}
else{
     String q=rs.getString("sec_ques");
    return q;
}
    }
    catch(Exception e){
    return "no string found";
    }
}


public boolean auth_clr(String u,String q,String a)
{

    try{
         c=(Connection) new CommonDB().getConnection();
         PreparedStatement smt=(PreparedStatement) c.prepareStatement("select clr_name, sec_ques, sec_ans from clerk_master where clr_name='"+u+"' and sec_ques='"+q+"' and sec_ans='"+a+"'");
          ResultSet r = smt.executeQuery();
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


public boolean update_clr(String n,String p)
{
   c =(Connection) new CommonDB().getConnection();
    try{

        PreparedStatement smt=(PreparedStatement) c.prepareStatement("update clerk_master set clr_pass='"+p+"' where clr_name='"+n+"'");
        //ResultSet rs=smt.executeUpdate();
        //if(!rs.next() && rs.getRow() == 0) {

//return false;}
//else
        smt.executeUpdate();
    return true;
    }
    catch(Exception e)
    {
    e.printStackTrace();
    System.out.println("here is the problem");
    return false;


    }

}





public String rec_p_stu(String s){
    try{
    c=(Connection) new CommonDB().getConnection();
    PreparedStatement smt= (PreparedStatement) c.prepareStatement("select sec_ques from student_master where st_name='"+s+"'");
    ResultSet rs=smt.executeQuery();

   // System.out.print(q+"");
    if(!rs.next() && rs.getRow() == 0) {

return "no string found here";}
else{
     String q=rs.getString("sec_ques");
    return q;
}
    }
    catch(Exception e){
    return "no string found";
    }
}


public boolean auth_stu(String u,String q,String a)
{

    try{
         c=(Connection) new CommonDB().getConnection();
         PreparedStatement smt=(PreparedStatement) c.prepareStatement("select st_name, sec_ques, sec_ans from student_master where st_name='"+u+"' and sec_ques='"+q+"' and sec_ans='"+a+"'");
          ResultSet r = smt.executeQuery();
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


public boolean update_stu(String n,String p)
{
   c =(Connection) new CommonDB().getConnection();
    try{

        PreparedStatement smt=(PreparedStatement) c.prepareStatement("update student_master set st_password='"+p+"' where st_name='"+n+"'");
        //ResultSet rs=smt.executeUpdate();
        //if(!rs.next() && rs.getRow() == 0) {

//return false;}
//else
        smt.executeUpdate();
    return true;
    }
    catch(Exception e)
    {
    e.printStackTrace();
    System.out.println("here is the problem");
    return false;


    }

}



public String rec_p_fac(String s){
    try{
    c=(Connection) new CommonDB().getConnection();
    PreparedStatement smt= (PreparedStatement) c.prepareStatement("select sec_ques from faculty_master where fac_name='"+s+"'");
    ResultSet rs=smt.executeQuery();

   // System.out.print(q+"");
    if(!rs.next() && rs.getRow() == 0) {

return "no string found here";}
else{
     String q=rs.getString("sec_ques");
    return q;
}
    }
    catch(Exception e){
    return "no string found";
    }
}


public boolean auth_fac(String u,String q,String a)
{

    try{
         c=(Connection) new CommonDB().getConnection();
         PreparedStatement smt=(PreparedStatement) c.prepareStatement("select fac_name, sec_ques, sec_ans from faculty_master where fac_name='"+u+"' and sec_ques='"+q+"' and sec_ans='"+a+"'");
          ResultSet r = smt.executeQuery();
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


public boolean update_fac(String n,String p)
{
   c =(Connection) new CommonDB().getConnection();
    try{

        PreparedStatement smt=(PreparedStatement) c.prepareStatement("update faculty_master set fac_password='"+p+"' where fac_name='"+n+"'");
        //ResultSet rs=smt.executeUpdate();
        //if(!rs.next() && rs.getRow() == 0) {

//return false;}
//else
        smt.executeUpdate();
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
