/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import nita.project.objects.Announcement;

/**
 *
 * @author Anil Bhaskar
 */
public class AnnouncementDB {

    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Announcement> getAnnouncements() {
        try {
            c = new CommonDB().getConnection();
            String smt = "select ann_id, announcement from announcement order by ann_id DESC";
            System.out.println(smt);
            ps = c.prepareStatement(smt);
            rs = ps.executeQuery();
            ArrayList<Announcement> dd = new ArrayList<Announcement>();
            while (rs.next()) {
                Announcement ab = new Announcement();

                ab.setAnnId(rs.getInt(1));
                ab.setAncmt(rs.getString(2));
                dd.add(ab);
            }
            rs.close();
            ps.close();
            c.close();
            return dd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveAnnouncements(String ann, String annBy) {
        try {
            c = new CommonDB().getConnection();
            String q = "insert into announcement(announcement,ann_By) values(?,?)";
            ps = c.prepareStatement(q);
            ps.setString(1, ann);
            ps.setString(2, annBy);
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
