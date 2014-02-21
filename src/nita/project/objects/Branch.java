

package nita.project.objects;

/**
 *
 * @author Anil Bhaskar
 */
public class Branch {
    private String branchName;
    private int brId;

    public String toString()
    {
        return branchName;
    }

    public String getBrName() {
        return branchName;
    }

    public void setBrName(String brn) {
        this.branchName = brn;
    }

    public int getBrId() {
        return brId;
    }

    public void setBrId(int bri) {
        this.brId = bri;
    }
     
}
