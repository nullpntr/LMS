/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.objects;

/**
 *
 * @author Anil Bhaskar
 */
public class Book {

    private String title;
    private int author_id;
    private int author_id1;
    private int author_id2;
    private int edId, BkId;

    public int getBkId() {
        return BkId;
    }

    public void setBkId(int BkId) {
        this.BkId = BkId;
    }

    public int getAuthor_id1() {
        return author_id1;
    }

    public void setAuthor_id1(int author_id1) {
        this.author_id1 = author_id1;
    }

    public int getAuthor_id2() {
        return author_id2;
    }

    public void setAuthor_id2(int author_id2) {
        this.author_id2 = author_id2;
    }

    public int getEdId() {
        return edId;
    }

    public void setEdId(int edId) {
        this.edId = edId;
    }
    private int bk_brId;
    private int price;


    public String toString()
    {
        return title +" ";
    }
     public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        this.title = t;
    }

     public int getAuId() {
        return author_id;
    }

    public void setAuId(int ai) {
        this.author_id = ai;
    }

     public int getBkPrice() {
        return price;
    }

    public void setBkPrice(int p) {
        this.price = p;
    }

     public int getBkBrId() {
        return bk_brId;
    }

    public void setBkBrId(int bbi) {
        this.bk_brId = bbi;
    }
}
