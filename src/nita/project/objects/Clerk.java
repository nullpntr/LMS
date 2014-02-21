/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.objects;

/**
 *
 * @author Ritika Sahay
 */
public class Clerk {
    private String name;
    private int join_yr;
    public void setClrName(String s)

    {
    this.name=s;

    }

    public String getClrName()
    {
    return name;
    }

    public void setClrjoin(int d)
    {
    this.join_yr=d;
    }

    public int getClrjoin()
    {
    return join_yr;
    }

}
