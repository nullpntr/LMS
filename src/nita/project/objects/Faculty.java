/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.objects;

/**
 *
 * @author Ritika Sahay
 */
public class Faculty {
    private String name,email;
    private String branch, Designation;

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }
    private int id;

    public void setFacName(String s)
    {
    this.name=s;
    }

    public String getFacName()
    {
    return name;
    }

    public void setFacBran(String s)
    {
    this.branch=s;
    }

    public String getfacBran()
    {
    return branch;
    }

     public void setFacEmail(String s)
    {
    this.email=s;
    }

    public String getfacEmail()
    {
    return email;
    }


    public void setFacID(int s)
    {
    this.id=s;
    }

    public int getfacID()
    {
    return id;
    }
}
