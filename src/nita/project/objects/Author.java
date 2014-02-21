/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.objects;

/**
 *
 * @author Anil Bhaskar
 */
public class Author {
    private int authorId;
    private String authorName;

    public String toString()
    {
        return authorName;
    }

    public String getAuName() {
        return authorName;
    }

    public void setAuName(String aun) {
        this.authorName = aun;
    }


    public void setAuID(int ai)
    {
    this.authorId = ai;
    }

    public int getAuId() {
        return authorId;
    }


}
