/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nita.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import nita.project.objects.Admin;
import nita.project.objects.Clerk;
import nita.project.objects.Faculty;
import nita.project.objects.Student;



/**
 *
 * @author Ritika Sahay
 */
public class MemberDB {

    private PreparedStatement ps;
    private ResultSet rs;
    private PreparedStatement pm;
    private Connection c;

    public boolean save_stu(String name, String roll, String pass, int passyr, String email, String br,String ques, String ans,String cat) {
        try {
            c =new CommonDB().getConnection();

//int id = rs.getInt("br_id");
ps =        (PreparedStatement) c.prepareStatement("insert into student_master(st_name, st_roll, st_password, st_pass_yr, st_email, st_branch_id, sec_ques, sec_ans, st_cat) values(?,?,?,?,?,(select br_id from branch_master where br_name = ?),?,?,?)");
System.out.println("Here");
ps.setString(1,name);
ps.setString(3,pass);
ps.setString(2, roll);
ps.setInt(4, passyr);
ps.setString(5,email);
ps.setString(6, br);
ps.setString(7,ques);
ps.setString(8, ans);
ps.setString(9, cat);

ps.executeUpdate();
ps.close();

c.close();
return true;
}
catch(Exception e){
    //e.printStackTrace();
    //
    System.out.print(e);
    return false;
}
}
    public boolean save_admin(String name,String pass,String email,String ques,String ans){
   try{ c =(Connection) new CommonDB().getConnection();
ps =        (PreparedStatement) c.prepareStatement("insert into administrator_master(admin_name,admin_pass,admin_email,sec_ques,sec_ans) values(?,?,?,?,?)");
ps.setString(1,name);
ps.setString(3,email);
ps.setString(2, pass);
ps.setString(4, ques);
ps.setString(5, ans);
ps.executeUpdate();
ps.close();
c.close();
return true;
}
catch(Exception e){
    e.printStackTrace();
    return false;
}}




public boolean save_clr(String name,String email,String pass, int yr_join,String ques,String ans){
try{
c =         (Connection) new CommonDB().getConnection();
ps =        (PreparedStatement) c.prepareStatement("insert into clerk_master(clr_name,clr_email,clr_pass,clr_join_yr,sec_ques,sec_ans) values(?,?,?,?,?,?)");
ps.setString(1,name);
ps.setString(3,pass);
ps.setString(2, email);
ps.setInt(4, yr_join);
ps.setString(5, ques);
ps.setString(6, ans);


ps.executeUpdate();
ps.close();
c.close();
return true;
}
catch(Exception e){
    e.printStackTrace();
    return false;
}}

public boolean save_fac(String name, String pass, String email, String br, String des, String ques, String ans){
try{
c =         (Connection) new CommonDB().getConnection();
ps =        (PreparedStatement) c.prepareStatement("insert into faculty_master(fac_name, fac_password, fac_br_id,fac_designation,fac_email,sec_ques,sec_ans) values(?,?,(select br_id from branch_master where br_name = ?),?,?,?,?)");
ps.setString(1,name);
ps.setString(3,br);
ps.setString(2, pass);
ps.setString(4, des);
ps.setString(5,email);
ps.setString(7, ans);
ps.setString(6, ques);

ps.executeUpdate();
ps.close();
c.close();
return true;
}
catch(Exception e){
    e.printStackTrace();
    return false;
}
}
public ArrayList<String> getStuRoll(){
    try{
        c = new CommonDB().getConnection();
        ps = c.prepareStatement("select st_roll from student_master");
        rs = ps.executeQuery();
        ArrayList<String> an = new ArrayList<String>() ;
        while(rs.next()){
            Student a = new Student();

            a.setRoll(rs.getString(1));
            an.add(a.getRoll());

        }
        rs.close();
        ps.close();
        c.close();
        return an;
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}



public ArrayList<String> getAdmin() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select admin_name from administrator_master");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
                Admin a = new Admin();

                a.setAdminName(rs.getString(1));
                an.add(a.getAdminName());

            }
            rs.close();
            ps.close();
            c.close();
            return an;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



public ArrayList<String> getStu() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select st_name from student_master");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
               Student a = new Student();

                a.setStuName(rs.getString(1));
                an.add(a.getStuName());

            }
            rs.close();
            ps.close();
            c.close();
            return an;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


public ArrayList<String> getclk() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select clr_name from clerk_master");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
               Clerk a = new Clerk();

                a.setClrName(rs.getString(1));
                an.add(a.getClrName());

            }
            rs.close();
            ps.close();
            c.close();
            return an;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



public ArrayList<String> getfac() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select fac_name from faculty_master");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
               Faculty a = new Faculty();

                a.setFacName(rs.getString(1));
                an.add(a.getFacName());

            }
            rs.close();
            ps.close();
            c.close();
            return an;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


public String getStdRoll(String s)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select st_roll from student_master where st_name='"+s+"'");
rs=ps.executeQuery();
Student stu=new Student();
while(rs.next()){
            stu.setRoll(rs.getString(1));
}
return stu.getRoll();
}
catch(Exception e)
{
return null;
}
}

public String getStuName(String roll)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select st_name from student_master where st_roll='"+roll+"'");
Student s=new Student();
rs=ps.executeQuery();
while(rs.next())
{
s.setStuName(rs.getString(1));
}
return s.getStuName();
}
catch(Exception e)
{
return null;
}
}


public String stuBranch(String s)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select branch_master.br_name from (student_master inner join branch_master) where student_master.st_branch_id=branch_master.br_id and student_master.st_name='"+s+"'");
rs=ps.executeQuery();
Student stu=new Student();
while(rs.next())
{
stu.setBran(rs.getString(1));
}
return stu.getBran();
}

