/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.objects;

/**
 *
 * @author Ritika Sahay
 */
public class Student {
    private int passyr;
    private String name,branch, Category, roll;

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
   
    public void setStuName(String s)
    {
    this.name=s;
    }

    public String getStuName()
    {
    return name;
    }


    public void setBran(String s)
    {
    this.branch=s;
    }

    public String getBran()
    {
    return branch;
    }

    public void setPassYr(int i)
    {
    this.passyr=i;
    }

    public int getPassYr()
    {
    return passyr;
    }

}
