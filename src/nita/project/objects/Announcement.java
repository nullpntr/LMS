/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.objects;

/**
 *
 * @author Anil Bhaskar
 */
public class Announcement {
    private int annId;

    @Override
    public String toString() {
        return annId +" : " +ancmt ;
    }
    private String ancmt, annBy;

    public String getAncmt() {
        return ancmt;
    }

    public void setAncmt(String ancmt) {
        this.ancmt = ancmt;
    }

    public String getAnnBy() {
        return annBy;
    }

    public void setAnnBy(String annBy) {
        this.annBy = annBy;
    }

    public int getAnnId() {
        return annId;
    }

    public void setAnnId(int annId) {
        this.annId = annId;
    }

}