catch(Exception e)
{
return null;
}
}

public int getPassYear(String s)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select st_pass_yr from student_master where st_name='"+s+"'");
rs=ps.executeQuery();
Student stu=new Student();
while(rs.next())
{
stu.setPassYr(rs.getInt(1));
}
return stu.getPassYr();
}

catch(Exception e)
{
return 0;
}
}


public boolean delStu(int i)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("delete from  student_master where st_roll='"+i+"'");
ps.executeUpdate();
return true;
}
catch(Exception e)
{
return false;
}

}


public String facBranch(String s)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select branch_master.br_name from (faculty_master inner join branch_master) where branch_master.br_id=faculty_master.fac_br_id and faculty_master.fac_name='"+s+"'");
rs=ps.executeQuery();
 Faculty f=new Faculty();
while(rs.next())
{
f.setFacBran(rs.getString(1));
}
return f.getfacBran();
}

catch(Exception e)
{
return null;
}

}


public String getFacEmail(String s)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select fac_email from faculty_master where fac_name='"+s+"'");
rs=ps.executeQuery();
Faculty f=new Faculty();
while(rs.next()){
f.setFacEmail(rs.getString(1));
}
return f.getfacEmail();
}
catch(Exception e){
return null;
}
}



public boolean delFac(String s)
{try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("delete from  faculty_master where fac_name='"+s+"'");
ps.executeUpdate();
return true;
}
catch(Exception e)
{
return false;
}
}

public int getClrYr(String s)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select clr_join_yr from clerk_master where clr_name='"+s+"'");
rs=ps.executeQuery();
Clerk clr=new Clerk();
while(rs.next())
{
clr.setClrjoin(rs.getInt(1));
}
return clr.getClrjoin();
}

catch(Exception e)
{
return 0;
}
}


public boolean delClr(String s)
{try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("delete from  clerk_master where clr_name='"+s+"'");
ps.executeUpdate();
return true;
}
catch(Exception e)
{
return false;
}
}



public int getFacId(String s)
{
    try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select fac_id from faculty_master where fac_name='"+s+"'");
rs=ps.executeQuery();
Faculty f=new Faculty();
while(rs.next()){
f.setFacID(rs.getInt(1));
}
return f.getfacID();
}
catch(Exception e)
{
return 0;
}
}
public ArrayList<Student> WaitingStudent()
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select student_master.st_name, student_master.st_roll,branch_master.br_name,student_master.st_cat from student_master, branch_master where branch_master.br_id=student_master.st_branch_id and student_master.st_valid='N'");
System.out.println(ps);
rs=ps.executeQuery();
ArrayList<Student> dd=new ArrayList<Student>();
while(rs.next())
{
Student s=new Student();
s.setStuName(rs.getString(1));
s.setRoll(rs.getString(2));;
s.setBran(rs.getString(3));
s.setCategory(rs.getString(4));
dd.add(s);
}
return dd;
}
catch(Exception e)
{
return null;
}
}


public boolean ConfirmStudenteRegistration(String id)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("update student_master set st_valid='Y' where st_roll='"+id+"'");
ps.executeUpdate();
return true;
}
catch(Exception e)
{
return false;
}
}


public boolean RemoveStudentRegistration(Integer id)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("delete from student_master where st_roll='"+id+"'");
ps.executeUpdate();
return true;
}
catch(Exception e)
{
return false;
}
}


public ArrayList<Faculty> WaitingFaculty()
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select faculty_master.fac_name,branch_master.br_name,faculty_master.fac_designation from (faculty_master,branch_master) where faculty_master.fac_br_id=branch_master.br_id and faculty_master.fac_valid='N'");
rs=ps.executeQuery();
ArrayList<Faculty> dd=new ArrayList<Faculty>();
while(rs.next())
{
Faculty f=new Faculty();
f.setFacName(rs.getString(1));
f.setFacBran(rs.getString(2));
f.setDesignation(rs.getString(3));
dd.add(f);
}
return dd;
}

catch(Exception e)
{
return null;
}
}

public boolean ConfirmFacultyRegistration(String name)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("update faculty_master set fac_valid='Y' where fac_name='"+name+"'");
ps.executeUpdate();
return true;
}
catch(Exception e)
{
return false;
}
}


public boolean RemoveFacultyRegistration(String name)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("delete from faculty_master where fac_name='"+name+"'");
ps.executeUpdate();
return true;
}
catch(Exception e)
{
return false;
}
}



public ArrayList<Clerk> WaitingClerk()
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("select clr_name,clr_join_yr from clerk_master where clr_valid='N'");
rs=ps.executeQuery();
ArrayList<Clerk> dd=new ArrayList<Clerk>();
while(rs.next())
{
Clerk f=new Clerk();
f.setClrName(rs.getString(1));
f.setClrjoin(rs.getInt(2));dd.add(f);
}
return dd;
}

catch(Exception e)
{
return null;
}
}

public boolean ConfirmClerkRegistration(String name)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("update clerk_master set clr_valid='Y' where clr_name='"+name+"'");
ps.executeUpdate();
return true;
}
catch(Exception e)
{
return false;
}
}


public boolean RemoveClerkRegistration(String name)
{
try{
c=new CommonDB().getConnection();
ps=c.prepareStatement("delete from clerk_master where clr_name='"+name+"'");
ps.executeUpdate();
return true;
}
catch(Exception e)
{
return false;
}
}


}
