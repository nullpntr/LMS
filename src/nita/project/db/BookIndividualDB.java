/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import nita.project.objects.BookIndividual;

/**
 *
 * @author Anil Bhaskar
 */
public class BookIndividualDB {
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<String> getIndAccNos(String title){
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select book_individual.book_acc_no from book_individual, book_master "
                    + "where book_master.book_id = book_individual.book_id and book_title = '"+title+"'");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
                BookIndividual a = new BookIndividual();

                a.setAccNo(rs.getString(1));
                an.add(a.getAccNo());

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

}
