/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.objects;

/**
 *
 * @author Ritika Sahay
 */
public class BookIndividual {

    
    private String BookName, AuthorName, AccNo, rackNo,  HolderType, Flag, HolderId;

    @Override
    public String toString() {
        return "" + BookName + "" + AuthorName + "" + AccNo ;
    }

    public String getHolderId() {
        return HolderId;
    }

    public void setHolderId(String HolderId) {
        this.HolderId = HolderId;
    }
    private int BookPrice, FlagId;

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String Flag) {
        this.Flag = Flag;
    }
    

   
    public void setFlag(int Flag) {
        this.FlagId = Flag;
    }

    public int getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(int BookPrice) {
        this.BookPrice = BookPrice;
    }

       

    public String getHolderType() {
        return HolderType;
    }

    public void setHolderType(String HolderType) {
        this.HolderType = HolderType;
    }

    public void setRackNo(String rackNo) {
        this.rackNo = rackNo;
    }

    public String getRackNo() {
        return rackNo;
    }

    public void setAccNo(String AccNo) {
        this.AccNo = AccNo;
    }

    public String getAccNo() {
        return AccNo;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public String getBookName() {
        return BookName;
    }

}
