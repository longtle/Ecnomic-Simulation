/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Execute;
import ClientSide.WorkerGUI;
import ServerSide.*;
import ClientSide.*;

/**
 *
 * @author THANH LONG
 */
public class Main {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkerGUI().setVisible(true);
            }
        });
    }
}
