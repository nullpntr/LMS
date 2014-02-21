/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.db;

/**
 *
 * @author Anil Bhaskar
 */
public class Session {

    private static int session;

    public static int getSession() {
        return session;
    }

    public static void setSession(int session) {
        Session.session = session;
    }

}
