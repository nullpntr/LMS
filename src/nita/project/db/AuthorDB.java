/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import nita.project.objects.Author;

/**
 *
 * @author Anil Bhaskar
 */
public class AuthorDB {

    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Integer> getAuthorId(String str){
        try{
            c = new CommonDB().getConnection();
            Author a = new Author();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            String q = "select author_id from author_master where author_name like '%"+str+"%' and author_id>0";
            System.out.println(q);
            ps = c.prepareStatement(q);
            rs = ps.executeQuery();

            while(rs.next()){
              a.setAuID(rs.getInt(1));

            }
            arr.add(a.getAuId());
            return arr;


        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public int gen_auth_id(String s)
    {
    try{
    c=new CommonDB().getConnection();
    ps=(PreparedStatement)c.prepareStatement("select author_id from author_master where author_name like '"+s+"%'");
    rs=ps.executeQuery();
    Author a=new Author();
    while(rs.next())
    {

   a.setAuID(rs.getInt(1));

    }
return a.getAuId();
    }
    catch(Exception e)
    {
    return 0;
    }

    }


}
